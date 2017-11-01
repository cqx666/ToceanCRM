/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentShiftclass;
import com.thinkgem.jeesite.modules.student.dao.StudentShiftclassDao;

/**
<<<<<<< HEAD
 * 学员转班Service
 * @author cqx
 * @version 2017-11-01
=======
 * 学籍变更Service
 * @author cqx
 * @version 2017-10-30
>>>>>>> 559c3f57f8a7d5bcf0cdbb7825cddc92d60258a4
 */
@Service
@Transactional(readOnly = true)
public class StudentShiftclassService extends CrudService<StudentShiftclassDao, StudentShiftclass> {

	public StudentShiftclass get(String id) {
		return super.get(id);
	}
	
	public List<StudentShiftclass> findList(StudentShiftclass studentShiftclass) {
		return super.findList(studentShiftclass);
	}
	
	public Page<StudentShiftclass> findPage(Page<StudentShiftclass> page, StudentShiftclass studentShiftclass) {
		return super.findPage(page, studentShiftclass);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentShiftclass studentShiftclass) {
		super.save(studentShiftclass);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentShiftclass studentShiftclass) {
		super.delete(studentShiftclass);
	}
	
}