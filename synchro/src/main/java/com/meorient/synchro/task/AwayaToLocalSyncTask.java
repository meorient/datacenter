package com.meorient.synchro.task;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.meorient.synchro.pojo.dynamics.DyPhoneCall;
import com.meorient.synchro.pojo.ns.NSDepartment;
import com.meorient.synchro.pojo.ns.NSUser;
import com.meorient.synchro.pojo.sync.Department;
import com.meorient.synchro.pojo.sync.PhoneCall;
import com.meorient.synchro.pojo.sync.User;
import com.meorient.synchro.service.iservice.dynamics.IDyPhoneCallService;
import com.meorient.synchro.service.iservice.ns.INSDepartmentService;
import com.meorient.synchro.service.iservice.ns.INSUserService;
import com.meorient.synchro.service.iservice.sync.IDepartmentService;
import com.meorient.synchro.service.iservice.sync.IPhoneCallService;
import com.meorient.synchro.service.iservice.sync.IUserService;

/**
 * @功能:同步Dynamics数据
 * @项目名:synchro
 * @作者:chuxu
 * @日期:2019年3月19日下午2:58:05
 */
@Component
public class AwayaToLocalSyncTask {
	
	@Autowired
	private INSDepartmentService nsDepartmentService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private INSUserService nsUserService;
	
	@Autowired
	private IDyPhoneCallService dyPhoneCallService;
	
	@Autowired
	private IPhoneCallService phoneCallService;
	
	/** 日志对象 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * 数据同步
	 * 每天同步NS的部门
	 * @throws IOException 
	 * @throws SQLException 
	 */
	@Scheduled(cron = "0 0 2 * * ?")
	public void task() throws IOException, SQLException {
		int mod = 0;
		int add = 0;
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// 部门表同步，数据量大约几百，采用全量比对同步
		List<NSDepartment> nslist = nsDepartmentService.selectList(new NSDepartment());
		Map<String,Department> localmap = departmentService.selectMap(new Department() , "uid");
		
		logger.info("NS部门同步，得到NS数据量为" + nslist.size() + "条 ，本地数据量为：" + localmap.size() + "条");
		
		// 遍历所有NS数据，通过name查找本地数据
		Iterator<NSDepartment> it = nslist.iterator();
		NSDepartment nsDepartment = null;
		Department department = null;
		Long nsDid = null;
		while(it.hasNext()) {
			nsDepartment = it.next();
			nsDid = nsDepartment.getDepartment_Id();
			department =  localmap.get(nsDid.toString());
			if(department == null) {
				// 单条增量同步，添加Log
				add += departmentService.nsAddSync(nsDepartment, now);
			} else {
				// 单条修改同步，添加Log
				if(departmentService.checkSync(nsDepartment, department)) {
					mod += departmentService.nsModSync(nsDepartment, now);
				}
			}
		}
		// 修正上属部门id
		departmentService.nsFixSync(department);
		logger.info("NS部门同步任务同步完成，新增数量：" + add + "，修改数量" + mod);
		// 注：删除业务暂未考虑
	}
	
	/**
	 * 数据同步
	 * 每天同步NS的用户
	 * @throws IOException 
	 * @throws SQLException 
	 */
	@Scheduled(cron = "0 10 2 * * ?")
	public void task2() throws IOException, SQLException {
		int mod = 0;
		int add = 0;
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// 用户表同步，数据量大约几百，采用全量比对同步
		List<NSUser> nslist = nsUserService.selectList(new NSUser());
		Map<String,User> localmap = userService.selectMap(new User() , "uid");
		
		logger.info("NS用户同步，得到NS数据量为" + nslist.size() + "条 ，本地数据量为：" + localmap.size() + "条");
		
		// 遍历所有NS数据，通过uid查找本地数据
		Iterator<NSUser> it = nslist.iterator();
		NSUser nsUser = null;
		User user = null;
		Long nsUid = null;
		while(it.hasNext()) {
			nsUser = it.next();
			nsUid = nsUser.getEmployee_id();
			user =  localmap.get(nsUid.toString());
			if(user == null) {
				// 单条增量同步，添加Log
				add += userService.nsAddSync(nsUser, now);
			} else {
				// 单条修改同步，添加Log
				if(userService.checkSync(nsUser, user)) {
					mod += userService.nsModSync(nsUser, now);
				}
			}
		}
		// 修正上属部门id
		userService.nsFixSync(user);
		logger.info("NS部门同步任务同步完成，新增数量：" + add + "，修改数量" + mod);
		// 注：删除业务暂未考虑
	}
	
	/**
	 * 数据同步
	 * 每天同步dynamics的电话记录
	 */
	@Scheduled(cron = "0 0 3 * * ?")
	public void phoneCallSync() {
		int rowNum = 0;
		int rowSize = 5000;
		// 电话记录同步，数据量较大，分页同步
		List<PhoneCall> locallist = phoneCallService.selectList(new PhoneCall());
		DyPhoneCall dypc = new DyPhoneCall();
		
		logger.info("dynamics电话记录同步");
		
		LocalDateTime beginTime = null;
		if(locallist.isEmpty()) {
			// 同步19年以后所有数据
			beginTime = LocalDateTime.of( 2019, 1, 1, 0, 0 );
			dypc.setBeginTime(Timestamp.valueOf(beginTime));
		}else {
			// 同步昨天数据
			beginTime = LocalDateTime.of(LocalDate.now().minusDays(1L), LocalTime.MIN);
			dypc.setBeginTime(Timestamp.valueOf(beginTime));
		}
		dypc.setRowNum(rowNum);
		dypc.setRowSize(rowSize);
		
		// 遍历所有dynamics数据S
		Iterator<DyPhoneCall> it = null;
		DyPhoneCall dyPhoneCall = null;
		List<DyPhoneCall> dylist = null;
		do{
			dylist = dyPhoneCallService.selectList(dypc);
			it = dylist.iterator();
			while(it.hasNext()) {
				dyPhoneCall = it.next();
				phoneCallService.dyAddSync(dyPhoneCall);
			}
			rowNum += dylist.size();
			dypc.setRowNum(rowNum);
		}while(dylist.size() == rowSize);
		// 数据修正，关联用户id，重名处理
		phoneCallService.dyFixSync(new PhoneCall());
		logger.info("dynamics电话记录同步完成，新增数量：" + rowNum );
	}
}
