package top.dj.feign;

import org.springframework.stereotype.Component;

/**
 * @Author DengJia
 * @Date 2021/5/24
 * @Description: 全局服务降级 运行时异常、超时异常、服务器宕机时调用此类中的方法。
 */

@Component
public class FeignHystrixFallbackService implements FeignHystrixService {
    @Override
    public String hystrixOkRemote(Integer id) {
        return "hystrixOkRemote 的服务降级" + id;
    }

    @Override
    public String hystrixTimeoutRemote(Integer id) {
        return "hystrixTimeoutRemote 的服务降级" + id;
    }
}
