/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentFile;
import com.thinkgem.jeesite.modules.student.dao.StudentFileDao;

/**
 * 学员文件Service
 * @author cqx
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class StudentFileService extends CrudService<StudentFileDao, StudentFile> {

	public StudentFile get(String id) {
		return super.get(id);
	}
	
	public List<StudentFile> findList(StudentFile studentFile) {
		return super.findList(studentFile);
	}
	
	public Page<StudentFile> findPage(Page<StudentFile> page, StudentFile studentFile) {
		return super.findPage(page, studentFile);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentFile studentFile) {
		super.save(studentFile);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentFile studentFile) {
		super.delete(studentFile);
	}
	
}