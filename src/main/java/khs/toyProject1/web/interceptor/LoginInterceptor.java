package khs.toyProject1.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);    //false로 설정해야 새로운 세션이 생성되지 않음

        log.info("session={}",session);
        if (session == null || session.getAttribute("loginMember") == null) {
            log.info("sessionNull={}",session) ;
            response.sendRedirect("/login");
            return false;
        }
        log.info("sessionNotNull={}",session);

        return true;
    }
}
