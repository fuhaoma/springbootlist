package com.mfh.springboot.list.filelist;


import java.io.File;
import java.util.Objects;

public class FileListDoMain {
  public static void main(String[] args) {
    String pathname = "/Users/ma/Documents/工程经济";
    String fileName = "兴为教育(%d).mp4";
    File fileDir = new File(pathname);
    if (!fileDir.exists() || !fileDir.isDirectory()) {
      System.out.println("路径错误");
      return;
    }
    File[] files = fileDir.listFiles();
    Objects.requireNonNull(files);
    for (File file : files) {
      String name = file.getName();
      int sort = Integer.parseInt(name.substring(name.lastIndexOf("(") + 1, name.lastIndexOf(")")));
      String num = sort < 10 ? String.format("0%d", sort) : String.valueOf(sort);
      file.renameTo(new File(String.format("%s/工程经济第%s集", pathname, num)));
    }
  }
}
