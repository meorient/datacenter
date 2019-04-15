package com.meorient.phonecall.dao.phonecall;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meorient.phonecall.dao.base.BaseDao;
import com.meorient.phonecall.pojo.phonecall.PhoneCall;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年3月21日上午9:09:40
 */
@Repository
public class PhoneCallDao extends BaseDao<PhoneCall>{
	/**
	 * 查询用户被分享的电话记录
	 * @param pc
	 * @return
	 */
	public List<PhoneCall> selectShareList(PhoneCall pc){
		return selectList("selectShareList", pc);
	}
}
