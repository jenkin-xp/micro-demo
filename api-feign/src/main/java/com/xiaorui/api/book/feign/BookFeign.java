package com.xiaorui.api.book.feign;

import com.xiaorui.api.book.vo.BookListVO;
import com.xiaorui.api.config.FeignClientErrorDecoder;
import com.xiaorui.api.constants.ServiceId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ServiceId.SERVICE_ID_BOOK, path = ServiceId.MODEL_ID_BOOK, configuration = FeignClientErrorDecoder.class)
public interface BookFeign {

    @GetMapping("getBookById")
    BookListVO getBookById(@RequestParam("id") int id);

    @GetMapping("getServerPort")
    String getServerPort(@RequestParam("times") int times);

    @GetMapping("feignErrorTest")
    String feignErrorTest();

}
