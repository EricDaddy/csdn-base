package com.xkk.csdn.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkk.csdn.core.web.exception.ApiException;
import com.xkk.csdn.system.entity.DictType;
import com.xkk.csdn.system.mapper.DictTypeMapper;
import com.xkk.csdn.system.service.IDictTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author xkk
 * @since 2020-12-01
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements IDictTypeService {

    @Override
    public boolean submit(DictType dictType) {
        LambdaQueryWrapper<DictType> lqw = Wrappers.<DictType>query().lambda().eq(DictType::getDictType, dictType.getDictType()).eq(DictType::getDictName, dictType.getDictName());
        Integer cnt = baseMapper.selectCount((ObjectUtil.isEmpty(dictType.getId())) ? lqw : lqw.notIn(DictType::getId,dictType.getId()));
        if (cnt > 0) {
            throw new ApiException("当前字典键值已存在!");
        }
        if (ObjectUtil.isEmpty(dictType.getParentId())) {
            dictType.setParentId(0L);
        }
        return saveOrUpdate(dictType);
    }
}
