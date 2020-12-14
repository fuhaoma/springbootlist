package com.mfh.springboot.list.excel.entity;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import java.util.List;

public class ARowWriteHandler implements RowWriteHandler, CellWriteHandler, SheetWriteHandler {

  private WriteCellStyle writeCellStyle;

  public ARowWriteHandler() {
//    cellStyle=new XSSFCellStyle(new StylesTable());
//    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//    cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
    writeCellStyle = new WriteCellStyle();
    writeCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
    writeCellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
  }

  @Override
  public void beforeRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Integer rowIndex, Integer relativeRowIndex, Boolean isHead) {

  }

  @Override
  public void afterRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
//    StylesTable stylesSource = new StylesTable();
//    CellStyle rowStyle = row.getRowStyle() == null ? new XSSFCellStyle(stylesSource) : row.getRowStyle();
//    rowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//    rowStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//    row.setRowStyle(rowStyle);
  }

  @Override
  public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
//    if (relativeRowIndex == 0 && isHead.equals(true)) {
//      row.setHeightInPoints(100);
//      WriteCellStyle style = new WriteCellStyle();
//      style.setVerticalAlignment(VerticalAlignment.CENTER);
//      style.setHorizontalAlignment(HorizontalAlignment.LEFT);
//      style.setBorderBottom(BorderStyle.THIN);
//      style.setBorderLeft(BorderStyle.THIN);
//      style.setBorderRight(BorderStyle.THIN);
//      style.setBorderTop(BorderStyle.THIN);
//      WriteFont writeFont = new WriteFont();
//      writeFont.setBold(true);
//
//      style.setWriteFont(writeFont);
//
//      CellStyle cellStyle = StyleUtil.buildHeadCellStyle(row.getSheet().getWorkbook(), style);
//      row.setRowStyle(cellStyle);
//    }
//    int lastCellNum = row.getLastCellNum();
//    CellStyle style = row.getRowStyle() == null ? new XSSFCellStyle(new StylesTable()) : row.getRowStyle();
//    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//    style.setFillForegroundColor(IndexedColors.RED.getIndex());
//    row.getSheet().setDefaultColumnStyle(4, style);
//    for (int i = 0; i < lastCellNum; i++) {
//      Cell cell = row.getCell(i);
//      CellStyle style1 = cell.getCellStyle();
//      style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//      style1.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//      cell.setCellStyle(style1);
//    }
//    Cell cell = row.createCell(lastCellNum);
//    CellStyle style2 = cell.getCellStyle();
////    style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
////    style2.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//    cell.setCellStyle(style2);
//    cell.setCellValue("aaaaaaaaaaaaaa");

//    if (row.getLastCellNum() >= 2) {
      Cell cell1 = row.createCell(3);
      cell1.setCellValue("aaaaaaaaaaaaaa");
      Cell cel2 = row.createCell(4);
      cel2.setCellValue("BBBB");
//      cell1.setCellStyle(StyleUtil.buildHeadCellStyle(cell1.getSheet().getWorkbook(), writeCellStyle));
//      cel2.setCellStyle(StyleUtil.buildHeadCellStyle(cel2.getSheet().getWorkbook(), writeCellStyle));
//    }
  }

  @Override
  public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {
//    StylesTable stylesSource = new StylesTable();
//    CellStyle rowStyle = row.getRowStyle() == null ? new XSSFCellStyle(stylesSource) : row.getRowStyle();
//    rowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//    rowStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//    row.setRowStyle(rowStyle);
  }

  @Override
  public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

  }

  @Override
  public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

  }

  @Override
  public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
    Row row = cell.getRow();

    if (cell.getColumnIndex() >= 2) {
//      Cell cell1 = row.createCell(cell.getColumnIndex() + 1);
//      cell1.setCellValue("aaaaaaaaaaaaaa");
//      Cell cel2 = row.createCell(cell.getColumnIndex() + 2);
//      cel2.setCellValue("BBBB");
//      cell1.setCellStyle(StyleUtil.buildHeadCellStyle(cell1.getSheet().getWorkbook(), writeCellStyle));
//      cel2.setCellStyle(StyleUtil.buildHeadCellStyle(cel2.getSheet().getWorkbook(), writeCellStyle));
    }
//    CellStyle cellStyle1 = cell.getCellStyle();
//    cellStyle1.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//    cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//    cell.setCellStyle(cellStyle1);
    if (relativeRowIndex == 0 && isHead.equals(true)) {
      row.setHeightInPoints(100);
      WriteCellStyle style = new WriteCellStyle();
      style.setVerticalAlignment(VerticalAlignment.CENTER);
      style.setBorderBottom(BorderStyle.THIN);
      style.setBorderLeft(BorderStyle.THIN);
      style.setBorderRight(BorderStyle.THIN);
      style.setBorderTop(BorderStyle.THIN);
      style.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
      style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
      WriteFont writeFont = new WriteFont();
      style.setHorizontalAlignment(HorizontalAlignment.LEFT);
      style.setWriteFont(writeFont);
      CellStyle cellStyle = StyleUtil.buildHeadCellStyle(cell.getSheet().getWorkbook(), style);
      cell.setCellStyle(cellStyle);
    } else if (relativeRowIndex == 1 && isHead.equals(true)) {
      row.setHeightInPoints(30);
      WriteCellStyle style = new WriteCellStyle();
      style.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
      style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
      style.setVerticalAlignment(VerticalAlignment.CENTER);
      style.setBorderBottom(BorderStyle.THIN);
      style.setBorderLeft(BorderStyle.THIN);
      style.setBorderRight(BorderStyle.THIN);
      style.setBorderTop(BorderStyle.THIN);
      WriteFont writeFont = new WriteFont();
      style.setHorizontalAlignment(HorizontalAlignment.CENTER);
      writeFont.setBold(true);
      writeFont.setFontName("黑体");
      style.setWriteFont(writeFont);
      CellStyle cellStyle = StyleUtil.buildHeadCellStyle(cell.getSheet().getWorkbook(), style);
      cell.setCellStyle(cellStyle);
    }
  }

  @Override
  public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

  }

  @Override
  public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
//    writeSheetHolder.getCachedSheet().getWorkbook().
  }
}
