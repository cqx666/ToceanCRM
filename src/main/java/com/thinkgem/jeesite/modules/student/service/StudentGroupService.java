/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentGroup;
import com.thinkgem.jeesite.modules.student.dao.StudentGroupDao;

/**
 * 学员分组Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class StudentGroupService extends CrudService<StudentGroupDao, StudentGroup> {

	public StudentGroup get(String id) {
		return super.get(id);
	}
	
	public List<StudentGroup> findList(StudentGroup studentGroup) {
		return super.findList(studentGroup);
	}
	
	public Page<StudentGroup> findPage(Page<StudentGroup> page, StudentGroup studentGroup) {
		return super.findPage(page, studentGroup);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentGroup studentGroup) {
		super.save(studentGroup);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentGroup studentGroup) {
		super.delete(studentGroup);
	}
	
}