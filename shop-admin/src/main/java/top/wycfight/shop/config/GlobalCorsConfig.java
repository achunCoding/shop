package top.wycfight.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author: wycfight@163.com
 * @description: 全局跨域配置
 * @create: 2019-09-16 21:58
 * @modify By:
 **/
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有域名进行跨域调用
        config.addAllowedOrigin("*");
        // 允许跨域发送cookie
        config.setAllowCredentials(true);
        // 放行全部原始头信息
        config.addAllowedHeader("*");
        // 允许所有请求进行访问
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
