package com.ruiton.config.view;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruiton.bean.ResultCode;

/**
 * 全集异常处理
 */
@Slf4j
@ControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {
    /**
     * 系统异常处理，比如：404,500
     */
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public ResultCode defaultErrorHandler(HttpServletRequest req, Throwable e) throws Exception {
    	ResultCode resultCode=new ResultCode(ResultCode.CODE_9999, ResultCode.MSG_9999);
    	log.error("系统请求异常:{}", e);
    	String msg=e.getLocalizedMessage();
    	if(msg.contains("BeanPropertyBindingResult")){
    		resultCode.setMsg("操作失败,请检查输入参数");
    	}
        return resultCode;
    }
}
