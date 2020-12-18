package com.mfh.springboot.list.filelist;


import java.io.File;
import java.util.Objects;

public class FileListDoMain {
  public static void main(String[] args) {
//    rename();
//    renameForty();
//    rename("/Users/ma/Documents/建筑/市政工程", "%s/市政工程第%s集.mp4");
//    rename("/Users/ma/Documents/建筑/中业/项目管理", "%s/项目管理第%s集.mp4");
//    rename("/Users/ma/Documents/建筑/中业/工程经济", "%s/工程经济第%s集.mp4");
//    huanqiu("/Users/ma/Documents/建筑/环球/建设工程计价");
//    huanqiu("/Users/ma/Documents/建筑/环球/建设工程计价案例分析");
//    huanqiu("/Users/ma/Documents/建筑/环球/建设工程技术与计量(土建)");
  }

  private static void huanqiu(String pathname) {
    File fileDir = new File(pathname);
    if (!fileDir.exists() || !fileDir.isDirectory()) {
      System.out.println("路径错误");
      return;
    }
    File[] files = fileDir.listFiles();
    Objects.requireNonNull(files);
    for (File file : files) {
      String name = file.getName();
      String fileName = name.split("_")[0];
      if (name.contains("第")) {
        int firstIndex = fileName.indexOf("第");
        int speakIndex = fileName.indexOf("讲");
        String substring = fileName.substring(firstIndex + 1, speakIndex);
        String num = Integer.parseInt(substring) < 10 ? "0" + substring : substring;
        file.renameTo(new File(String.format("%s/第%s讲%s.mp4", pathname, num, fileName.substring(speakIndex + 1))));
      } else if (name.contains("联动")) {
        int leftParenthesisIndex = fileName.indexOf("(");
        int index = Integer.parseInt(fileName.substring(leftParenthesisIndex - 1, leftParenthesisIndex)) + 1;
        int num = 50 + (fileName.contains("一") ? index : index + 1);
        file.renameTo(new File(String.format("%s/第%d讲%s.mp4", pathname, num, fileName.substring(0, leftParenthesisIndex + 3))));
      }
    }
  }

  private static void rename(String pathname, String fileName) {
//    String pathname = "/Users/ma/Documents/工程经济";
    File fileDir = new File(pathname);
    if (!fileDir.exists() || !fileDir.isDirectory()) {
      System.out.println("路径错误");
      return;
    }
    File[] files = fileDir.listFiles();
    Objects.requireNonNull(files);
    for (File file : files) {
      String name = file.getName();
      if (name.contains("(")) {
        int sort = Integer.parseInt(name.substring(name.lastIndexOf("(") + 1, name.lastIndexOf(")"))) + 1;
        String num = sort < 10 ? String.format("0%d", sort) : String.valueOf(sort);
        file.renameTo(new File(String.format(fileName, pathname, num)));
      }
    }
  }

  private static void renameForty() {
    String pathname = "/Users/ma/Documents/工程经济/40往后";
    File fileDir = new File(pathname);
    if (!fileDir.exists() || !fileDir.isDirectory()) {
      System.out.println("路径错误");
      return;
    }
    int offset = 40;
    File[] files = fileDir.listFiles();
    Objects.requireNonNull(files);
    for (File file : files) {
      String name = file.getName();
      if (name.contains("(")) {
        int sort = Integer.parseInt(name.substring(name.lastIndexOf("(") + 1, name.lastIndexOf(")")));
        String num = String.valueOf(offset + sort);
        file.renameTo(new File(String.format("%s/工程经济第%s集.mp4", pathname, num)));
      }
    }
  }
}
