/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentLecture;
import com.thinkgem.jeesite.modules.student.dao.StudentLectureDao;

/**
 * 学员演讲Service
 * @author cqx
 * @version 2017-10-30
 */
@Service
@Transactional(readOnly = true)
public class StudentLectureService extends CrudService<StudentLectureDao, StudentLecture> {

	public StudentLecture get(String id) {
		return super.get(id);
	}
	
	public List<StudentLecture> findList(StudentLecture studentLecture) {
		return super.findList(studentLecture);
	}
	
	public Page<StudentLecture> findPage(Page<StudentLecture> page, StudentLecture studentLecture) {
		return super.findPage(page, studentLecture);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentLecture studentLecture) {
		super.save(studentLecture);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentLecture studentLecture) {
		super.delete(studentLecture);
	}
	
}