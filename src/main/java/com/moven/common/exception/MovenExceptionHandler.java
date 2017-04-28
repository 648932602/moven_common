package com.moven.common.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * <p>Title:MovenExceptionHandler</p>
 * <p>Description:自定义异常处理</p>
 * @author Shengwei
 * @date 2016年12月1日 下午2:46:14
 */
public class MovenExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// JSON格式返回
		try {
			PrintWriter writer = response.getWriter();
			StringBuilder jsonStr = new StringBuilder();
			if(ex instanceof MovenException){
				jsonStr.append("{\"code\":").append(((MovenException) ex).getCode()).append(",");
				jsonStr.append("\"message\":\"").append(((MovenException) ex).getMessage()).append("\"}");
			} else {
				jsonStr.append(ex.getMessage());
			}
			writer.write(jsonStr.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
