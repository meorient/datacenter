package com.meorient.common.syncodemaker;

import java.util.List;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年4月23日上午9:17:56
 */
public class SyncTemplateGenerater extends SimpleCodeTemplateGenerater implements CodeTemplateGenerater{
	
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
			/** 生成参数信息,取得模板目录、项目根目录 */
//		File projectDir = getDataMap(param, columnList);
	
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
	}
}
