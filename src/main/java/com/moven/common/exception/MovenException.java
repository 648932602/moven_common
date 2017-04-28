package com.moven.common.exception;
/**
 * <p>Title:MovenException</p>
 * <p>Description:自定义异常类</p>
 * @author Shengwei
 * @date 2016年12月1日 下午2:46:00
 */
public class MovenException extends RuntimeException {

	private static final long serialVersionUID = 6793961756901474249L;

	/**
	 * 异常状态码，默认-1
	 */
	private int code = -1;

	public MovenException(){
		super();
	}
	
	public MovenException(String msg){
		super(msg);
	}
	
	public MovenException(int code, String msg){
		super(msg);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
