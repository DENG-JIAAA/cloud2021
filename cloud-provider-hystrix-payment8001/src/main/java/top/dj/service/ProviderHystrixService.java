package top.dj.service;


public interface ProviderHystrixService {
    String hystrix_ok_service(Integer id);

    String hystrix_timeout_service(Integer id);

    String paymentCircuitBreaker(Integer id);
}
