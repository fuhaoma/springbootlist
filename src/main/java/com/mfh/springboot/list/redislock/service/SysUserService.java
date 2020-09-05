package com.mfh.springboot.list.redislock.service;

import com.mfh.springboot.list.redislock.dao.SysUserDao;
import com.mfh.springboot.list.redislock.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ma_fu
 */
@Service
public class SysUserService {
  @Autowired
  private SysUserDao sysUserDao;

  public List<SysUser> get() {
    return sysUserDao.findAll();
  }
}
