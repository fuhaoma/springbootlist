package com.mfh.springboot.list.redislock.dao;

import com.mfh.springboot.list.redislock.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends JpaRepository<SysUser, String> {
}
