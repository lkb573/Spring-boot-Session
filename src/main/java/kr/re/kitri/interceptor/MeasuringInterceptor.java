package kr.re.kitri.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MeasuringInterceptor extends HandlerInterceptorAdapter{

    public static Logger log =
            LoggerFactory.getLogger(MeasuringInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        //log.info("MeasuringInterceptor preHandle");
        long millis = System.currentTimeMillis();
        request.setAttribute("b_time", millis);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

        //log.info("MeasuringInterceptor afterCompletion");

        long endmillis = System.currentTimeMillis();
        long startmillis = (long)request.getAttribute("b_time");
        long elapsedTime = endmillis - startmillis;

        log.info(request.getRequestURI() + " Running Time --> " + elapsedTime);

        super.afterCompletion(request, response, handler, ex);
    }
}