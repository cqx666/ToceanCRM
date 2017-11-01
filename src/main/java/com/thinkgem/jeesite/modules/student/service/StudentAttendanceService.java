/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentAttendance;
import com.thinkgem.jeesite.modules.student.dao.StudentAttendanceDao;

/**
 * 学员考勤Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class StudentAttendanceService extends CrudService<StudentAttendanceDao, StudentAttendance> {

	public StudentAttendance get(String id) {
		return super.get(id);
	}
	
	public List<StudentAttendance> findList(StudentAttendance studentAttendance) {
		return super.findList(studentAttendance);
	}
	
	public Page<StudentAttendance> findPage(Page<StudentAttendance> page, StudentAttendance studentAttendance) {
		return super.findPage(page, studentAttendance);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentAttendance studentAttendance) {
		super.save(studentAttendance);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentAttendance studentAttendance) {
		super.delete(studentAttendance);
	}
	
}