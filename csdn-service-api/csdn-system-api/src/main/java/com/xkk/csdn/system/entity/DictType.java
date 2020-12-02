package com.xkk.csdn.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xkk.csdn.core.dataobject.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author xkk
 * @since 2020-12-01
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@TableName("csdn_sys_dict_type")
public class DictType extends BaseEntity<DictType> {


    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 父级字典
     */
    private Long parentId;

    /**
     * 是否发布(1:是，0:否)
     */
    private String isPublish;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;



}
