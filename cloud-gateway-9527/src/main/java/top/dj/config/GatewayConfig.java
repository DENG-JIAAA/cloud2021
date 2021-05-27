package top.dj.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author DengJia
 * @Date 2021/5/26
 * @Description:
 */

@Configuration
public class GatewayConfig {

    /**
     * 配置id为route-name的路由规则，
     * 当访问地址 http://localhost:9527/guonei 时会自动转发到：http://news.baidu.com/guonei
     *
     * @param routeLocatorBuilder 路由定位器构建器
     * @return 路由定位器
     */
    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes
                .route("route_id",
                        r -> r.path("/")
                                .uri("http://news.baidu.com/")) // 首页

                .route("route_id_guonei",
                        r -> r.path("/guonei")
                                .uri("http://news.baidu.com/guonei")) // 国内

                .route("route_id_guoji",
                        r -> r.path("/guoji")
                                .uri("http://news.baidu.com/guoji")) // 国际

                .route("route_id_mil",
                        r -> r.path("/mil")
                                .uri("http://news.baidu.com/mil")); // 军事
        return routes.build();


    }
}
