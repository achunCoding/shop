package top.wycfight.shop.demo.config.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: wycfight@163.com
 * @description: Swagger2配置属性
 * @create: 2019-04-12 08:33
 * @modify By:
 **/
@Component
@ConfigurationProperties(prefix = "swagger")
public class Swagger2 {
    /**
     * 标题
     */
    @Value("${swagger.title}")
    private String title;
    /**
     * 描述
     */
    @Value("${swagger.description}")
    private String description;
    /**
     * 版本
     */
    @Value("${swagger.version}")
    private String version;
    /**
     * termsOfServiceUrl
     */
    @Value("${swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl;
    /**
     * 名称
     */
    @Value("${swagger.contact.name}")
    private String name;
    /**
     * URL
     */
    @Value("${swagger.contact.url}")
    private String url;
    /**
     * Email
     */
    @Value("${swagger.contact.email}")
    private String email;

    /**
     * 获取：标题
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置：标题
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：描述
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置：描述
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取：版本
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置：版本
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取：TermsOfServiceUrl
     * @return
     */
    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    /**
     * 设置：termsOfServiceUrl
     * @param termsOfServiceUrl
     */
    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    /**
     * 获取：名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：Url
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置：URL
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：Email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：Email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
