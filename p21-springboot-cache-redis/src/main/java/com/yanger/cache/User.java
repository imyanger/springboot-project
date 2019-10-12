package com.yanger.cache;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yanger
 * @description 数据模型
 * @date 2019/10/12
 */
@Data
@AllArgsConstructor
public class User implements Serializable  {

    private String code;

    private String name;

}
