package com.himalaya.dbutils;
/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年1月2日 下午5:31:20
* Description
*/
import com.alibaba.druid.filter.config.ConfigTools;
public class DruidEncrypyTest {

	public static void main(String[] args) throws Exception {
		//密码明文
		String password = "admin";
		
		System.out.println("密码[ "+password+" ]的加密信息如下：\n");
	
		String [] keyPair = ConfigTools.genKeyPair(512);
		//私钥
		String privateKey = keyPair[0];
		//公钥
		String publicKey = keyPair[1];
		//用私钥加密后的密文
		password = ConfigTools.encrypt(privateKey, password);
	
		System.out.println("privateKey:"+privateKey);
		System.out.println("publicKey:"+publicKey);
		System.out.println("password:"+password);	
		String decryptPassword=ConfigTools.decrypt(publicKey, password);
	
		System.out.println("decryptPassword："+decryptPassword);
	}
}