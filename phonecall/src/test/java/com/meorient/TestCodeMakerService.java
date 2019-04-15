/** */
package com.meorient;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.druid.util.StringUtils;
import com.meorient.common.codemaker.po.CodeMakerCfg;
import com.meorient.common.codemaker.service.AbsCodeMakerService;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:26:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.meorient.phonecall.PhonecallApplication.class)
public class TestCodeMakerService extends AbsCodeMakerService {
	/**
	 * @设置 单条sql操作模板
	 */
	@Autowired
	@Qualifier("masterDBSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 生成代码
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void testGenerateCode() throws Exception {
		String dbName = "data_center";
		List<String> tableNames = new ArrayList<String>();
		tableNames.add("synchroLog");

		String autherName = "chuxu";
		String subProjectPackage = "com.meorient.phonecall";
		String notGenerateFields = "id,createrId,createrName,createTime,modId,modName,modTime,";
		notGenerateFields += "telEnc,emailEnc,bankCardCodeEnc,bankCardTelEnc,idCardCodeEnc,idCardNameEnc";

		String[] notGenerateTemplates = {"Controller.java","Test.java","Service.java","Dao.java"};
		Pattern pattern = Pattern.compile("^([a-z]*)");
		for (String tableName : tableNames) {
			Matcher m = pattern.matcher(tableName);
			if (m.find()) {
				String modlePackage = subProjectPackage + "." + m.group();
				if (!StringUtils.isEmpty(tableName)) {
					CodeMakerCfg cfg = new CodeMakerCfg();
					cfg.setDb(dbName);
					cfg.setTableName(tableName);
					cfg.setAutherName(autherName);
					cfg.setModlePackage(modlePackage);
					cfg.setNotGenerateFields(notGenerateFields);
					cfg.setNotGenerateTemplates(notGenerateTemplates);
					this.generateCode(cfg, sqlSessionTemplate);
				}
			}
		}
	}

}
