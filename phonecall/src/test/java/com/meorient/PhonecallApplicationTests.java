package com.meorient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.meorient.phonecall.PhonecallApplication.class)
public class PhonecallApplicationTests {

	private StringBuffer sqls = new StringBuffer();
	/**
	 * get
	 * 增量同步/全量同步
	 */
	@Test
	public void syncGET() {
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sourceTable = "company";
        String targetTable = "company_copy1";
        String[] source = {"name","email"};
        String[] target = {"email","name"};
        String sql = "";
        
        StringBuffer source_str = new StringBuffer();
        StringBuffer target_str = new StringBuffer();
        
        for(int i=0;i<source.length;i++) {
        	if(i!=0) source_str.append(",");
        	source_str.append(source[i]);
        }
        for(int i=0;i<target.length;i++) {
        	if(i!=0) target_str.append(",");
        	target_str.append(source[i]);
        }
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/data_center?characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Asia/Shanghai","root","root");
            statement = con.prepareStatement("select * from "+sourceTable);
            
            resultSet = statement.executeQuery();
            StringBuffer value = new StringBuffer();
            while(resultSet.next()){
                for(int i=0;i<source.length;i++) {
                	if(i!=0) value.append(",");
                	value.append("'");
                	value.append(resultSet.getString(source[i]));
                	value.append("'");
                }
	            sql = "insert into " + targetTable + "(" + source_str.toString() + ") values("+ value.toString() +");";
	            System.out.println(sql);
	            sqls.append(sql);
            }
            syncPOST();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
	}
	
	/**
	 * insert
	 */
	private void syncPOST() {
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/data_center?characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Asia/Shanghai","root","root");
            statement = con.prepareStatement(sqls.toString());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
	}
	
	public static void main(String[] args) {
		PhonecallApplicationTests t =new PhonecallApplicationTests();
		t.syncGET();
	}
}
