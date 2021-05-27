package top.dj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.dj.entity.Payment;
import top.dj.entity.base.ResultBean;
import top.dj.lb.LoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author DengJia
 * @Date 2021/5/18
 * @Description: 消费者API
 */

@RestController
@Slf4j
public class OrderController {
    // 单点服务，可以将提供服务的地址写死（即提供服务的IP:PORT）
    // public static final String PAYMENT_URL = "http://127.0.0.1:8001";

    // 服务集群，写提供服务的 服务别名
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    // Ribbon 和 Eureka整合后，Consumer可以直接调用服务而不用再关心地址和端口号，而且服务还有负载均衡机制了。
    // Ribbon 的负载均衡机制默认为：轮询。

    @Resource
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public ResultBean<Payment> consumerCreatePayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/addPayment", payment, ResultBean.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public ResultBean<Payment> consumerGetPayment(@PathVariable("id") Long id) {
        String url = PAYMENT_URL + "/payment/getPayment/" + id;
        return restTemplate.getForObject(url, ResultBean.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object consumerGetDiscovery() {
        String url = PAYMENT_URL + "/payment/discovery";
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public ResultBean<Payment> getForEntity(@PathVariable("id") Integer id) {
        String url = PAYMENT_URL + "/payment/getPayment/" + id;
        ResponseEntity<ResultBean> entity = restTemplate.getForEntity(url, ResultBean.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new ResultBean<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() < 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instances(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/payment/lb", String.class);
    }

}
