package com.yanger.swagger2;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("findAll")
    public List<Book> findAll(){
        return books;
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @ApiOperation(value = "添加书籍", notes = "添加书籍信息")
    @ApiImplicitParam(name = "book", value = "书籍的名称", required = true, dataType = "Book")
    @PostMapping("add")
    public String add(@RequestBody Book book){
        books.add(book);
        return "add successful";
    }

    //@PathVariable与@RequestParam默认要求required，@PathVariable需要设置paramType="path"
    @ApiOperation(value = "获取书籍", notes = "根据书名和作者名获取书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType="path" ,value = "书籍名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "author", paramType="path", value = "书籍作者名", required = true, dataType = "String")
    })
    @GetMapping("get/{name}/{author}")
    public Book get(@PathVariable (value = "name")String name, @PathVariable (value = "author")String author){
        Book fBook = null;
        for (Book book: books) {
            if(book.getName().equals(name) && book.getAuthor().equals(author)){
                fBook = book;
            }
        }
        return  fBook;
    }

    // 使用@RequestParam时，需要设置paramType="query"
    @ApiOperation(value = "获取书籍", notes = "根据书名和作者名获取书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType="query" ,value = "书籍名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "author", paramType="query", value = "书籍作者名", required = true, dataType = "String")
    })
    @GetMapping("get2")
    public Book get2(@RequestParam (value = "name")String name, @RequestParam (value = "author")String author){
        Book fBook = null;
        for (Book book: books) {
            if(book.getName().equals(name) && book.getAuthor().equals(author)){
                fBook = book;
            }
        }
        return  fBook;
    }

}
