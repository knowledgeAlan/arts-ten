package com.zzm.config;

import com.zzm.intercept.ExamplePlugin;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-10-17
 * @time 19:25
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
@Configuration
@EnableAutoConfiguration
public class MybatisInterceptorConfiguration {

    @Bean
    public ExamplePlugin myInterceptor() {
        return new ExamplePlugin();
    }

}