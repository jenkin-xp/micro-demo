package com.xiaorui.microorder;

import com.xiaorui.api.book.feign.BookFeign;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MicroOrderApplicationTests extends BaseTest{

    @Autowired
    private BookFeign bookFeign;

    @Test
    public void testMapper() {
        for (int i = 0; i < 10; i++) {
            String serverPort = bookFeign.getServerPort(i + 1);
            System.out.println(serverPort);
        }
    }

    @Test
    public void testSecurity() {
        System.out.println();
        System.out.println("F8F2CFF2-DA91-F259-E92C-DCB619D24AE0".length());
    }

}
