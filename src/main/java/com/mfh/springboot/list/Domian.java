package com.mfh.springboot.list;

public class Domian {
    public static void main(String[] args) {
//        String domian = System.clearProperty("com.mfh.springboot.list.Domian");
//        System.out.println(domian);
        System.out.println(Domian.class.getClassLoader().getClass().getName());
        System.out.println(Domian.class.getClassLoader().getParent().getClass().getName());
        System.out.println(Domian.class.getClassLoader().getClass().getClassLoader().getClass().getName());

    }
}
