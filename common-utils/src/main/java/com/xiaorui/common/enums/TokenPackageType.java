package com.xiaorui.common.enums;

/**
 * token包装类枚举类型
 */
public enum TokenPackageType {

    USER("user","后台管理用户");

    TokenPackageType(String name, String chineseName) {
        this.name = name;
        this.chineseName = chineseName;
    }

    //代号英文名称
    private String name;
    //代号中文名称
    private String chineseName;

    //直接获取英文
    public String getName() {
        return name;
    }

    //直接获取中文
    public String getChineseName() {
        return chineseName;
    }
}
