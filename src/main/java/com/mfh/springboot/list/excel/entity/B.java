package com.mfh.springboot.list.excel.entity;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toMap;


public class B {
  public static void main(String[] args) {
    new C().testW();
//    Map<String,Long> collect = List.of("aaa", "cccc", "bbb", "aaa").stream().collect(groupingBy(x -> x,counting()));
//    Map<Object, Object> collect1 = List.of().stream().collect(toMap(x -> x, x -> x));
  }
}
