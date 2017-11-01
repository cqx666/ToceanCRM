/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentEmploymentDire;
import com.thinkgem.jeesite.modules.student.dao.StudentEmploymentDireDao;

/**
 * 学员就业Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class StudentEmploymentDireService extends CrudService<StudentEmploymentDireDao, StudentEmploymentDire> {

	public StudentEmploymentDire get(String id) {
		return super.get(id);
	}
	
	public List<StudentEmploymentDire> findList(StudentEmploymentDire studentEmploymentDire) {
		return super.findList(studentEmploymentDire);
	}
	
	public Page<StudentEmploymentDire> findPage(Page<StudentEmploymentDire> page, StudentEmploymentDire studentEmploymentDire) {
		return super.findPage(page, studentEmploymentDire);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentEmploymentDire studentEmploymentDire) {
		super.save(studentEmploymentDire);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentEmploymentDire studentEmploymentDire) {
		super.delete(studentEmploymentDire);
	}
	
}