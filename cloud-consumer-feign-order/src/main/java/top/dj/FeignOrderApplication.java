package top.dj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author DengJia
 * @Date 2021/5/21
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients // 使用Feign，激活并开启。
public class FeignOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication.class, args);
    }
}
