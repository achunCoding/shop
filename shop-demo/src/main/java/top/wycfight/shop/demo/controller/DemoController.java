package top.wycfight.shop.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.wycfight.shop.demo.dto.CommonPage;
import top.wycfight.shop.demo.dto.CommonResult;
import top.wycfight.shop.demo.dto.PmsBrandDto;
import top.wycfight.shop.demo.service.DemoService;
import top.wycfight.shop.entity.PmsBrand;

import java.util.List;

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

    @Autowired
    private DemoService demoService;

    /**
     * 获取全部品牌列表
     *
     * @return
     */
    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/brand/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(demoService.findAllBrand());
    }

    /**
     * 添加品牌信息
     *
     * @param pmsBrandDto 品牌信息
     * @param result
     * @return
     */
    @ApiOperation(value = "添加品牌信息")
    @RequestMapping(value = "/brand/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@ApiParam(value = "品牌参数", required = true) @Validated @RequestBody PmsBrandDto pmsBrandDto, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        int count = demoService.saveBrand(pmsBrandDto);
        if (count == 1) {
            LOGGER.debug(" createBrand success:{}", pmsBrandDto);
            return CommonResult.success();
        }
        LOGGER.debug(" createBrand failed:{}", pmsBrandDto);
        return CommonResult.failed();
    }

    /**
     * 更新品牌
     *
     * @param id          品牌ID
     * @param pmsBrandDto 品牌
     * @param result
     * @return
     */
    @ApiOperation(value = "更新品牌")
    @RequestMapping(value = "/brand/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id,
                                    @ApiParam(value = "品牌参数", required = true) @Validated @RequestBody PmsBrandDto pmsBrandDto,
                                    BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        int count = demoService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
            return CommonResult.success(pmsBrandDto);
        }
        LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
        return CommonResult.failed("操作失败");

    }

    /**
     * 删除品牌
     *
     * @param id 品牌ID
     * @return
     */
    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/brand/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = demoService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return CommonResult.success();
        }
        LOGGER.debug("deleteBrand failed :id={}", id);
        return CommonResult.failed();

    }

    /**
     * 分页获取品牌列表
     *
     * @param pageNum  当前页
     * @param pageSize 每页长度
     * @return
     */
    @ApiOperation(value = "分页获取品牌列表")
    @RequestMapping(value = "/brand/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = demoService.findBrandPage(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    /**
     * g根据编号查询品牌信息
     * @param id 品牌ID
     * @return
     */
    @ApiOperation(value = "根据编号查询品牌信息")
    @RequestMapping(value = "/brand/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(demoService.findBrandById(id));
    }

}
