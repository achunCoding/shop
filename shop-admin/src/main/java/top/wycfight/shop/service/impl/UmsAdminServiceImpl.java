package top.wycfight.shop.service.impl;

import cn.hutool.core.collection.CollUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.shop.entity.UmsAdmin;
import top.wycfight.shop.entity.UmsAdminExample;
import top.wycfight.shop.mapper.UmsAdminMapper;
import top.wycfight.shop.service.UmsAdminService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: umsAdminService实现类
 * @create: 2019-09-24 07:46
 * @modify By:
 **/
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper umsAdminMapper;


    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(umsAdmins)) {
            return umsAdmins.get(0);
        }
        return null;
    }
}
