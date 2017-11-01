/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentPraise;
import com.thinkgem.jeesite.modules.student.dao.StudentPraiseDao;

/**
 * 学员表扬Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class StudentPraiseService extends CrudService<StudentPraiseDao, StudentPraise> {

	public StudentPraise get(String id) {
		return super.get(id);
	}
	
	public List<StudentPraise> findList(StudentPraise studentPraise) {
		return super.findList(studentPraise);
	}
	
	public Page<StudentPraise> findPage(Page<StudentPraise> page, StudentPraise studentPraise) {
		return super.findPage(page, studentPraise);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentPraise studentPraise) {
		super.save(studentPraise);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentPraise studentPraise) {
		super.delete(studentPraise);
	}
	
}