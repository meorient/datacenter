package com.meorient.phonecall.service.temp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.meorient.common.util.HttpClientTool;
import com.meorient.common.util.JsonTool;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年4月30日上午11:55:30
 */
public class TaskQuery {

	
	public static void main(String[] args) throws Exception {
			// 必填
			
			Map<String, String> headers = new HashMap<String,String>();
			headers.put("cookie", "JSESSIONID="+Config.JSESSIONID+"; Hm_lvt_6abcc5eeee320072f7a9ed10e79be5c1=1555658542; gr_user_id=a375d114-a352-464d-93bf-a1064e54d348; Hm_lpvt_6abcc5eeee320072f7a9ed10e79be5c1=1555658542");
			
			String result = HttpClientTool.get(HttpClientTool.getSSLContext(),null, "https://40.73.105.15/wxqyh-web/visit/visitPlan!searchVisitApprovalList.action?page=1&limit=2000&customerName=&salesmanName=&date=2019-05-01+-+2019-05-04&dqdp_csrf_token="+Config.TOKEN
					, headers);
			System.out.println(result);
			Map<String,Object> map = JsonTool.getMap(result, String.class,Object.class);
			Object obj = map.get("data");
			result = JsonTool.getString(obj);
			map = JsonTool.getMap(result, String.class,Object.class);
			obj = map.get("pageData");
			result = JsonTool.getString(obj);
			List<Query> resultList = JsonTool.getList(result, Query.class);
			
			HashMap<String,String> params = new HashMap<String,String>();
			int count = 0;
			String audit = "";
			for(int i=0;i<resultList.size();i++) {
				params.put("summary", "{\"approvalInfo\":\"\",\"approvalStatus\":\"1\",\"id\":\""+resultList.get(i).getId()+"\",\"approvalId\":1,\"type\":\"1\"}") ;
				System.out.println(params);
				try {
					audit = HttpClientTool.postParames(HttpClientTool.getSSLContext(), "https://40.73.105.15/wxqyh-web/visit/visitPlan!updateVisitApproval.action?dqdp_csrf_token="+Config.TOKEN, headers,params);
				}catch(Exception e) {
					Thread.currentThread();
					Thread.sleep(20000L);
					i--;
					continue;
				}
				System.out.println(audit);
				System.out.println("已完成：" + ++count);
			}
			System.out.println("全部完成");
		}
}
