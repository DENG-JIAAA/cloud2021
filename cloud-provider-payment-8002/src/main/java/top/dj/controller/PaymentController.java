package top.dj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.dj.entity.Payment;
import top.dj.entity.base.ResultBean;
import top.dj.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author DengJia
 * @Date 2021/5/17
 * @Description:
 */

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPayment/{id}")
    public ResultBean<Payment> getPayment(@PathVariable("id") Integer id) {
        log.info("****** 获取支付 ******");
        Payment payment = paymentService.getOnePayment(id);
        return new ResultBean<>(200, "获取支付信息服务，提供服务端口：" + serverPort, payment);
    }

    @PostMapping("/addPayment")
    public ResultBean<Integer> addPayment(@RequestBody Payment payment) {
        log.info("****** 添加支付 ******");
        int add = paymentService.addOnePayment(payment);
        return new ResultBean<>(200, "添加支付信息服务，提供服务端口：" + serverPort, add);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("当前的服务ID：" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("服务的实例信息：" + instance.getHost() + ", " + instance.getPort() + ", " + instance.getUri());
        }
        return new ResultBean<>(200, "获取服务的一些基本信息，提供服务的端口：" + serverPort, this.discoveryClient);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    private String feignTimeout() {
        // 暂停线程几秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "port： " + serverPort + " 服务调用完成。";
    }

}
