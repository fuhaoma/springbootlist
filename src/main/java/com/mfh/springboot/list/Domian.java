package com.mfh.springboot.list;

import com.mfh.springboot.list.annotation.Config;
import com.mfh.springboot.list.annotation.beans.SomeBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Domian {
    public static void main(String[] args) {
//        String domian = System.clearProperty("com.mfh.springboot.list.Domian");
//        System.out.println(domian);
//        System.out.println(Domian.class.getClassLoader().getClass().getName());
//        System.out.println(Domian.class.getClassLoader().getParent().getClass().getName());
//        System.out.println(Domian.class.getClassLoader().getClass().getClassLoader().getClass().getName());
//        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
//        SomeBean bean = applicationContext.getBean(SomeBean.class);
//        bean.doWork();
//        applicationContext.close();
        System.out.println(LocalDate.now().minusMonths(5));
        System.out.println(LocalDate.now().plusYears(1));
        System.out.println(ChronoUnit.YEARS
             .between(LocalDate.now().minusMonths(5), LocalDate.now().plusYears(1)));

        System.out.println("asfsf.comssfhauhfe/asfeaf".substring("asfsf.comssfhauhfe/asfeaf".indexOf(".com")+4));
        String url = "http://qiniu.sishuxuefu.com/小熊呀的课程列表1607407977031.xlsx";
        System.out.println(url.substring(0,url.indexOf(".com")+4));
    }
}
