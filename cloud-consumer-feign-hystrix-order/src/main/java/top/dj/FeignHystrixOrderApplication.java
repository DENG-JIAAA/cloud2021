package top.dj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author DengJia
 * @Date 2021/5/24
 * @Description:
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix // 开启服务降级
public class FeignHystrixOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderApplication.class, args);
    }
}
