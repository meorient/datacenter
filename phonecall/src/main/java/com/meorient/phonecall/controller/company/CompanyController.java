/** */
package com.meorient.phonecall.controller.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meorient.phonecall.pojo.company.Company;

/**
 * @功能:【company 公司】controller
 * @项目名:datacenter
 * @作者:chuxu
 * @日期:2019-03-21 12:23:09
 * @说明：<pre></pre>
 */
@RestController
@RequestMapping("/company")
public class CompanyController{
	/** company 公司service*/
	//    @Autowired
	//    private ICompanyService companyService;
    
  	/**
	 * get
	 * @param company
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(Company company, HttpServletRequest request, HttpServletResponse response) {

	}
}
