package com.ncu.TrafficInformationSystem.Controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class Interceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{


        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(response.getOutputStream());
        String token = request.getParameter("token");
        response.setHeader("token", token);
        printWriter.println("token:" + token);
        if (null != JwtHelper.parseJWT(token)) {
            Map<String, Object> tokenVal = JwtHelper.parseJWT(token);

            String endTime = tokenVal.get("times").toString();
            long currentTime = System.currentTimeMillis();
            if (Long.valueOf(endTime).longValue() <= currentTime) {
                printWriter.println("token失效");
                printWriter.flush();
                printWriter.close();;
                return false;
            }

            if (tokenVal.get("user_password").equals("1234")) {
                printWriter.println("登录验证成功");
            }
            else{
                printWriter.println("登录验证失败");
            }
            printWriter.flush();
            printWriter.close();
             
            return true;
        }
        else{
            printWriter.println("没有token信息");
            printWriter.flush();
            printWriter.close();
            return false;
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws  Exception{}


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
            throws Exception{}
}
