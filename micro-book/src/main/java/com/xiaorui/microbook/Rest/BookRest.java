package com.xiaorui.microbook.Rest;

import com.xiaorui.api.book.vo.BookListVO;
import com.xiaorui.api.constants.ServiceId;
import com.xiaorui.microbook.mapper.BookMapper;
import com.xiaorui.microbook.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/5 15:33
 * @Version V1.0
 **/
@RestController
@RequestMapping(ServiceId.MODEL_ID_BOOK)
public class BookRest {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;

    @GetMapping("getBookById")
    public BookListVO getBookById(@RequestParam("id") int id) {
        BookModel bookModel = bookMapper.selectById(id);
        if (bookModel == null) return null;
        BookListVO bookListVO = new BookListVO();
        bookListVO.setId(id);
        bookListVO.setBookName(bookModel.getBookName());
        bookListVO.setIsbn(bookModel.getIsbn());
        return bookListVO;
    }

    @GetMapping("getServerPort")
    public String getServerPort(@RequestParam("times") int times) {
        return "第" + times + "次请求端口号为" + configurableEnvironment.getProperty("server.port");
    }

}
