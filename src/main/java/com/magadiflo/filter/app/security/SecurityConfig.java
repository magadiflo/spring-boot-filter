package com.magadiflo.filter.app.security;

import com.magadiflo.filter.app.filter.MyFilter;
import com.magadiflo.filter.app.filter.TimeAccessFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    //NOTA: Si no se especifica el orden, spring lo manda al final de la cola
    @Bean
    public FilterRegistrationBean<MyFilter> myFilter() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/test-filter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<TimeAccessFilter> timeAccessFilter() {
        FilterRegistrationBean<TimeAccessFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new TimeAccessFilter());
        filterRegistrationBean.addUrlPatterns("/test-filter");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }
}
