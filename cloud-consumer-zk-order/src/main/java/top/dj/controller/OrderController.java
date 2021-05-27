package top.dj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author DengJia
 * @Date 2021/5/20
 * @Description:
 */
@RestController
public class OrderController {
    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPaymentZk() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }

}
