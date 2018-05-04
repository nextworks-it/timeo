package it.nextworks.nfvmano.timeo.sbdriver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by francesca on 18/04/17.
 */

@Configuration
public class ExecutorsConfig {

    @Bean
    public ThreadPoolTaskExecutor tPTaskExecutor(){
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(20);
        pool.setMaxPoolSize(20);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }
}