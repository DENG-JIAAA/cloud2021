package top.dj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.dj.feign.FeignHystrixService;

import javax.annotation.Resource;

/**
 * @Author DengJia
 * @Date 2021/5/24
 * @Description:
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class FeignHystrixController {
    @Resource
    private FeignHystrixService feignHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String consumerHystrixOk(@PathVariable("id") Integer id) {
        return feignHystrixService.hystrixOkRemote(id);
    }


    // 客户端做服务降级
    @GetMapping("/consumer/hystrix/timeout/{id}")
    // 注释掉，避免和全局的起冲突。

//    @HystrixCommand(fallbackMethod = "consumerHystrixTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })

    @HystrixCommand
    public String consumerHystrixTimeout(@PathVariable("id") Integer id) {
        return feignHystrixService.hystrixTimeoutRemote(id);
    }

    public String consumerHystrixTimeoutHandler(Integer id) {
        return "当前线程池名字：" +
                Thread.currentThread().getName() +
                "，hystrix_timeout_service" +
                "，我是消费者80端口，对方支付系统繁忙请在10秒后重试或自己运行出错，请检查自己！" +
                id + "，〒▽〒";

    }

    // 全局默认的服务降级处理办法
    public String defaultFallbackMethod() {
        return "这是全局默认的服务降级处理办法~~";
    }


}
