package com.himalaya.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {  
	  
    private static ApplicationContext applicationContext;  
  
    /** 
     * ʵ��ApplicationContextAware�ӿڵĻص����������������Ļ��� 
     *  
     * @param applicationContext 
     */  
    public void setApplicationContext(ApplicationContext applicationContext) {  
        SpringContextUtil.applicationContext = applicationContext;  
    }  
  
    /** 
     * @return ApplicationContext 
     */  
    public static ApplicationContext getApplicationContext() {  
        return applicationContext;  
    }  
  
    /** 
     * ��ȡ���� 
     * ������д��bean����������Ҫ���� 
     * @param name 
     * @return Object һ������������ע���bean��ʵ�� 
     * @throws BeansException 
     */  
    public static Object getBean(String name) throws BeansException {  
        return applicationContext.getBean(name);  
    }
}  
