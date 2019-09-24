package top.wycfight.shop.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import top.wycfight.shop.common.api.CommonResult;
import top.wycfight.shop.entity.PmsBrand;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: RestTemplate示例Controller
 * @create: 2019-04-13 09:46
 * @modify By:
 **/
@Controller
@Api(value = "top.wycfight.shop.demo.controller.RestTemplateDemoController", description = "RestTemplate示例")
@RequestMapping("/template")
public class RestTemplateDemoController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${host.shop.admin}")
    private String HOST_SHOP_ADMIN;

    /**
     * RestTemplate getForEntity Url示例
     * @param id
     * @return
     */
    @ApiOperation("getForEntity url")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getForEntity(@PathVariable Long id) {
        String url = HOST_SHOP_ADMIN + "/brand/{id}";
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(url, CommonResult.class, id);
        return responseEntity.getBody();
    }

    /**
     * RestTemplate getForEntity Url示例2
     * @param id
     * @return
     */
    @ApiOperation("getForEntity params")
    @RequestMapping(value = "/get2/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getForEntity2(@PathVariable Long id) {
        String url = HOST_SHOP_ADMIN + "/brand/{id}";
        Map<String, String> params = new HashMap<>(16);
        params.put("id", String.valueOf(id));
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(url, CommonResult.class, params);
        return responseEntity.getBody();
    }

    /**
     * RestTemplate getForEntity Url示例3
     * @param id
     * @return
     */
    @ApiOperation("getForEntity Uri")
    @RequestMapping(value = "/get3/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getForEntity3(@PathVariable Long id) {
        String url = HOST_SHOP_ADMIN + "/brand/{id}";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(url).build().expand(id).encode();
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(uriComponents.toUri(), CommonResult.class);
        return responseEntity.getBody();
    }

    /**
     * RestTemplate getForObject Url示例
     * @param id
     * @return
     */
    @ApiOperation("getForObject url")
    @RequestMapping(value = "/get4/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getForObject(@PathVariable Long id) {
        String url = HOST_SHOP_ADMIN + "/brand/{id}";
        CommonResult commonResult = restTemplate.getForObject(url, CommonResult.class, id);
        return commonResult;
    }

    /**
     * RestTemplate getForObject Post示例
     * @param brand
     * @return
     */
    @ApiOperation("postForEntity jsonBody")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult postForEntity(@RequestBody PmsBrand brand) {
        String url = HOST_SHOP_ADMIN + "/brand/create";
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(url, brand, CommonResult.class);
        return responseEntity.getBody();
    }

    /**
     * RestTemplate getForObject Post示例2
     * @param brand
     * @return
     */
    @ApiOperation("postForEntity jsonBody")
    @RequestMapping(value = "/post2", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult postForObject(@RequestBody PmsBrand brand) {
        String url = HOST_SHOP_ADMIN + "/brand/create";
        CommonResult commonResult = restTemplate.postForObject(url, brand, CommonResult.class);
        return commonResult;
    }

    /**
     * RestTemplate getForObject Post示例3
     * @param name
     * @return
     */
    @ApiOperation("postForEntity form")
    @RequestMapping(value = "/post3", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult postForEntity3(@RequestParam String name) {
        String url = HOST_SHOP_ADMIN + "/productAttribute/category/create";
        //设置头信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //构造表单参数
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("name", name);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(url, requestEntity, CommonResult.class);
        return responseEntity.getBody();
    }

}
