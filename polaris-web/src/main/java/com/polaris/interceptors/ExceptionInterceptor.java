package com.polaris.interceptors;

import com.alibaba.fastjson.JSON;
import com.polaris.common.constants.SystemConstant;
import com.polaris.common.exception.ParameterException;
import com.polaris.common.exception.ServiceException;
import com.polaris.common.exception.UserExpireException;
import com.polaris.common.re.BaseResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionInterceptor implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(ExceptionInterceptor.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //此处打印日志  用于排查问题
        e.printStackTrace();
        BaseResponse baseResponse = new BaseResponse();
        if (e instanceof ServiceException) {
            baseResponse.setMessage("业务异常" + e.getMessage());
            baseResponse.setCode(SystemConstant.SERVICE_ERROR_CODE);
        } else if (e instanceof ParameterException
                || e instanceof IllegalArgumentException) {
            baseResponse.setMessage("参数异常:" + e.getMessage());
            baseResponse.setCode(SystemConstant.PARAMETER_ERROR_CODE);
        } else if (e instanceof UserExpireException) {
            baseResponse.setMessage("用户会话过期:" + e.getMessage());
            baseResponse.setCode(SystemConstant.USER_EXPIRE_CODE);
        } else {
            baseResponse.setMessage("系统异常");
            baseResponse.setCode(SystemConstant.SYSTEM_ERROR_CODE);
        }
        printJsonResponse(httpServletResponse, JSON.toJSONString(baseResponse));
        return new ModelAndView();
    }

    private void printJsonResponse(HttpServletResponse httpServletResponse, String value) {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        try {
            httpServletResponse.getWriter().print(value);
            httpServletResponse.getWriter().flush();
            httpServletResponse.getWriter().close();
        } catch (Exception e) {
            logger.error("异常处理的时候json转换异常:" + e);
        }
    }
}
