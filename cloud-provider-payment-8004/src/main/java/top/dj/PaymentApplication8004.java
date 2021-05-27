package top.dj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author DengJia
 * @Date 2021/5/20
 * @Description:
 */

@SpringBootApplication
@EnableDiscoveryClient // 该注解用于向使用 consul 或 zookeeper 作为注册中心时注册服务。
public class PaymentApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8004.class, args);
    }
}
