package top.wycfight.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import top.wycfight.shop.bo.AdminUserDetails;
import top.wycfight.shop.component.JwtAuthenticationTokenFilter;
import top.wycfight.shop.component.RestAuthenticationEntryPoint;
import top.wycfight.shop.component.RestfulAccessDeniedHandler;
import top.wycfight.shop.entity.UmsAdmin;
import top.wycfight.shop.entity.UmsPermission;
import top.wycfight.shop.service.UmsAdminService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: Spring Security的配置
 * @create: 2019-04-17 20:43
 * @modify By:
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf() // 使用的是JWT，這裏不需要csrf
                .disable().sessionManagement()// 基于Token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET, //允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**",
                        "/webjars/springfox-swagger-ui/**"
                ).permitAll()
                .antMatchers("/admin/login", "/admin/register") // 对登录注册要允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS) // 跨域请求会进行一次options请求
                .permitAll()
                .anyRequest() // 除上面外的所有请求全部需要鉴权认证
                .authenticated();
        // 禁用缓存
        http.headers().cacheControl();
        //添加JWT filter
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            UmsAdmin admin = umsAdminService.getAdminByUsername(username);
            if (admin != null) {
                List<UmsPermission> permissionList = umsAdminService.getPermissionList(admin.getId());
                return new AdminUserDetails(admin,permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
