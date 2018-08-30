package com.tensquare.base.web.common;

import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局处理异常类（通知类）
 *
 * @ControllerAdvice 组合注解，相当于@ControllerAdvice+@ResponseBody
 * @Author: CooFive
 * @CreateDate: 18/8/30 17:22
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    /**
     * 增强的方法：异常通知处理
     * 当有异常的情况下自动将该方法处理异常
     * 如果为空，则自动抓取参数中的异常列表
     * 如果不为空，则抓取指定异常
     *
     * @param e
     * @return
     * @ExceptionHandler(Exception.class)
     */
    @ExceptionHandler
    public ResultDTO error(Exception e) {
        // 控制台打印
        e.fillInStackTrace();
        return new ResultDTO(false, StatusCode.ERROR, e.getMessage());
    }
}
