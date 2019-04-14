package top.wycfight.shop.demo.service;

import top.wycfight.shop.demo.dto.PmsBrandDto;
import top.wycfight.shop.entity.PmsBrand;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: DemoService接口
 * @create: 2019-04-14 08:57
 * @modify By:
 **/
public interface DemoService {
    /**
     * 查询所有品牌数据
     * @return 品牌数据列表
     */
    List<PmsBrand> findAllBrand();

    /**
     * 保存品牌对象
     * @param pmsBrandDto 品牌数据
     * @return 1->成功  0->失败
     */
    int saveBrand(PmsBrandDto pmsBrandDto);

    /**
     * 更新品牌对象
     * @param id 品牌ID
     * @param pmsBrandDto 品牌对象
     * @return 1->成功 0->失败
     */
    int updateBrand(Long id, PmsBrandDto pmsBrandDto);

    /**
     * 根据ID删除品牌数据
     * @param id 品牌ID
     * @return 1->成功 0->失败
     */
    int deleteBrand(Long id);

    /**
     * 分页查询品牌数据
     * @param pageNum 当前页
     * @param pageSize 每页显示的数据
     * @return 分页品牌数据
     */
    List<PmsBrand> findBrandPage(int pageNum, int pageSize);

    /**
     * 根据品牌ID查询品牌对象
     * @param id 品牌ID
     * @return 品牌对象
     */
    PmsBrand findBrandById(Long id);
}
