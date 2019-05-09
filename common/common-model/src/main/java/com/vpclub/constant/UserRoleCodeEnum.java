package com.vpclub.constant;

/**
 * @author
 * @date 12/20
 */
public enum UserRoleCodeEnum {
    /***
     * 商店
     */
    SHOP("shop"),
    /***
     * 商城
     */
    STORE("store"),
    /***
     * 服务支撑
     */
    SUPPORTING("supporting"),
    /***
     * 金融服务
     */
    BANKING("banking");
    public String code;

    UserRoleCodeEnum(String code) {
        this.code = code;
    }
}
