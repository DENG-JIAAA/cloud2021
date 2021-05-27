package top.dj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.dj.entity.Payment;
import top.dj.entity.base.ResultBean;
import top.dj.feign.FeignService;

/**
 * @Author DengJia
 * @Date 2021/5/21
 * @Description:
 */
@RestController
@Slf4j
public class FeignController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/consumer/payment/get/{id}")
    public ResultBean<Payment> feignGetPayment(@PathVariable("id") Integer id) {
        return feignService.getPayment(id);
    }

    // open feign 客户端一般默认等待1秒钟
    @GetMapping("/consumer/payment/feign/timeout")
    public String feignTimeout() {
        return feignService.getTimeout();
    }
}
