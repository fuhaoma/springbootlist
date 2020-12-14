package com.mfh.springboot.list.excel.entity;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.AbstractVerticalCellStyleStrategy;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class Absv extends AbstractVerticalCellStyleStrategy {
  private WriteCellStyle writeCellStyle;
  public Absv() {
    writeCellStyle = new WriteCellStyle();
    writeCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
    writeCellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
  }

  @Override
  protected WriteCellStyle headCellStyle(Head head) {
    return null;
  }


  @Override
  protected WriteCellStyle contentCellStyle(Head head) {
    Integer columnIndex = head.getColumnIndex();

    WriteCellStyle writeCellStyle = new WriteCellStyle();
    writeCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
    writeCellStyle.setBorderBottom(BorderStyle.THIN);
    writeCellStyle.setBorderLeft(BorderStyle.THIN);
    writeCellStyle.setBorderRight(BorderStyle.THIN);
    writeCellStyle.setBorderTop(BorderStyle.THIN);
    if (columnIndex == 1) {
      writeCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
      writeCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
    }
    if (columnIndex == 3) {
      writeCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
      writeCellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
    }
    return writeCellStyle;
  }

}
