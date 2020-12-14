package com.mfh.springboot.list.annotation;

import com.mfh.springboot.list.annotation.beans.SomeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Config {
//  @Bean
//  public SomeBean someBean() {
//    return new SomeBean();
//  }

  @Bean(initMethod = "init", destroyMethod = "destroy")
  public SomeBean someBean1() {
    return new SomeBean();
  }
}
