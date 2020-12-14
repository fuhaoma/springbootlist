package com.mfh.springboot.list.excel.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.annotation.write.style.OnceAbsoluteMerge;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.util.List;

//@HeadStyle(horizontalAlignment = HorizontalAlignment.LEFT, fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 9)
//@HeadFontStyle(fontHeightInPoints = 12)
//@HeadRowHeight(value = 65)
@ColumnWidth(value = 35)
@ContentStyle(horizontalAlignment = HorizontalAlignment.CENTER, fillForegroundColor = 3, fillPatternType = FillPatternType.SOLID_FOREGROUND,
     borderTop = BorderStyle.THIN, borderLeft = BorderStyle.THIN, borderBottom = BorderStyle.THIN, borderRight = BorderStyle.THIN)
//@ContentRowHeight(22)
@Data
@Accessors(chain = true)
//@ContentFontStyle(fontHeightInPoints = 9)
public class DemoData {
  @ExcelProperty(value = {"说明：\n" +
       "1. 消课时间：实际扣减课时课时的时间\n" +
       "2. 实际课耗：学员单人单次扣减课时×消课学员总数\n" +
       "3. 年级分布：该消课课程的上课学员属于哪个年级；仅显示扣减课时的学员的年级分布", "字符串标题"})
//  @ContentStyle(horizontalAlignment = HorizontalAlignment.CENTER, fillForegroundColor = 3, fillPatternType = FillPatternType.SOLID_FOREGROUND,
//       borderTop = BorderStyle.THIN, borderLeft = BorderStyle.THIN, borderBottom = BorderStyle.THIN, borderRight = BorderStyle.THIN)
  private String string;
  @ExcelProperty(value = {"说明：\n" +
       "1. 消课时间：实际扣减课时课时的时间\n" +
       "2. 实际课耗：学员单人单次扣减课时×消课学员总数\n" +
       "3. 年级分布：该消课课程的上课学员属于哪个年级；仅显示扣减课时的学员的年级分布", "日期标题"})
//  @ContentStyle(horizontalAlignment = HorizontalAlignment.GENERAL, leftBorderColor = 8, rightBorderColor = 8, topBorderColor = 8, bottomBorderColor = 8)
  private String date;
  @ExcelProperty(value = {"说明：\n" +
       "1. 消课时间：实际扣减课时课时的时间\n" +
       "2. 实际课耗：学员单人单次扣减课时×消课学员总数\n" +
       "3. 年级分布：该消课课程的上课学员属于哪个年级；仅显示扣减课时的学员的年级分布", "数字标题"})
  @ContentStyle(horizontalAlignment = HorizontalAlignment.GENERAL, leftBorderColor = 8, rightBorderColor = 8, topBorderColor = 8, bottomBorderColor = 8)
  private String doubleData;

//  @ExcelProperty(value = {"说明：\n"+
//       "1. 消课时间：实际扣减课时课时的时间\n"+
//       "2. 实际课耗：学员单人单次扣减课时×消课学员总数\n"+
//       "3. 年级分布：该消课课程的上课学员属于哪个年级；仅显示扣减课时的学员的年级分布", "动态列"})
//  private List<String> grade;

  public DemoData() {
  }

//  public List<String> getGrade() {
//    return grade;
//  }
//
//  public void setGrade(List<String> grade) {
//    this.grade = grade;
//  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDoubleData() {
    return doubleData;
  }

  public void setDoubleData(String doubleData) {
    this.doubleData = doubleData;
  }
}