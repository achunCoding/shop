package top.wycfight.shop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: wycfight@163.com
 * @description: Mybatis配置
 * @create: 2019-04-14 10:19
 * @modify By:
 **/
@Configuration
@EnableTransactionManagement
@MapperScan({"top.wycfight.shop.dao","top.wycfight.shop.mapper"})
public class MybatisConfig {
}
