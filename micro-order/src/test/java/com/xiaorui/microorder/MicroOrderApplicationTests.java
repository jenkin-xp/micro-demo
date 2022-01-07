package com.xiaorui.microorder;

import com.xiaorui.api.book.feign.BookFeign;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MicroOrderApplicationTests extends BaseTest{

    @Autowired
    private BookFeign bookFeign;

    @Test
    public void testMapper() {
        bookFeign.getBookById(1);
    }

    @Test
    public void testSecurity() {
        bookFeign.feignErrorTest();
    }

}
