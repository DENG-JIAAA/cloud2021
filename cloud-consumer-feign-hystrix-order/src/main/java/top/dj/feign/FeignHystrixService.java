package top.dj.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = FeignHystrixFallbackService.class)
public interface FeignHystrixService {

    @GetMapping("/hystrix/ok/{id}")
    String hystrixOkRemote(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/timeout/{id}")
    String hystrixTimeoutRemote(@PathVariable("id") Integer id);
}
