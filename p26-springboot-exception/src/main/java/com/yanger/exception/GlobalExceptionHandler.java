package com.yanger.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yanger
 * @description 全局异常处理
 * @date 2019/10/17
 */
@Slf4j
//@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String  exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response){
        log.info("GlobalExceptionHandler处理Exception异常", e);
        return "系统异常";
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String  arithmeticExceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response){
        log.info("GlobalExceptionHandler处理ArithmeticException异常", e);
        return "算数异常";
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public String  authExceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response){
        log.info("GlobalExceptionHandler处理AuthException异常", e);
        return "权限不足，请联系管理员";
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ModelAndView arrayIndexOutOfBoundsExceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response){
        log.info("GlobalExceptionHandler处理ArrayIndexOutOfBoundsException异常", e);
        ModelAndView mv = new ModelAndView("/error");
        mv.addObject("msg", "数组越界异常啦");
        return mv;
    }

}
