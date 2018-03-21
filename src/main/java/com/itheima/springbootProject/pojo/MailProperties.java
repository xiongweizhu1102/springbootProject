package com.itheima.springbootProject.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author bear
 * @version 1.0
 * @description com.itheima.springbootProject.pojo
 * @date 2018/3/21
 */
@ConfigurationProperties(prefix = "mail")
@PropertySource(value= "classpath:templates/mail.properties")//注意虽然是编译路径,也要写全
@Component
public class MailProperties {
    private  String host;
    private  Integer port;
    private  String username;
    private  String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MailProperties{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
