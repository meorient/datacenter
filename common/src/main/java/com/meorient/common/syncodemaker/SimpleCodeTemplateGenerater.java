package com.meorient.common.syncodemaker;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年4月23日上午9:10:56
 */
public abstract class SimpleCodeTemplateGenerater implements CodeTemplateGenerater{
	
	protected GenerateParam param;
	
	@Override
	public void generateCode() {
		// 设置参数
		getColumnInfo(param);
		// 生成代码
		generate(param);
	}
	
	public abstract void getColumnInfo(GenerateParam param);
	
	public abstract void generate(GenerateParam param);
}
