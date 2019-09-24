package top.wycfight.shop.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.shop.service.UmsAdminService;

/**
 * @author: wycfight@163.com
 * @description: 后台用户管理
 * @create: 2019-09-24 21:43
 * @modify By:
 **/
@RestController("/admin")
@Api(tags = "UmsAdminController", description = "后台用户管理")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


}
