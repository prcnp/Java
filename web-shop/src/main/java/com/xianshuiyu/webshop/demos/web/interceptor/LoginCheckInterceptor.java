package com.xianshuiyu.webshop.demos.web.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.xianshuiyu.webshop.demos.web.Utils.JwtUtils;
import com.xianshuiyu.webshop.demos.web.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor
{
    @Override//目标资源方法运行前运行，返回true 放行；返回false，不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception
    {
        //获取请求的url
        String url = req.getRequestURL().toString();
        log.info("请求的url  {}",url);

        //判断url中是否存在login 如果有 则放行
        if(url.contains("login"))
        {
            log.info("登录操作");
            return true;
        }

        //获取请求头中的令牌(token)
        String jwt = req.getHeader("token");

        //判断令牌是否存在 如果不存在 返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt))
        {
            log.info("请求头token为空");
            Result error = Result.error("NOT_LOGIN");
            //使用fastJSON手动转换
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //解析JWT令牌  如果解析失败 返回错误结果（未登录）
        try
        {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e)
        {
            e.printStackTrace();
            log.info("解析令牌失败 返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //放行
        log.info("令牌合法 放行");
        return true;
    }

    @Override//目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override//视图渲染完成后运行,最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
