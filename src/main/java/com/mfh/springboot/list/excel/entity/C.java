package com.mfh.springboot.list.excel.entity;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class C {

  public void testW() {
  StopWatch stopWatch = new StopWatch();
  stopWatch.start();
  // 写法1
  String fileName = "aaaaaa.xlsx";
  // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
  // 如果这里想使用03 则 传入excelType参数即可
//    EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
  ExcelWriter excelWriter = null;
  try {
    // 这里 指定文件
    excelWriter = EasyExcel.write(fileName, DemoData.class).build();
    // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
    // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
    WriteSheet writeSheet = EasyExcel.writerSheet(1, "模板")
         .registerWriteHandler(new ARowWriteHandler())
         .registerWriteHandler(new Absv())
         .build();
//      WriteSheet writeSheet =;
//      writeSheet.setCustomConverterList(List.of(new Converter() {
//        @Override
//        public Class supportJavaTypeKey() {
//          return null;
//        }
//
//        @Override
//        public CellDataTypeEnum supportExcelTypeKey() {
//          return null;
//        }
//
//        @Override
//        public Object convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
////          contentProperty.
//          return null;
//        }
//
//        @Override
//        public CellData convertToExcelData(Object value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
//          return null;
//        }
//      }));
//      WriteHandler
//      writeSheet.(List.of(new ARowWriteHandler()));

    for (int i = 0; i < 365; i++) {
      // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
      excelWriter.write(data(),writeSheet);
    }
  } finally {
    // 千万别忘记finish 会帮忙关闭流
    if (excelWriter != null) {
      excelWriter.finish();
    }
  }
  stopWatch.stop();
  System.out.println(stopWatch.getTotalTimeMillis() / 1000.0);
}

  private List<DemoData> data() {
    List<DemoData> list = new ArrayList<>();
    for (int i = 0; i < 2000; i++) {
      DemoData data = new DemoData();
      data.setString("字符串司法局爽肤水" + i);
      data.setDate("积分实付金额变更");
      data.setDoubleData("0.56");
//      data.setGrade(List.of("AA","BBB"));
      list.add(data);
    }
    return list;
  }
}
