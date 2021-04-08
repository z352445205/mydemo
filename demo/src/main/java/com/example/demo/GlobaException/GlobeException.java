package com.example.demo.GlobaException;

import com.example.demo.config.ResponseVo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/7 19:33
 */

@RestControllerAdvice
@Slf4j
public class GlobeException<T> {

    @ResponseStatus(HttpStatus.OK)
    public ResponseResult sendSuccessResponse(){
        return ResponseResult.successResult();
    }

    @ResponseStatus(HttpStatus.OK)
    public ResponseResult<T> sendSuccessResponse(T data) {
        return ResponseResult.successResult(data);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult sendErrorResponse_System(Exception exception){
        return ResponseResult.failedResult("全局异常捕获到了");
    }
}
