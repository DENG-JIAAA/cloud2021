package top.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author DengJia
 * @Date 2021/5/21
 * @Description:
 */

@Configuration
public class MyRibbonRule {

    @Bean
    public IRule getMyIRule() {
        return new RandomRule(); // 定义为随机
    }
}
