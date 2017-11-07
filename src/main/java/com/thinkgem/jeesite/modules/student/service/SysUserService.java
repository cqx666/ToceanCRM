/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.SysUser;
import com.thinkgem.jeesite.modules.student.dao.SysUserDao;

/**
 * 系统用户Service
 * @author cqx
 * @version 2017-11-06
 */
@Service
@Transactional(readOnly = true)
public class SysUserService extends CrudService<SysUserDao, SysUser> {

	public SysUser get(String id) {
		return super.get(id);
	}
	
	public List<SysUser> findList(SysUser user) {
		return super.findList(user);
	}
	
	public Page<SysUser> findPage(Page<SysUser> page, SysUser user) {
		return super.findPage(page, user);
	}
	
	@Transactional(readOnly = false)
	public void save(SysUser user) {
		super.save(user);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysUser user) {
		super.delete(user);
	}
	
}