package com.xiaorui.microbook;

import com.xiaorui.api.book.feign.BookFeign;
import com.xiaorui.api.book.vo.BookListVO;
import com.xiaorui.common.util.MD5Utils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MicroBookApplicationTests extends BaseTest{

    @Autowired
    private BookFeign bookFeign;

    @Test
    public void testApi() {
        BookListVO bookById = bookFeign.getBookById(12);
        System.out.println(bookById);
    }

    @Test
    public void testSecurity() {
        System.out.println(MD5Utils.digestUpper("xiaoruiedu.."));
        System.out.println("F8F2CFF2-DA91-F259-E92C-DCB619D24AE0".length());
    }

}
