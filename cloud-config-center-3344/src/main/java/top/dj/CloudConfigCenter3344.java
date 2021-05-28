package top.dj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author DengJia
 * @Date 2021/5/28
 * @Description:
 */

@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3344.class, args);
    }
}
