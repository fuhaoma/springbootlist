package com.mfh.springboot.list.service;

import com.mfh.springboot.list.redislock.entity.SysUser;
import com.mfh.springboot.list.redislock.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysUserServiceTest extends RootTest{

  @Autowired
  private SysUserService sysUserService;

  @Test
 public void get() {
    List<SysUser> sysUsers = sysUserService.get();
  }
}