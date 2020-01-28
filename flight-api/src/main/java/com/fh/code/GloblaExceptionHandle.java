package com.fh.code;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloblaExceptionHandle {

    //定义要捕捉的异常
    @ExceptionHandler(AjaxException.class)
    //@ResponseBody
    public ServerResponse handException2(AjaxException ex) {
        ex.printStackTrace();
        return ServerResponse.error();

    }

    @ExceptionHandler(Exception.class)
    // @ResponseBody
    public ServerResponse handException(Exception ex) {
        return ServerResponse.error();

    }


}
