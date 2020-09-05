package com.mfh.springboot.list.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.mfh.springboot.list.excel.entity.Family;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoDataListener extends AnalysisEventListener<Family> {
  private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);
  /**
   * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
   */
  private static final int BATCH_COUNT = 5;
  List<Family> list = new ArrayList<>();
  int t = 0;

  /**
   * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
   */
//  private DemoDAO demoDAO;
  public DemoDataListener() {
//     这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
//    demoDAO = new DemoDAO();
  }

  /**
   * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
   *
   * @param demoDAO
   */
//  public DemoDataListener(DemoDAO demoDAO) {
//    this.demoDAO = demoDAO;
//  }
  @Override
  public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
    try {
      AnalysisContext context1 = context;
    } catch (Exception e) {
      System.out.println("111111111111111");
    }
  }

  /**
   * 这个每一条数据解析都会来调用
   *
   * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
   * @param context
   */
  @Override
  public void invoke(Family data, AnalysisContext context) {
    LOGGER.info("解析到一条数据:{}", data);
    list.add(data);
    t += 1;
    // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
    if (list.size() >= BATCH_COUNT) {
      saveData();
      // 存储完成清理 list
      list.clear();
    }
  }

  /**
   * 所有数据解析完成了 都会来调用
   *
   * @param context
   */
  @Override
  public void doAfterAllAnalysed(AnalysisContext context) {
    // 这里也要保存数据，确保最后遗留的数据也存储到数据库
    saveData();
//    list.forEach(x -> x.setSn(44444));
//    EasyExcel.write(new File("a.xlsx"), Family.class).withTemplate(new File("q.xlsx")).sheet().doWrite(list);
    LOGGER.info("所有数据解析完成！");
    System.out.println(t);
  }

  /**
   * 加上存储数据库
   */
  private void saveData() {
    LOGGER.info("{}条数据，开始存储数据库！", list.size());
//    demoDAO.save(list);
    LOGGER.info("存储数据库成功！");
  }
}
