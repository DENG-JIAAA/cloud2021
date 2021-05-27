package top.dj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author DengJia
 * @Date 2021/5/18
 * @Description:
 */

@Configuration
public class ApplicationContextConfig {
    @Bean
    // 注释掉注解来让自己的负载均衡生效
    // @LoadBalanced // 开启负载均衡，默认以轮询进行负载均衡。
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
