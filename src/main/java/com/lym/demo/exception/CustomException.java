package com.lym.demo.exception;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 自定义异常
 *
 * @Description
 * @Auther lym
 * @Date 2020-05-08 18:04
 * @Version 1.0
 */
@Data
public class CustomException extends RuntimeException
{
    private String code;

    public CustomException(String message, String code)
    {
        super(message);
        this.code = code;
    }
}
