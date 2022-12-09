package com.neo.prudential.assignment.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.neo.prudential.assignment.car.Interceptor.CarInterceptor;
import com.neo.prudential.assignment.car.entity.Car;

/**
 * @author neo
 * @date 2022/12/8
 */
@SpringBootApplication
public class CarRentalApplication implements WebMvcConfigurer {

    @Autowired
    private CarInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        // 这里配置拦截路径
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(
            "/hello2/**",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/css/**",
            "/js/**");
        // WebMvcConfigurer.super.addInterceptors(registry);
    }

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }
}
