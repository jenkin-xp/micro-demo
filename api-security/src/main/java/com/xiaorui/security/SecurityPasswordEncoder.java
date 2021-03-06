package com.xiaorui.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring boot 2.0.3引用的security 依赖是 spring security 5.X版本，
 * 此版本需要提供一个PasswordEncorder的实例，否则后台汇报错误
 */
public class SecurityPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
