/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.Classes;
import com.thinkgem.jeesite.modules.student.dao.ClassesDao;

/**
 * 班级管理Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class ClassesService extends CrudService<ClassesDao, Classes> {

	public Classes get(String id) {
		return super.get(id);
	}
	
	public List<Classes> findList(Classes classes) {
		return super.findList(classes);
	}
	
	public Page<Classes> findPage(Page<Classes> page, Classes classes) {
		return super.findPage(page, classes);
	}
	
	@Transactional(readOnly = false)
	public void save(Classes classes) {
		super.save(classes);
	}
	
	@Transactional(readOnly = false)
	public void delete(Classes classes) {
		super.delete(classes);
	}
	
}