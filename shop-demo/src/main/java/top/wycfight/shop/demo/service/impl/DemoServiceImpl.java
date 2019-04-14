package top.wycfight.shop.demo.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.shop.demo.dto.PmsBrandDto;
import top.wycfight.shop.demo.service.DemoService;
import top.wycfight.shop.entity.PmsBrand;
import top.wycfight.shop.entity.PmsBrandExample;
import top.wycfight.shop.mapper.PmsBrandMapper;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: DemoService实现类
 * @create: 2019-04-14 09:06
 * @modify By:
 **/
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> findAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int saveBrand(PmsBrandDto pmsBrandDto) {
        PmsBrand pmsBrand = new PmsBrand();
        // 这里使用Spring实体类Copy BeanUtils.copyProperties(A,B)是将A中数据复制到B中
        BeanUtils.copyProperties(pmsBrandDto,pmsBrand);
        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrandDto pmsBrandDto) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandDto,pmsBrand);
        pmsBrand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> findBrandPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand findBrandById(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
