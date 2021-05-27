package top.dj.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author DengJia
 * @Date 2021/5/21
 * @Description: 配置 OpenFeign 日志打印功能
 */
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level openFeignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
