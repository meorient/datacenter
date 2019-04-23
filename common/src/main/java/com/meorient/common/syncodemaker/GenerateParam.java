package com.meorient.common.syncodemaker;

import java.util.Map;

import com.meorient.common.pojo.BasePojo;

/**
 * @功能: 生成模板所需要的动态参数
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年4月22日下午4:41:31
 */
public class GenerateParam extends BasePojo {
	/** 作者 */
	private String authorName;

	/** 项目名称 */
	private String projectName;

	/** 项目一级包名 */
	private String packageAName;

	/** 项目二级包名 */
	private String packageBName;

	/** 项目三级包名 */
	private String packageCName;

	/** 同步来源 */
	private String dbSourceName;

	/** 同步目标 */
	private String dbTargetName;

	/** 同步表 */
	private String tableSourceName;

	/** 目标表 */
	private String tableTargetName;

	/** 字段映射 */
	private Map<String, String> fieldRelationMap;

	/** 不生java属性的列信息 */
	private String notGenerateFields = "";

	/** 生成代码的模板路径 */
	private String templateBasePath = "/codetemplate_sync";

	/** 不生的模板 */
	private ECodeMakerTemplate[] ungenerateTemplate;

	/**
	 * @取得 authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @设置 authorName
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @取得 projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @设置 projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @取得 packageAName
	 */
	public String getPackageAName() {
		return packageAName;
	}

	/**
	 * @取得 tableSourceName
	 */
	public String getTableSourceName() {
		return tableSourceName;
	}

	/**
	 * @设置 tableSourceName
	 */
	public void setTableSourceName(String tableSourceName) {
		this.tableSourceName = tableSourceName;
	}

	/**
	 * @取得 tableTargetName
	 */
	public String getTableTargetName() {
		return tableTargetName;
	}

	/**
	 * @设置 tableTargetName
	 */
	public void setTableTargetName(String tableTargetName) {
		this.tableTargetName = tableTargetName;
	}

	/**
	 * @设置 packageAName
	 */
	public void setPackageAName(String packageAName) {
		this.packageAName = packageAName;
	}

	/**
	 * @取得 packageBName
	 */
	public String getPackageBName() {
		return packageBName;
	}

	/**
	 * @设置 packageBName
	 */
	public void setPackageBName(String packageBName) {
		this.packageBName = packageBName;
	}

	/**
	 * @取得 packageCName
	 */
	public String getPackageCName() {
		return packageCName;
	}

	/**
	 * @设置 packageCName
	 */
	public void setPackageCName(String packageCName) {
		this.packageCName = packageCName;
	}

	/**
	 * @取得 dbSourceName
	 */
	public String getDbSourceName() {
		return dbSourceName;
	}

	/**
	 * @设置 dbSourceName
	 */
	public void setDbSourceName(String dbSourceName) {
		this.dbSourceName = dbSourceName;
	}

	/**
	 * @取得 dbTargetName
	 */
	public String getDbTargetName() {
		return dbTargetName;
	}

	/**
	 * @设置 dbTargetName
	 */
	public void setDbTargetName(String dbTargetName) {
		this.dbTargetName = dbTargetName;
	}

	/**
	 * @取得 fieldRelationMap
	 */
	public Map<String, String> getFieldRelationMap() {
		return fieldRelationMap;
	}

	/**
	 * @设置 fieldRelationMap
	 */
	public void setFieldRelationMap(Map<String, String> fieldRelationMap) {
		this.fieldRelationMap = fieldRelationMap;
	}

	/**
	 * @取得 notGenerateFields
	 */
	public String getNotGenerateFields() {
		return notGenerateFields;
	}

	/**
	 * @设置 notGenerateFields
	 */
	public void setNotGenerateFields(String notGenerateFields) {
		this.notGenerateFields = notGenerateFields;
	}

	/**
	 * @取得 templateBasePath
	 */
	public String getTemplateBasePath() {
		return templateBasePath;
	}

	/**
	 * @设置 templateBasePath
	 */
	public void setTemplateBasePath(String templateBasePath) {
		this.templateBasePath = templateBasePath;
	}

	/**
	 * @取得 ungenerateTemplate
	 */
	public ECodeMakerTemplate[] getUngenerateTemplate() {
		return ungenerateTemplate;
	}

	/**
	 * @设置 ungenerateTemplate
	 */
	public void setUngenerateTemplate(ECodeMakerTemplate[] ungenerateTemplate) {
		this.ungenerateTemplate = ungenerateTemplate;
	}
}
