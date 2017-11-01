/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentHomework;
import com.thinkgem.jeesite.modules.student.dao.StudentHomeworkDao;

/**
 * 学员作业Service
 * @author cqx
<<<<<<< HEAD
 * @version 2017-11-01
=======
 * @version 2017-10-30
>>>>>>> 559c3f57f8a7d5bcf0cdbb7825cddc92d60258a4
 */
@Service
@Transactional(readOnly = true)
public class StudentHomeworkService extends CrudService<StudentHomeworkDao, StudentHomework> {

	public StudentHomework get(String id) {
		return super.get(id);
	}
	
	public List<StudentHomework> findList(StudentHomework studentHomework) {
		return super.findList(studentHomework);
	}
	
	public Page<StudentHomework> findPage(Page<StudentHomework> page, StudentHomework studentHomework) {
		return super.findPage(page, studentHomework);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentHomework studentHomework) {
		super.save(studentHomework);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentHomework studentHomework) {
		super.delete(studentHomework);
	}
	
}