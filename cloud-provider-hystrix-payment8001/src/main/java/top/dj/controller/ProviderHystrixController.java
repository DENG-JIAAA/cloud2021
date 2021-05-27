package top.dj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.dj.service.ProviderHystrixService;

/**
 * @Author DengJia
 * @Date 2021/5/24
 * @Description:
 */

@RestController
@Slf4j
public class ProviderHystrixController {
    @Autowired
    private ProviderHystrixService providerHystrixService;

    @GetMapping("/hystrix/ok/{id}")
    public String hystrixOkController(@PathVariable("id") Integer id) {
        log.info("请求：hystrix ok...");
        return providerHystrixService.hystrix_ok_service(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String hystrixTimeoutController(@PathVariable("id") Integer id) {
        log.info("请求：hystrix timeout...");
        return providerHystrixService.hystrix_timeout_service(id);
    }

    @GetMapping("/hystrix/circuit/{id}")
    public String hystrixCircuitBreaker(@PathVariable("id") Integer id) {
        log.info("请求服务，当服务达到一定比例的失败之后，将开启服务的熔断机制。");
        return providerHystrixService.paymentCircuitBreaker(id);
    }
}
