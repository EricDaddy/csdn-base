package com.xkk.csdn.user.controller.cmd;

import lombok.Data;


/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2020/12/4 10:41
 */
@Data
public class MenuRequestParams {


    private String menuName;

    private String menuCode;

    private Long parentId;

    private String type;

    private String href;

    private String permissionValue;

    private Integer sort;

    private String isShow;


}
