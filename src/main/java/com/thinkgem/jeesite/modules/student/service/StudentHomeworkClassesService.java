/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentHomeworkClasses;
import com.thinkgem.jeesite.modules.student.dao.StudentHomeworkClassesDao;

/**
 * 学员作业类型Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class StudentHomeworkClassesService extends CrudService<StudentHomeworkClassesDao, StudentHomeworkClasses> {

	public StudentHomeworkClasses get(String id) {
		return super.get(id);
	}
	
	public List<StudentHomeworkClasses> findList(StudentHomeworkClasses studentHomeworkClasses) {
		return super.findList(studentHomeworkClasses);
	}
	
	public Page<StudentHomeworkClasses> findPage(Page<StudentHomeworkClasses> page, StudentHomeworkClasses studentHomeworkClasses) {
		return super.findPage(page, studentHomeworkClasses);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentHomeworkClasses studentHomeworkClasses) {
		super.save(studentHomeworkClasses);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentHomeworkClasses studentHomeworkClasses) {
		super.delete(studentHomeworkClasses);
	}
	
}