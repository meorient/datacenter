package com.meorient.phonecall.service.temp;

import java.util.HashMap;
import java.util.Map;

import com.meorient.common.util.HttpClientTool;
import com.meorient.common.util.JsonTool;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年4月30日上午10:55:33
 */
public class TaskAddError {
	static String[] custId = {"57047","56673","56908","56908"};
	static String[] custName = {"龚红月","李坤","徐金陆","徐金陆"};
	
	public static void main(String[] args) throws Exception {
		String[] companyId = {"341607","3007688","145941","1264066"};
		String[] companyName = {"深圳市达兴达贸易有限公司","建德市天时伞业有限公司","嘉兴市良友制衣有限公司","嘉兴斯创服饰有限公司"};
		if(custId.length!=custName.length || companyId.length!=companyId.length||custName.length!=companyName.length) {
			System.out.println("数量不一致");
			return;
		}
		
		int count = 0;
		
		Map<String,String> params = new HashMap<String,String>();
		temp t = new temp();
		temp2 t2 = new temp2();
		t.setAddress("-");
		// 必填
		for(int i=count;i<custId.length;i++) {
			t.setSalesmanCode(String.valueOf(custId[i]));
			t2.setVisitPerson(String.valueOf(custId[i]));
			t2.setActualParticipant(String.valueOf(custId[i]));
		t.setCompanyName(String.valueOf(companyName[i]));
		t.setCustomerCode(String.valueOf(companyId[i]));
		t.setSalesmanName(String.valueOf(custName[i]));
		
		t2.setCustomerId(String.valueOf(companyId[i]));
		t2.setVisitCustomer(String.valueOf(companyName[i]));
		t2.setPersonOfBusinessTrip(String.valueOf(custName[i]));
		
		t2.setDateOfBusinessTrip("2019-05-01");
		params.put("maltCrmVisit", JsonTool.getString(t));
		params.put("maltCrmVisitInfo", JsonTool.getString(t2));
		
		Map<String, String> headers = new HashMap<String,String>();
		System.out.println(params);
		headers.put("cookie", "JSESSIONID="+Config.JSESSIONID+"; Hm_lvt_6abcc5eeee320072f7a9ed10e79be5c1=1555658542; gr_user_id=a375d114-a352-464d-93bf-a1064e54d348; Hm_lpvt_6abcc5eeee320072f7a9ed10e79be5c1=1555658542");
		
		String result = HttpClientTool.postParames(HttpClientTool.getSSLContext(), "https://40.73.105.15/wxqyh-web/visit/visitPlan!addVisitPlan.action?dqdp_csrf_token="+Config.TOKEN, headers,params);
		System.out.println(result);
		System.out.println("已完成：" + ++count);
		
		Thread.currentThread();
		Thread.sleep(250L);
		}
	}
}
