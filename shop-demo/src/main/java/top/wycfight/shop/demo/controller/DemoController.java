package top.wycfight.shop.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wycfight@163.com
 * @description: 测试DemoController
 * @create: 2019-04-11 21:47
 * @modify By:
 **/
@Api(value = "demo", description = "demo详情")
@Controller
public class DemoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    /**
     * 获取全部品牌列表
     * @return
     */
    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/brand/listAll", method = RequestMethod.GET)
    @ResponseBody
    public String getBrandList() {
        return "OK";

    }

}
