package com.example.demo.config.ResponseVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Zhengyn
 * @description successful指明接口请求的结果，true代表成功，false代表失败。页面通过这个编码决定下一步操作。
 * resultValue是接口请求的返回值，可能是一个Bean，也可能是一个List或Map。
 * resultHint主要存放错误提示，当successful不为0时，resultHint里面保存了错误原因文字描述，可以直接显示给用户。正确提示由前端根据当前业务逻辑自行给定。
 * @create 2020/5/27 11:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 服务端处理是否成功
     */
    @ApiModelProperty(value = "服务端处理状态",required = true)
    private boolean successful;

    /**
     * 返回值
     */
    @ApiModelProperty(value = "返回值")
    private T resultValue;

    /**
     * 错误提示
     */
    @ApiModelProperty(value = "错误提示")
    private String resultHint;

    /**
     * 错误自定义页面路径
     */
    private String errorPage;

    /**
     * 不成功时的类型info、warn或error
     */
    private String type;

    public  static ResponseResult successResult(Object resultValue) {
        return new ResponseResult(true, resultValue, "调用成功", null, null);
    }

    public static ResponseResult successResult() {
        return new ResponseResult(true, null, "调用成功", null, null);
    }

    public static ResponseResult failedResult(String resultHint) {
        return new ResponseResult(false, null, resultHint, "", "");
    }

    public static ResponseResult failedResult(String resultHint, String type) {
        return new ResponseResult(false, null, resultHint, "", type);
    }
}
