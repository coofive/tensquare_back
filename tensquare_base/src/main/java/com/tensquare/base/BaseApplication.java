package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import utils.IdWorker;

/**
 * 基础模块的启动类
 *
 * @Author: CooFive
 * @CreateDate: 18/8/30 15:04
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    /**
     * 定义IdWorker的Bean
     *
     * @return
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}
