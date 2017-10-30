/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentDiscuss;
import com.thinkgem.jeesite.modules.student.dao.StudentDiscussDao;

/**
 * 分组讨论Service
 * @author cqx
 * @version 2017-10-30
 */
@Service
@Transactional(readOnly = true)
public class StudentDiscussService extends CrudService<StudentDiscussDao, StudentDiscuss> {

	public StudentDiscuss get(String id) {
		return super.get(id);
	}
	
	public List<StudentDiscuss> findList(StudentDiscuss studentDiscuss) {
		return super.findList(studentDiscuss);
	}
	
	public Page<StudentDiscuss> findPage(Page<StudentDiscuss> page, StudentDiscuss studentDiscuss) {
		return super.findPage(page, studentDiscuss);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentDiscuss studentDiscuss) {
		super.save(studentDiscuss);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentDiscuss studentDiscuss) {
		super.delete(studentDiscuss);
	}
	
}