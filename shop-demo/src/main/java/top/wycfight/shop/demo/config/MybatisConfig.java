package top.wycfight.shop.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wycfight@163.com
 * @description: Mybatis配置
 * @create: 2019-04-14 10:19
 * @modify By:
 **/
@Configuration
@MapperScan("top.wycfight.shop.mapper")
public class MybatisConfig {
}
