package com.mfh.springboot.list.excel;

import com.alibaba.excel.EasyExcel;
import com.mfh.springboot.list.excel.entity.Family;
import com.mfh.springboot.list.service.RootTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DemoDataListenerTest extends RootTest {

  @Test
  public void test() {
    // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
    // 写法1：
//    String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
    // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
    EasyExcel.read(new File("a.xlsx"), Family.class, new DemoDataListener()).sheet().headRowNumber(3).doRead();
    System.out.println("aaaaaa");
//    EasyExcel.read("a.xlsx", Family.class, new DemoDataListener()).sheet().headRowNumber(4).doRead();

    // 写法2：
//    fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//    ExcelReader excelReader = null;
//    try {
//      excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
//      ReadSheet readSheet = EasyExcel.readSheet(0).build();
//      excelReader.read(readSheet);
//    } finally {
//      if (excelReader != null) {
//        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//        excelReader.finish();
//      }
//    }
  }

  @Test
  public void test1() {
    List<String> a = new ArrayList<>();
    for (String s : a) {
      System.out.println("aaaaaaaaaaaa");
    }
  }

}