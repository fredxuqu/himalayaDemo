package com.himalaya.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobService {
	
	private static final Logger logger = LoggerFactory.getLogger(JobService.class);
	
	@Value("${server.port}")
	private int port;
	
	@Value("${server.sessionTimeout}")
	private int sessionTimeout;   
	
	@Value("${cron.tags}")
	private String cron;

    @Scheduled(cron="${cron.tags}")
    public void executeTagIndex() {
 
        logger.info("JobService.executeTagIndex start...");
                
        Thread t = new Thread(new TaskExecuter());
        
        t.start();
    }
}
