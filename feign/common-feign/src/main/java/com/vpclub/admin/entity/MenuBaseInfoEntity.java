/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vpclub.admin.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 菜单管理
 *
 * @author lxs
 */
@Data
@TableName("menu_base_info")
public class MenuBaseInfoEntity extends com.baomidou.mybatisplus.activerecord.Model<MenuBaseInfoEntity> {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "mbi_num")
    private Long menuId;

    /**
     * 预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
     */
    @TableField("mbi_code")
    private String code;

    /**
     * 菜单名称，相对较短
     */
    @TableField("mbi_name")
    private String name;

    /**
     * 父级ID,"0"表示最终父功能
     */
    @TableField("pid")
    private Integer parentId;

    /**
     * 树型路径
     */
    @TableField("path")
    private String path;

    /**
     * 菜单功能分类，0为分类，1为菜单，2为功能，3为功能点;分类下有菜单，菜单下有菜单和功能，功能下只有功能点，功能点下无任何类型
     */
    @TableField("mbi_type")
    private Integer type;

    /**
     * 菜单功能类型，0为默认栏目地址，1为单栏目、2为信息列表、3为超链接、4为广告图片、5为友情链接
     */
    @TableField("channel_type")
    private Integer channelType;
    /**
     * 菜单功能地址
     */
    @TableField("mbi_url")
    private String menuUrl;
    /**
     * 打开目标
     */
    @TableField("mbi_target")
    private String mbiTarget;
    /**
     * 图标
     */
    @TableField("mbi_ico")
    private String icon;

    /**
     * 菜单功能图片URL
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 权限编码，格式说明：权限编码:/:自定义回调:按钮类型定义:按钮显示区域定义，如\r\n            api:shopweixinmenu:hideData:1:/::15:2，按钮类型定义：第1位表示是否自动获取选择数据ID，第2位表示是否必选，第3位表示是否多选，第4位表示URL交互(1,2,4,8)
     */
    @TableField("mbi_permission")
    private String mbiPermission;

    /**
     * 系统帮助表ID
     */
    @TableField("shi_id")
    private Long sysHelpInfoId;
    /**
     * 是否显示,1为显示(默认), 0为不显示
     */
    @TableField("is_show")
    private Integer isShow;
    /**
     * 备注字段，关联备注表ID
     */
    @TableField("sri_id")
    private Long sysRemarkId;
    /**
     * 排序字段
     */
    @TableField("sortno")
    private Integer sortno;
    /**
     * 逻辑删除标志位，0为正常，1为删除
     */
    @TableField("del_flag")
    private Integer delFlag;
    /**
     * 创建时间.WEB服务器时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 创建人ID
     */
    @TableField("create_id")
    private Long createId;
    /**
     * 创建人名称
     */
    @TableField("create_name")
    private String createName;
    /**
     * 最近修改时间.WEB服务器时间
     */
    @TableField("update_date")
    private Date updateDate;
    /**
     *最近修改人ID
     */
    @TableField("update_id")
    private Long updateId;
    /**
     * 最近修改人名称
     */
    @TableField("update_name")
    private String updateName;

    /**
     * ztree属性
     */
    @TableField(exist = false)
    private Boolean open;

    @TableField(exist = false)
    private List<?> list;


    @Override
    protected java.io.Serializable pkVal() {
        return this.menuId;
    }
}
