package com.SpringData.DataProject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

        @Bean
        public Executor taskExecutor(){
            ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
            threadPoolExecutor.setCorePoolSize(2);
            threadPoolExecutor.setMaxPoolSize(4);
            threadPoolExecutor.setQueueCapacity(500);
            threadPoolExecutor.setThreadNamePrefix("AsyncThread");
            threadPoolExecutor.initialize();
            return  threadPoolExecutor;

        }
}
