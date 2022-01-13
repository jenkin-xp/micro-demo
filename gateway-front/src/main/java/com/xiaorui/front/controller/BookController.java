package com.xiaorui.front.controller;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.xiaorui.api.book.feign.BookFeign;
import com.xiaorui.api.book.vo.BookListVO;
import com.xiaorui.api.constants.ServiceId;
import com.xiaorui.common.annotation.JwtIgnore;
import com.xiaorui.common.exception.ExceptionCode;
import com.xiaorui.common.vo.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/7 17:31
 * @Version V1.0
 **/
@RestController
@RequestMapping(ServiceId.MODEL_ID_BOOK)
public class BookController {

    @Autowired
    private BookFeign bookFeign;

    @GetMapping("getBookById")
    @JwtIgnore
    public ResponseDTO<BookListVO> getBookById(@RequestParam("id") int id) {
        return new ResponseDTO<>(bookFeign.getBookById(id));
    }

    @GetMapping("feignErrorTest")
    @JwtIgnore
    public ResponseDTO<?> feignErrorTest() {
        String feignErrorTest = bookFeign.feignErrorTest();
        return new ResponseDTO<>(feignErrorTest);
    }

}
