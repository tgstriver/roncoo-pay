package com.roncoo.pay.resolver;

import com.roncoo.pay.common.core.exception.BizException;
import com.roncoo.pay.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RoncooPayExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(RoncooPayExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        if (BizException.class.isAssignableFrom(ex.getClass())) {//如果是业务异常类
            BizException bizException = (BizException) ex;

            try {
                response.setContentType("text/text;charset=UTF-8");
                JsonUtils.responseJson(response, bizException.getMsg());

                Map<String, Object> map = new HashMap<>();
                map.put("errorMsg", bizException.getMsg());//将错误信息传递给view
                return new ModelAndView("exception/exception", map);
            } catch (IOException e) {
                LOG.error("系统异常:", e);

            }
        }
        return null;
    }
}
