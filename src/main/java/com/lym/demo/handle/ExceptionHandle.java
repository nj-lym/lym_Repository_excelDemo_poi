package com.lym.demo.handle;

import com.lym.demo.constant.StatusCode;
import com.lym.demo.domain.Result;
import com.lym.demo.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获并处理抛出的异常
 *
 * @Description
 * @Auther lym
 * @Date 2020-05-08 17:58
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionHandle
{
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e)
        {
            if (e instanceof CustomException){
                CustomException customException= (CustomException) e;
                return Result.error(customException.getCode(),customException.getMessage());
            }else {
                return Result.error(StatusCode.API_ERROR.getCode(), e.getMessage());
            }

    }

}
