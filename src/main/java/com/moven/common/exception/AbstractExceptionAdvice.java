package com.moven.common.exception;

import java.io.IOException;

import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.moven.common.entity.JsonResponse;

/**
 * <p>Title:AbstractExceptionAdvice</p>
 * <p>Description:异常统一处理的抽象类，需在子类指定匹配的controller范围。也可以在子类中进一步细化异常的拦截分类</p>
 * @author Shengwei
 * @date 2016年12月1日 下午2:45:45
 */
public abstract class AbstractExceptionAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractExceptionAdvice.class);

	/**
	 * 处理参数校验失败的结果
	 */
	@ExceptionHandler({ BindException.class, MethodArgumentNotValidException.class
			// ConstraintViolationException.class
	})
	@ResponseBody
	public JsonResponse handleBindException(Exception ex) {
		BindingResult result = null;
		if (ex instanceof BindException) {
			result = ((BindException) ex).getBindingResult();
		} else if (ex instanceof MethodArgumentNotValidException) {
			result = ((MethodArgumentNotValidException) ex).getBindingResult();
		} else {
			ConstraintViolationException e = (ConstraintViolationException) ex;
			return JsonResponse.failed(e.getConstraintViolations().iterator().next().getMessage());
		}
		return JsonResponse.failed(result);
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class, TypeMismatchException.class })
	@ResponseBody
	public JsonResponse handleExceptionForBadRequest(Exception ex) {
		String msg = "";
		if (ex instanceof TypeMismatchException) {
			TypeMismatchException e = ((TypeMismatchException) ex);
			String field = parseFieldName(e);
			if (StringUtils.isNotEmpty(field)) {
				field += "的";
			} else {
				field = "";
			}
			msg = "参数" + field + "值[" + e.getValue() + "]格式不正确，请检查数据格式!";
		} else if (ex instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException e = ((MissingServletRequestParameterException) ex);
			msg = "请提交" + e.getParameterName() + "参数";
		}
		return JsonResponse.failed(msg);
	}

	private String parseFieldName(TypeMismatchException e) {
		if (e instanceof MethodArgumentConversionNotSupportedException) {
			return ((MethodArgumentConversionNotSupportedException) e).getName();
		}
		if (e instanceof MethodArgumentTypeMismatchException) {
			return ((MethodArgumentTypeMismatchException) e).getName();
		}
		return e.getPropertyName();
	}

	/**
	 * 处理所有业务异常
	 */
	@ExceptionHandler(MovenException.class)
	@ResponseBody
	public JsonResponse handleException(MovenException ex) {
		return JsonResponse.failed(ex.getCode(), ex.getMessage());
	}

	/**
	 * 处理所有业务异常，并记录日志
	 */
	@ExceptionHandler(LoggedMovenException.class)
	@ResponseBody
	public JsonResponse handleException(LoggedMovenException ex) {
		LOGGER.warn("出现业务异常", ex);
		return JsonResponse.failed(ex.getCode(), ex.getMessage());
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public JsonResponse handleException(HttpRequestMethodNotSupportedException ex) {
		// logger.warn("提交的HTTP METHOD不支持", ex);
		return JsonResponse.failed("当前URL不支持" + ex.getMethod() + "方法，请检查提交的HTTP方法是否正确！");
	}

	/**
	 * 处理IO其他异常
	 */
	@ExceptionHandler(IOException.class)
	@ResponseBody
	public JsonResponse handleException(IOException ex) {
		return JsonResponse.failed("网络出错！");
	}

	/**
	 * 处理其他异常
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public JsonResponse handleException(Exception ex) {
		LOGGER.error("SERVER500错误", ex);
		return JsonResponse.failed("后台出错，请联系管理员！");
	}

}