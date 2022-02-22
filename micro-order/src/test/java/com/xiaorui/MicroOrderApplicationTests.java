package com.xiaorui;

import com.xiaorui.api.book.feign.BookFeign;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MicroOrderApplicationTests extends BaseOrderTest {

    @Autowired
    private BookFeign bookFeign;

    @Test
    public void testMapper() {
        bookFeign.getBookById(12);
    }

    @Test
    public void testSecurity() {
        bookFeign.feignErrorTest();
    }

}
