package com.moven.common.exception;

public class LoggedMovenException extends MovenException {

    private static final long serialVersionUID = 492269212303791477L;


    public LoggedMovenException() {
        super();
    }

    public LoggedMovenException(String msg) {
        super(msg);
    }

    public LoggedMovenException(int code, String msg) {
        super(code, msg);
    }

}
