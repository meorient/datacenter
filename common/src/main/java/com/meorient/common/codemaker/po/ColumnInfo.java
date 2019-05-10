/** */
package com.meorient.common.codemaker.po;

import com.meorient.common.pojo.BasePojo;
import lombok.Data;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午9:45:43
 */
public class ColumnInfo extends BasePojo {
	// UID
	private static final long serialVersionUID = 1L;

	// 数据库
	public String db;

	// 表名
	public String tableName;

	// 表注释
	public String tableComment;

	// 列名
	public String columnName;

	// 数据类型
	public String dataType;

	// 长度
	public int colLength;

	// 精度
	public int scale;

	// 列注释
	public String columnComment;

	// java类名，首字母小写
	public String className;

	// java类名，首字母大写
	public String capClassName;

	// java属性数据类型
	public String fieldType;

	// java属性名 ，首字母小写
	public String fieldName;

	// java属性名 ，首字母大写
	public String capFieldName;

	// 产生类的属性
	public boolean ableMakerField = true;

	/**
	 * @取得 db
	 */
	public String getDb() {
		return db;
	}

	/**
	 * @设置 db
	 */
	public void setDb(String db) {
		this.db = db;
	}

	/**
	 * @取得 tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @设置 tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @取得 tableComment
	 */
	public String getTableComment() {
		return tableComment;
	}

	/**
	 * @设置 tableComment
	 */
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	/**
	 * @取得 columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @设置 columnName
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @取得 dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @设置 dataType
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @取得 colLength
	 */
	public int getColLength() {
		return colLength;
	}

	/**
	 * @设置 colLength
	 */
	public void setColLength(int colLength) {
		this.colLength = colLength;
	}

	/**
	 * @取得 scale
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * @设置 scale
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}

	/**
	 * @取得 columnComment
	 */
	public String getColumnComment() {
		return columnComment;
	}

	/**
	 * @设置 columnComment
	 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	/**
	 * @取得 className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @设置 className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @取得 capClassName
	 */
	public String getCapClassName() {
		return capClassName;
	}

	/**
	 * @设置 capClassName
	 */
	public void setCapClassName(String capClassName) {
		this.capClassName = capClassName;
	}

	/**
	 * @取得 fieldType
	 */
	public String getFieldType() {
		return fieldType;
	}

	/**
	 * @设置 fieldType
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * @取得 fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @设置 fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @取得 capFieldName
	 */
	public String getCapFieldName() {
		return capFieldName;
	}

	/**
	 * @设置 capFieldName
	 */
	public void setCapFieldName(String capFieldName) {
		this.capFieldName = capFieldName;
	}

	/**
	 * @取得 ableMakerField
	 */
	public boolean isAbleMakerField() {
		return ableMakerField;
	}

	/**
	 * @设置 ableMakerField
	 */
	public void setAbleMakerField(boolean ableMakerField) {
		this.ableMakerField = ableMakerField;
	}

	/**
	 * @取得 serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
