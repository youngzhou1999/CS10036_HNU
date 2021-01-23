package com.example.newdemo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;





@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /**
     * CROS跨域的处理
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
//                .allowCredentials(true)
                .maxAge(3600);
    }
}
// // // package com.example.newdemo.config;

// // // import org.springframework.context.annotation.Configuration;
// // // import org.springframework.web.servlet.config.annotation.CorsRegistry;
// // // import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// // // @Configuration
// // // public class WebConfiguration implements WebMvcConfigurer {

// // //     @Override
// // //     public void addCorsMappings(CorsRegistry registry) {

// // //         registry.addMapping("/**") // 允许跨域访问的路径
// // //                 .allowedMethods("GET","POST","PUT","DELETE") //允许的跨域方法
// // //                 .allowedOrigins("*") // 允许跨域的源(注意:当该项为 *  时,allowCredentials()不能为false),否则预检失败
// // //                 .allowedHeaders("*")           // 允许的头部设置
// // //                 .allowCredentials(true)         // (注意,只有非简单请求,该项才有效。简单请求无否如何都会发送接收cookie)是否允许发送cookie至浏览器,或接收浏览器cookie
// // //                 .maxAge(168000);                // 预检查间隔时间。表示隔168000秒才发起预检请求。也就是说，发送两次请求
// // //     }
// // // }
