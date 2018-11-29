package me.freelee.commonutil.exception;

import javax.naming.AuthenticationException;

/**
 * Description:
 * Date:2018/11/20
 *
 * @author:Lee
 */
public class MyAuthenticationException extends AuthenticationException  {



    public MyAuthenticationException(String msg) {
        super(msg);
    }

    /**
     * 加入错误状态值
     * @param exceptionEnum
     */
//    public MyAuthenticationException(ErrorCodeEnum exceptionEnum) {
//        super(exceptionEnum.getMessage());
//    }

}
