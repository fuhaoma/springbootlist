package com.mfh.springboot.list.excel.entity;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A {

  /**
   * 导出表头必填字段标红色
   *
   * @param outputStream      输入流
   * @param dataList          导入数据
   * @param headList          表头列表
   * @param sheetName         sheetname
   * @param cellWriteHandlers
   */
  public static void writeExcelWithModel(OutputStream outputStream, List<? extends Object> dataList, List<String> headList, String sheetName, CellWriteHandler... cellWriteHandlers) {
    List<List<String>> list = new ArrayList<>();
    if (headList != null) {
      headList.forEach(h -> list.add(Collections.singletonList(h)));
    }

    // 头的策略
    WriteCellStyle headWriteCellStyle = new WriteCellStyle();
    // 单元格策略
    WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
    // 初始化表格样式
    HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

    ExcelWriterSheetBuilder excelWriterSheetBuilder = EasyExcel.write(outputStream).head(list).sheet(sheetName).registerWriteHandler(horizontalCellStyleStrategy);
    if (null != cellWriteHandlers && cellWriteHandlers.length > 0) {
      for (int i = 0; i < cellWriteHandlers.length; i++) {
        excelWriterSheetBuilder.registerWriteHandler(cellWriteHandlers[i]);
      }
    }
    // 开始导出
    excelWriterSheetBuilder.doWrite(dataList);
  }

  /**
   * 导出表头必填字段标红色
   *
   * @param outputStream      输入流
   * @param dataList          导入数据
   * @param headList          表头列表
   * @param sheetName         sheetname
   * @param cellWriteHandlers
   */
  public static void writeExcelWithModel(OutputStream outputStream, List<? extends Object> dataList, Class<? extends Object> headList, String sheetName, CellWriteHandler... cellWriteHandlers) {

    // 头的策略
    WriteCellStyle headWriteCellStyle = new WriteCellStyle();
    // 单元格策略
    WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
    // 初始化表格样式
    HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

    ExcelWriterSheetBuilder excelWriterSheetBuilder = EasyExcel.write(outputStream, headList).sheet(sheetName).registerWriteHandler(horizontalCellStyleStrategy);
    if (null != cellWriteHandlers && cellWriteHandlers.length > 0) {
      for (int i = 0; i < cellWriteHandlers.length; i++) {
        excelWriterSheetBuilder.registerWriteHandler(cellWriteHandlers[i]);
      }
    }
    // 开始导出
    excelWriterSheetBuilder.doWrite(dataList);
  }

  public static void main(String[] args) throws Exception {

    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    // 输出流
    OutputStream outputStream = null;
    outputStream = new FileOutputStream(new File("ggg.xlsx"));

    // 导出的数据
    List<DemoData> dataList = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      DemoData testVO = new DemoData();
      testVO.setString(i + "20");
      testVO.setDoubleData("vo" + i);
      testVO.setDoubleData("school" + i);
      dataList.add(testVO);
    }

    // 标题
    List<String> headList = Arrays.asList("姓名", "年龄", "学校");

    String sheetName = "导出文件";

    List<Integer> columnIndexs = Arrays.asList(0, 1, 2);
    List<Integer> rowIndexs = Arrays.asList(0);
    TitleColorSheetWriteHandler titleColorSheetWriteHandler = new TitleColorSheetWriteHandler(rowIndexs, columnIndexs, IndexedColors.RED.index);

    List<Integer> columnIndexs1 = Arrays.asList(0, 1);
    List<Integer> rowIndexs1 = Arrays.asList(1, 2, 3, 4);
    CellColorSheetWriteHandler colorSheetWriteHandler = new CellColorSheetWriteHandler(rowIndexs1, columnIndexs1, IndexedColors.RED.index);

    writeExcelWithModel(outputStream, dataList, headList, sheetName, titleColorSheetWriteHandler, colorSheetWriteHandler);

    stopWatch.stop();
    System.out.println(stopWatch.getTotalTimeMillis() / 1000.0);
  }

}
