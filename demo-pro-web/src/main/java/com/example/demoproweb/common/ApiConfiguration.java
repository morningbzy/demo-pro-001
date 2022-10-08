package com.example.demoproweb.common;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Configuration
@ConditionalOnWebApplication
public class ApiConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public FilterRegistrationBean<BodyDecryptionRequestFilter> contentCachingRequestFilterRegistration() {
        FilterRegistrationBean<BodyDecryptionRequestFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new BodyDecryptionRequestFilter());
        registration.setName("bodyDecryptionRequestFilter");
        registration.setOrder(1);
        return registration;
    }

    public class BodyDecryptionRequestFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            Filter.super.init(filterConfig);
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            RequestWrapper wrapper = new RequestWrapper((HttpServletRequest) request);

            chain.doFilter(wrapper, response);
        }

        @Override
        public void destroy() {
            Filter.super.destroy();
        }
    }
}
