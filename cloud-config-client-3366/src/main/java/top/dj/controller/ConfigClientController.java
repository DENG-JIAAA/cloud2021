package top.dj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author DengJia
 * @Date 2021/5/28
 * @Description:
 */

@RestController // 3366
@RefreshScope // 实现动态刷新的注解
@Slf4j
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "端口：" + serverPort + "，配置信息：" + configInfo;
    }
}
