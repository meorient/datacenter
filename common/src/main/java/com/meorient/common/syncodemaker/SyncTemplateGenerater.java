package com.meorient.common.syncodemaker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.util.Set;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年4月23日上午9:17:56
 */
public class SyncTemplateGenerater extends SimpleCodeTemplateGenerater implements CodeTemplateGenerater{
	
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	private List<ColumnInfo> sourceColumns;
	
	private List<ColumnInfo> targetColumns;
	
	/**
	 * 构造函数
	 * @param templateBasePath
	 * @param targetTable
	 * @param sourceTable
	 * @param targetDB
	 * @param sourceDB
	 */
	SyncTemplateGenerater(GenerateParam param){
		this.getColumnInfo(param);
		this.generate(param);
	}
	
	public void generateCode(){
		super.generateCode();
	}
	
	/**
	 * 设置参数
	 */
	@Override
	public void getColumnInfo(GenerateParam param) {
		SynCodeMakerDao dao = new SynCodeMakerDao();
		ColumnInfo sourceColumn = new ColumnInfo();
		sourceColumn.setDb(param.getDbSourceName());
		sourceColumn.setTableName(param.getTableSourceName());
		
		ColumnInfo targetColumn = new ColumnInfo();
		targetColumn.setDb(param.getDbTargetName());
		targetColumn.setTableName(param.getTableTargetName());
		
		sourceColumns = dao.selectList(sourceColumn);
		targetColumns = dao.selectList(targetColumn);
	}
	
	/**
	 * 生成代码
	 */
	@Override
	public void generate(GenerateParam param) {
		/** 取得模板目录、项目根目录 */
		String templateBasePath = GenerateParam.class.getClass().getResource(param.getTemplateBasePath()).getFile();
		templateBasePath = tidyFileUrl(templateBasePath, null);
		File templateBaseDir = new File(templateBasePath);
		Set<String> templateNames = new HashSet<String>();
		getTemplatesByBaseDir(templateBaseDir, templateNames, templateBaseDir);// 找到目录下的所有模板
	
		/** 生成模板 */
		boolean isOk = makerCode(templateBaseDir, templateNames, cfg, projectDir, dataMap);
		if (isOk) {
			logger.info("文件生成成功");
		}
		
		
		// 初始化模板
		Configuration markerCfg = new Configuration(Configuration.VERSION_2_3_25);
		markerCfg.setDirectoryForTemplateLoading(templateBaseDir);

		// 生成代码
		String classFileName = null;
		File classFile = null;
		Template template = null;
		for (String tpName : templateNames) {

			classFileName = tidyFileUrl(tpName, dataMap);
			classFile = new File(projectDir, classFileName);
			if (classFile.exists()) {
				logger.info("文件已存在，跳过生成：{}", classFile.getPath());
				continue;
			} else {
				File fileParent = classFile.getParentFile();
				if (!fileParent.exists()) {
					fileParent.mkdirs();
				}
			}
//
//			FileOutputStream fos = new FileOutputStream(classFile);
//			OutputStreamWriter streamWriter = new OutputStreamWriter(fos, cfg.getFileEncoding());
//			try {
//				template = markerCfg.getTemplate(tpName);
//				template.process(dataMap, streamWriter);
//				streamWriter.flush();
//			} catch (Exception ex) {
//				classFile.delete();
//				logger.info("文件生成失败", ex);
//				return false;
//			} finally {
//				streamWriter.close();
//				fos.close();
//			}
//		}
//		return true;
//	}
	}
	
	/**
	 * 整理url，将url中参数替换，并将“\”替换成“/”
	 * 
	 * @param url
	 * @param dataMap 可以为空
	 * @return
	 */
	private String tidyFileUrl(String url, GenerateParam param) {
		// templateBasePath=/E:/1_myProject/5_git/zfLendingPlatform/dunningCommon/target/classes/codemakertemplate
		if (url.startsWith("/") && url.indexOf(":") > 0) {
			url = url.substring(1);// 替换盘符前的“/”
		}
		if (param != null) {
			for (Entry<String, Object> entry : param.entrySet()) {
				url = url.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue().toString());
			}
			url = url.replaceAll("\\.ftl", "");
		}
		url = url.replaceAll("\\\\", "/");
		url = url.replaceAll("//", "/");
		return url;
	}
	
	/**
	 * 找到baseDir目录下的所有模板
	 * 
	 * @param baseDir
	 * @param templateNames
	 * @param currDir
	 */
	private void getTemplatesByBaseDir(File baseDir, Set<String> templateNames, File currDir) {
		if (currDir.isDirectory()) {
			for (File tempDir : currDir.listFiles()) {
				getTemplatesByBaseDir(baseDir, templateNames, tempDir);
			}
		} else {
			String tpName = currDir.getPath().substring(baseDir.getPath().length());
			templateNames.add(tidyFileUrl(tpName, null));
		}
	}
}
