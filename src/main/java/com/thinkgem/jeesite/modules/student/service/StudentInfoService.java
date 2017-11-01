/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentInfo;
import com.thinkgem.jeesite.modules.student.dao.StudentInfoDao;

/**
<<<<<<< HEAD
 * 学生信息Service
 * @author cqx
 * @version 2017-11-01
=======
 * 学员档案Service
 * @author cqx
 * @version 2017-10-30
>>>>>>> 559c3f57f8a7d5bcf0cdbb7825cddc92d60258a4
 */
@Service
@Transactional(readOnly = true)
public class StudentInfoService extends CrudService<StudentInfoDao, StudentInfo> {

	public StudentInfo get(String id) {
		return super.get(id);
	}
	
	public List<StudentInfo> findList(StudentInfo studentInfo) {
		return super.findList(studentInfo);
	}
	
	public Page<StudentInfo> findPage(Page<StudentInfo> page, StudentInfo studentInfo) {
		return super.findPage(page, studentInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentInfo studentInfo) {
		super.save(studentInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentInfo studentInfo) {
		super.delete(studentInfo);
	}
	
}