/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentEmploymentLoca;
import com.thinkgem.jeesite.modules.student.dao.StudentEmploymentLocaDao;

/**
 * 学员就业地点Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class StudentEmploymentLocaService extends CrudService<StudentEmploymentLocaDao, StudentEmploymentLoca> {

	public StudentEmploymentLoca get(String id) {
		return super.get(id);
	}
	
	public List<StudentEmploymentLoca> findList(StudentEmploymentLoca studentEmploymentLoca) {
		return super.findList(studentEmploymentLoca);
	}
	
	public Page<StudentEmploymentLoca> findPage(Page<StudentEmploymentLoca> page, StudentEmploymentLoca studentEmploymentLoca) {
		return super.findPage(page, studentEmploymentLoca);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentEmploymentLoca studentEmploymentLoca) {
		super.save(studentEmploymentLoca);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentEmploymentLoca studentEmploymentLoca) {
		super.delete(studentEmploymentLoca);
	}
	
}