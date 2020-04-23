package cn.zhongguochu.demo.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@Configuration
public class DruidConfig {
    // 相当于Web Servlet配置
    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet() {
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        servletServletRegistrationBean.addInitParameter("allow", "127.0.0.1"); // 白名单
        servletServletRegistrationBean.addInitParameter("deny", "192.168.1.119"); // 黑名单，存在共同时，deny优先于allow
        servletServletRegistrationBean.addInitParameter("loginUsername", "admin"); // druid登陆账号
        servletServletRegistrationBean.addInitParameter("loginPassword", "admin"); // druid登陆密码
        servletServletRegistrationBean.addInitParameter("resetEnable", "true"); // 是否能够重置数据
        return servletServletRegistrationBean;
    }
}
