package top.wycfight.shop.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import top.wycfight.shop.demo.bo.AdminUserDetails;
import top.wycfight.shop.entity.UmsAdmin;
import top.wycfight.shop.entity.UmsAdminExample;
import top.wycfight.shop.mapper.UmsAdminMapper;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: SpringSecurity的配置
 * @create: 2019-05-19 10:21
 * @modify By:
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminMapper umsAdminMapper;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// 配置权限
//        .antMatchers("/").access("hasRole('TEST')") // 该路径下是需要Test角色
                .antMatchers("/").authenticated()//该路径需要登录认证
//        .antMatchers("/brand/list").hasAuthority("Test")//该路径下需要TEST权限
                .antMatchers("/**").permitAll()
                .and()//启用基于http认证
                .httpBasic()
                .realmName("/")
                .and()//配置登录jiemian
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .and()// 配置登出路径
                .logout()
                .logoutSuccessUrl("/")
//                .and()//记住密码功能
//                .rememberMe()
//                .tokenValiditySeconds(60*60*24)
//                .key("rememberMeKey")
                .and()//关闭跨域伪造
                .csrf()
                .disable()
                .headers()//去除X-Frame-Options
                .frameOptions()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return username -> {
            UmsAdminExample umsAdminExample = new UmsAdminExample();
            umsAdminExample.createCriteria().andUsernameEqualTo(username);
            List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(umsAdminExample);
            if (umsAdmins != null && umsAdmins.size() > 0) {
                return new AdminUserDetails(umsAdmins.get(0));
            }
            throw new UsernameNotFoundException("用户名或者密码错误");

        };
    }
}
