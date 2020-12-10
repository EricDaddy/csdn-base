package com.xkk.csdn.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.xkk.csdn.core.web.dataobject.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author xkk
 * @since 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("csdn_sys_dict_data")
public class DictData extends BaseEntity<DictData> {


    /**
     * 字典类型ID
     */
    private String dictTypeId;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 样式属性（其他样式扩展）
     */
    private String cssClass;

    /**
     * 表格回显样式
     */
    private String listClass;

    /**
     * 是否默认（1是 0否）,默认为0
     */
    private String isDefault;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否发布(1:是，0:否)
     */
    private String isPublish;

    /**
     * 排序字段
     */
    private Integer sort;


}
