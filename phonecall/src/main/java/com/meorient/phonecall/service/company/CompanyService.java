/** */
package com.meorient.phonecall.service.company;

import org.springframework.stereotype.Service;

import com.meorient.phonecall.service.base.BaseService;
import com.meorient.phonecall.service.iservice.ICompanyService;
import com.meorient.phonecall.dao.company.CompanyDao;
import com.meorient.phonecall.pojo.company.Company;

/**
 * @功能:【company 公司】Service
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 12:23:09
 * @说明：<pre></pre>
 */
@Service
public class CompanyService extends BaseService<Company, CompanyDao> implements ICompanyService {

}
