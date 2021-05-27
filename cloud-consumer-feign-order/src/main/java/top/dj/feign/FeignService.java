package top.dj.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.dj.entity.Payment;
import top.dj.entity.base.ResultBean;

/**
 * Feign服务层，进行远程调用。
 */

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignService {

    @GetMapping("/payment/getPayment/{id}")
    ResultBean<Payment> getPayment(@PathVariable("id") Integer id);

    @GetMapping("/payment/feign/timeout")
    String getTimeout();
}
