package com.lzp.mybatisPlusClickhouse;

import com.baomidou.dynamic.datasource.plugin.MasterSlaveAutoRoutingPlugin;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@MapperScan("com.lzp.mybatisPlusClickhouse.mapper")
@Configuration
public class MybatisPlusClickhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusClickhouseApplication.class, args);
    }
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {

        var interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.CLICK_HOUSE));
        interceptor.plugin(new MasterSlaveAutoRoutingPlugin());
        return interceptor;
    }
}
