/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentHomeworkItem;
import com.thinkgem.jeesite.modules.student.dao.StudentHomeworkItemDao;

/**
 * 学员作业Service
 * @author cqx
 * @version 2017-11-03
 */
@Service
@Transactional(readOnly = true)
public class StudentHomeworkItemService extends CrudService<StudentHomeworkItemDao, StudentHomeworkItem> {

	public StudentHomeworkItem get(String id) {
		return super.get(id);
	}
	
	public List<StudentHomeworkItem> findList(StudentHomeworkItem studentHomeworkItem) {
		return super.findList(studentHomeworkItem);
	}
	
	public Page<StudentHomeworkItem> findPage(Page<StudentHomeworkItem> page, StudentHomeworkItem studentHomeworkItem) {
		return super.findPage(page, studentHomeworkItem);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentHomeworkItem studentHomeworkItem) {
		super.save(studentHomeworkItem);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentHomeworkItem studentHomeworkItem) {
		super.delete(studentHomeworkItem);
	}
	
}