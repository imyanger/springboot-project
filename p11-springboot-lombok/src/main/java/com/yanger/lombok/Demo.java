package com.yanger.lombok;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Demo {

    @NonNull
    private Integer id;

    private String name;

    public static void main(String[] args) {
        Demo d = new Demo(1);
        d.setName("name");
        System.out.println(d.toString());
    }

}
