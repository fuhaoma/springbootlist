package com.mfh.springboot.list.redislock.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体必要字段 id createdAt updatedAt
 */
public interface SuperEntity extends Serializable {
  /**
   * 主键
   */
  String getId();

  /**
   * 创建时间
   */
  LocalDateTime getCreatedAt();

  /**
   * 逻辑删除
   */
  Boolean getIsDelete();
}
