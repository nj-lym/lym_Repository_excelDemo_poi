package com.lym.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * 统一状态码
 * @Description
 * @Auther lym
 * @Date 2020-05-09 9:11
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum StatusCode
{
    API_SUCCESS("200","操作成功"),
    API_FALL("201","操作失败"),
    API_URL_NOT_FOUND("404","请求地址不存在"),
    API_ERROR("500","发生异常");

    private  String code;
    private String message;

    public static  String getMsgByCode(String code){
        if (StringUtils.isEmpty(code)){
            throw new IllegalArgumentException("code can not be null");
        }
        final StatusCode[] values=StatusCode.values();
        for (StatusCode statusCode:values){
            final String code1=statusCode.getCode();
            if (code1.equals(code)){
                return statusCode.getMessage();
            }
        }
        return  null;
    }

}
