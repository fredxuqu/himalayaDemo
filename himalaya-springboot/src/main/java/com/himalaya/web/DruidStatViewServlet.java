package com.himalaya.web;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年7月25日 下午6:20:00 Description
 */
//@WebServlet(urlPatterns = "/druid/*", initParams = { 
//		//@WebInitParam(name = "allow", value = "127.0.0.1,192.168.163.1"), // IP白名单(没有配置或者为空，则允许所有访问)
//		//@WebInitParam(name = "deny", value = "192.168.1.73"), // IP黑名单
//																// (存在共同时，deny优先于allow)
//		@WebInitParam(name = "loginUsername", value="admin"), // 用户名
//		@WebInitParam(name = "loginPassword", value="123456"), // 密码
//		@WebInitParam(name = "resetEnable", value="false")// 禁用HTML页面上的“Reset
//															// All”功能
//})
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = -2688872071445249539L;

}