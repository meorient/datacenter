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
@Data
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


}
