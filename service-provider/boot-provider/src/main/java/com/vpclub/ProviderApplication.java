package com.vpclub;


import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContexts;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;


@EnableTransactionManagement
@MapperScan("com.vpclub.**.dao")
@EnableFeignClients(basePackages= "com.vpclub.**.openapi")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableCaching
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ProviderApplication {

    public static final String CERT_FILE = "apiclient_cert.p12";



    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}