package com.xiaorui.common.vo.token;


import lombok.Data;

import java.io.Serializable;

/**
 * 需要返回token对象的包装类
 */
@Data
public abstract class TokenPackage implements Serializable {
    //类型
    private String type;
    private int id;

    public TokenPackage() {
        setIndependType();
    }

    //由子类自己设置
    public abstract void setIndependType();
}
