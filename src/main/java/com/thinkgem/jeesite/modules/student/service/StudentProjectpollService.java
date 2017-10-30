/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentProjectpoll;
import com.thinkgem.jeesite.modules.student.dao.StudentProjectpollDao;

/**
 * 项目考核Service
 * @author cqx
 * @version 2017-10-30
 */
@Service
@Transactional(readOnly = true)
public class StudentProjectpollService extends CrudService<StudentProjectpollDao, StudentProjectpoll> {

	public StudentProjectpoll get(String id) {
		return super.get(id);
	}
	
	public List<StudentProjectpoll> findList(StudentProjectpoll studentProjectpoll) {
		return super.findList(studentProjectpoll);
	}
	
	public Page<StudentProjectpoll> findPage(Page<StudentProjectpoll> page, StudentProjectpoll studentProjectpoll) {
		return super.findPage(page, studentProjectpoll);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentProjectpoll studentProjectpoll) {
		super.save(studentProjectpoll);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentProjectpoll studentProjectpoll) {
		super.delete(studentProjectpoll);
	}
	
}