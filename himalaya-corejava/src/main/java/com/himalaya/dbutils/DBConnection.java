package com.himalaya.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年2月8日 下午2:33:19
* Description
*/
public class DBConnection {

	public static void main(String[] args) {
		//声明Connection对象
		Connection con;
		//驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/solr?useSSL=false";
		//MySQL配置时的用户名
		String user = "test";
		//MySQL配置时的密码
		String password = "Admin#1010";
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			//1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
				//2.创建statement类对象，用来执行SQL语句！！
				Statement statement = con.createStatement();
				//要执行的SQL语句
				String sql = "select * from TB_TAGS";
				//3.ResultSet类，用来存放获取的结果集！！
				ResultSet rs = statement.executeQuery(sql);
				System.out.println("-----------------");
				System.out.println("执行结果如下所示:");  
				System.out.println("-----------------");  
				System.out.println("姓名" + "\t" + "职称");  
				System.out.println("-----------------");  
				
				String tagName = null;
				String id = null;
				while(rs.next()){
					//获取stuname这列数据
					tagName = rs.getString("TAG_NAME");
					//获取stuid这列数据
					id = rs.getString("ID");
					
					//输出结果
					System.out.println(id + "\t" + tagName);
				}
				rs.close();
				con.close();
		} catch(ClassNotFoundException e) {   
			//数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
		} catch(SQLException e) {
			//数据库连接失败异常处理
			e.printStackTrace();  
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			System.out.println("数据库数据成功获取！！");
		}
	}
}
