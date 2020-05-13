package com.lym.demo.domain;

import com.lym.demo.constant.StatusCode;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 封装返回数据的格式
 * @Description
 * @Auther lym
 * @Date 2020-05-08 17:54
 * @Version 1.0
 */
@Component
@Data
public class Result<T>
{
    private String code;

    private String message;

    private T dates;

    public static <T> Result<T> success(T data)
    {
        Result result = new Result();
        result.setCode(StatusCode.API_SUCCESS.getCode());
        result.setMessage(StatusCode.API_SUCCESS.getMessage());
        result.setDates(data);
        return result;
    }

    public static <T> Result<T> error(String code ,String message)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setDates(null);
        return result;
    }

}
