package top.wycfight.shop.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wycfight@163.com
 * @description: Mybatis配置类
 * @create: 2019-05-15 21:50
 * @modify By:
 **/
@Configuration
@MapperScan({"top.wycfight.shop.search.dao","top.wycfight.shop.mapper"})
public class MybatisConfig {
}
