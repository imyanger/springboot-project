package com.yanger.devtools;

import com.thoughtworks.xstream.XStream;
import com.yanger.swagger2.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("devtools")
public class DevtoolsApi {

    @GetMapping("msg")
    public String getMsg(){
        return "Hello devtools new";
    }

    @GetMapping("cast")
    public void  cast(){
        String xml = "<book><name>xstream</name></book>";
        XStream xstream = new XStream();
        // 指定xtream的classloader，否则会报转换异常
        xstream.setClassLoader(Book.class.getClassLoader());
        xstream.alias("book", Book.class);
        Book book = (Book)xstream.fromXML(xml);
        System.out.print(book.getName());
    }


}
