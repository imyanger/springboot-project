package com.yanger.swagger2;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("swagger")
public class SwaggerApi {

    private static final List<Book> books = new ArrayList<Book>(){
        {
            add(new Book("西游记", "吴承恩", 69.80f));
            add(new Book("三国演义", "罗贯中", 109.80f));
        }
    };

    /**
     * 获取书籍信息
     */
    @ApiOperation(value = "获取书籍", notes = "获取所有的书籍")
    @RequestMapping("find")
    public List<Book> find(){
        return books;
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @ApiOperation(value = "添加书籍", notes = "添加书籍信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "book", value = "书籍信息的实体", required = true, dataType = "Book")
    })
    @RequestMapping("add")
    public String add(Book book){
        books.add(book);
        return "add successful";
    }

}
