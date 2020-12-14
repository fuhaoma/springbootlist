package com.mfh.springboot.list.redislock.entity;

import com.mfh.springboot.list.redislock.entity.SuperEntity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Entity
public class SysUser {
  /**
   * 主键
   */
  @Id
  @GeneratedValue
  private String id;
  /**
   * 创建时间
   */
  private LocalDateTime createdAt;
  /**
   * 更新时间
   */
  private LocalDateTime updatedAt;
  /**
   * 创建人,用户自己注册时为自己
   */
  private String createdBy;
  /**
   * true删除 false未删除
   */
  private Boolean isDelete;
  /**
   * 用户名
   */
  private String username;
  /**
   * 用户头像
   */
  private String avatar;
  /**
   * 密码
   */
  private String password;
  /**
   * 名称
   */
  private String name;
  /**
   * 性别
   */
  private Integer gender;
  /**
   * 身份证号码
   */
  private String idCard;
  /**
   * 生日
   */
  private LocalDate birthday;
  /**
   * 邮箱
   */
  private String email;
  /**
   * 手机号码
   */
  private String mobilePhone;
  /**
   * 账号状态:0未注册  1未完善  2已激活  3未激活  4已冻结
   */
  private Integer status;

  /**
   * 最后一次登录错误时间
   */
  private LocalDateTime lastLoginErrTime;

  /**
   * 登录错误次数
   */
  private Integer loginErrCount;

  /**
   * 是否锁定
   */
  private Boolean isLocked;


}
