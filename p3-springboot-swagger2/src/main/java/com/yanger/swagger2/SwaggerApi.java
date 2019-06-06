package com.yanger.swagger2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("swagger")
public class SwaggerApi {

    private static final List<Book> books = new ArrayList<Book>(){
        {
            add(new Book("西游记", "吴承恩", 69.80f);
        }
    };

}
