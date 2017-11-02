/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentViolation;
import com.thinkgem.jeesite.modules.student.dao.StudentViolationDao;

/**
 * 学员违纪Service
 * @author cqx
 * @version 2017-11-02
 */
@Service
@Transactional(readOnly = true)
public class StudentViolationService extends CrudService<StudentViolationDao, StudentViolation> {

	public StudentViolation get(String id) {
		return super.get(id);
	}
	
	public List<StudentViolation> findList(StudentViolation studentViolation) {
		return super.findList(studentViolation);
	}
	
	public Page<StudentViolation> findPage(Page<StudentViolation> page, StudentViolation studentViolation) {
		return super.findPage(page, studentViolation);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentViolation studentViolation) {
		super.save(studentViolation);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentViolation studentViolation) {
		super.delete(studentViolation);
	}
	
}