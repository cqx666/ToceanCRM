/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentEmployment;
import com.thinkgem.jeesite.modules.student.dao.StudentEmploymentDao;

/**
 * 学员就业Service
 * @author cqx
 * @version 2017-10-30
 */
@Service
@Transactional(readOnly = true)
public class StudentEmploymentService extends CrudService<StudentEmploymentDao, StudentEmployment> {

	public StudentEmployment get(String id) {
		return super.get(id);
	}
	
	public List<StudentEmployment> findList(StudentEmployment studentEmployment) {
		return super.findList(studentEmployment);
	}
	
	public Page<StudentEmployment> findPage(Page<StudentEmployment> page, StudentEmployment studentEmployment) {
		return super.findPage(page, studentEmployment);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentEmployment studentEmployment) {
		super.save(studentEmployment);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentEmployment studentEmployment) {
		super.delete(studentEmployment);
	}
	
}