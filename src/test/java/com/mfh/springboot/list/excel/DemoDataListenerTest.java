package com.mfh.springboot.list.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.mfh.springboot.list.excel.entity.ARowWriteHandler;
import com.mfh.springboot.list.excel.entity.Absv;
import com.mfh.springboot.list.excel.entity.B;
import com.mfh.springboot.list.excel.entity.DemoData;
import com.mfh.springboot.list.excel.entity.Family;
import com.mfh.springboot.list.service.RootTest;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

//  @Test
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
      excelWriter = EasyExcel.write(fileName, DemoData.class).registerWriteHandler(new Absv()).build();
      // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
      // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
      WriteSheet writeSheet = EasyExcel.writerSheet(1, "模板")
           .registerWriteHandler(new ARowWriteHandler())
           .registerWriteHandler(new Absv())
           .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
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

  private  List<DemoData> data() {
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
//
//  @Data
//  @Accessors(chain = true)
//  @HeadStyle(horizontalAlignment = HorizontalAlignment.LEFT,fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 9)
//  @HeadFontStyle(fontHeightInPoints = 20)
//  @ContentStyle(horizontalAlignment = HorizontalAlignment.LEFT )
//  @ColumnWidth(value = 50)
//  @HeadRowHeight(value =90 )
//  public class DemoData {
//    @ExcelProperty({"111\n22233\n4723476", "字符串标题"})
//    private String string;
//    @ExcelProperty({"111\n22233\n4723476", "日期标题"})
//    private String date;
//    @ExcelProperty({"111\n22233\n4723476", "数字标题"})
//    private Double doubleData;
//
////    public String getString() {
////      return string;
////    }
////
////    public void setString(String string) {
////      this.string = string;
////    }
////
////    public String getDate() {
////      return date;
////    }
////
////    public void setDate(String date) {
////      this.date = date;
////    }
////
////    public Double getDoubleData() {
////      return doubleData;
////    }
////
////    public void setDoubleData(Double doubleData) {
////      this.doubleData = doubleData;
////    }
//  }

  @Test
  public void test1() {
    List<String> a = new ArrayList<>();
    for (String s : a) {
      System.out.println("aaaaaaaaaaaa");
    }
  }

}