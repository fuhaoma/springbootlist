package com.mfh.springboot.list.redislock.service;

import com.mfh.springboot.list.redislock.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ma_fu
 */
@Service
public class SysUserService {
  @Autowired
  private SysUserDao sysUserDao;

//  public List<SysUser> get() {
//    return sysUserDao.findAll();
//  }

  public void insert() {
     insertOne();
  }

  @Transactional
  public void insertOne() {
    sysUserDao.deleteById("6605287457028182016");
//     sysUserDao.save(new SysUser());
  }

  @Transactional
  public void insert1() {
//     sysUserDao.save(new SysUser());
  }
}
