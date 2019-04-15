package com.meorient.phonecall.controller.phonecall;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meorient.common.constant.EMsgCommon;
import com.meorient.common.pojo.OptResult;
import com.meorient.common.pojo.ResponseData;
import com.meorient.phonecall.configuration.SessionManager;
import com.meorient.phonecall.pojo.phonecall.PhoneCall;
import com.meorient.phonecall.pojo.user.User;
import com.meorient.phonecall.service.iservice.IPhoneCallService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.model.GetObjectRequest;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午8:35:49
 */
@RestController
@RequestMapping("/phonecall")
public class PhoneCallController {
	
	/** 日志对象 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private IPhoneCallService phoneCallService;
	
	@Autowired
	private COSClient cosClient;
	
	/**
	 * 查询个人电话记录、下属记录、被分享记录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/api/getPhoneCallListPro/v1")
	public ResponseData getPhoneCallList(PhoneCall pc, HttpServletRequest request, HttpServletResponse response) {
		if(pc.getDepartmentId() == null) {
			pc.setDepartmentId(SessionManager.getCurrentUser(request).getDepartmentId());
		}
		List<User> resultList = phoneCallService.getPhoneCallList(pc);
		OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
		return new ResponseData(info,resultList);
	}
	
	/**
	 * 得到录音文件：接口待整理
	 * @param pc
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getPhoneCallFilePub/v1")
	public  void getPhoneCallFile(String name, HttpServletRequest request, HttpServletResponse response) {
		
		// 从avaya数据库中查找文件名称
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String fileName = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://10.20.0.67:1433;DatabaseName=dbctrecorder","sa","Wilcom01");
            
            String sql = "select FileName from FileDetail where CallID = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, name);
            res = statement.executeQuery();
            while(res.next()){
            	fileName = res.getString("FileName");                                                                                                                                  ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
        if(StringUtils.isEmpty(fileName)) {
        	logger.info("没有从avaya找到源文件, select FileName from FileDetail where CallID ="+name);
        	return ;
        }
		// 从微信云下载文件
        int start = fileName.lastIndexOf("\\");
        int end = fileName.lastIndexOf(".");
        fileName = fileName.substring(start+1,end);
        String bucketName = "recordtest-1258904443";
        String key = fileName + ".mp3";
        response.setContentType("audio/mp3");
		GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
		COSObject cosObject = cosClient.getObject(getObjectRequest);
		COSObjectInputStream cosObjectInput = null;
		OutputStream outputStream = null;
		logger.info("从COS查找文件名称："+fileName);
		try {
			cosObjectInput = cosObject.getObjectContent();
			outputStream = new BufferedOutputStream(response.getOutputStream());
			
			byte[] buff =new byte[1024];
			int n;
			while((n=cosObjectInput.read(buff))!=-1){
				outputStream.write(buff,0,n);
			}
			outputStream.flush();
		}catch(Exception e) {
			logger.info("下载中弄断，客户端关闭连接");
		}finally {
			try {
				//关流
				outputStream.close();
				cosObjectInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
