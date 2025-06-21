package tech.build.run.jbank.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class InterceptorAudit implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(InterceptorAudit.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("[after-completion] -> Method: {}, Url: {}, StatusCode: {}, IpAddress: {}",
                request.getMethod(), request.getRequestURI(), response.getStatus(), request.getAttribute("x-user-ip"));
    }
}
