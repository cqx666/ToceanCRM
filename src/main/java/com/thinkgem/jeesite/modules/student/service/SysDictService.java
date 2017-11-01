/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.SysDict;
import com.thinkgem.jeesite.modules.student.dao.SysDictDao;

/**
 * 数据字典Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class SysDictService extends CrudService<SysDictDao, SysDict> {

	public SysDict get(String id) {
		return super.get(id);
	}
	
	public List<SysDict> findList(SysDict sysDict) {
		return super.findList(sysDict);
	}
	
	public Page<SysDict> findPage(Page<SysDict> page, SysDict sysDict) {
		return super.findPage(page, sysDict);
	}
	
	@Transactional(readOnly = false)
	public void save(SysDict sysDict) {
		super.save(sysDict);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysDict sysDict) {
		super.delete(sysDict);
	}
	
}