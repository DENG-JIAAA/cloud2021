package top.dj.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import top.dj.service.ProviderHystrixService;

import java.util.concurrent.TimeUnit;

/**
 * @Author DengJia
 * @Date 2021/5/24
 * @Description:
 */

@Service
public class ProviderHystrixServiceImpl implements ProviderHystrixService {
    @Override
    public String hystrix_ok_service(Integer id) {
        String tName = Thread.currentThread().getName();
        return "当前线程池名字：" + tName + "，hystrix_ok_service，" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "hystrixTimeoutServiceHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String hystrix_timeout_service(Integer id) {
        long begin = System.currentTimeMillis();
        // 超时异常和计算异常都将调用 hystrixTimeoutServiceHandler 方法。
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // int i = 10 / 0;
        long end = System.currentTimeMillis();
        long time = end - begin;
        return "当前线程池名字：" +
                Thread.currentThread().getName() +
                "，hystrix_timeout_service，耗时（毫秒）：" +
                time + "，" +
                id + "，(*^▽^*)";
    }

    public String hystrixTimeoutServiceHandler(Integer id) {
        return "当前线程池名字：" +
                Thread.currentThread().getName() +
                "，hystrix_timeout_service" +
                "id：" + id + "，〒▽〒";
    }

    // --> 服务熔断 <--
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期过后，会再次请求检查服务是否可用。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后进行服务熔断（跳闸）
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不可为负数");
        }
        String idSerialNumber = IdUtil.simpleUUID();
        return "调用成功！流水号为：" + idSerialNumber + "，(*^_^*)";
    }

    public String paymentCircuitBreaker_fallback(Integer id) {

        return "id 不能为负数，请检查后重新提交，/(ㄒoㄒ)/~~";
    }
}
