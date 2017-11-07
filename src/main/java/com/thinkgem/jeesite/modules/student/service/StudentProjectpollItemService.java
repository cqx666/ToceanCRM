/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.StudentProjectpollItem;
import com.thinkgem.jeesite.modules.student.dao.StudentProjectpollItemDao;

/**
 * 项目详情管理Service
 * @author cqx
 * @version 2017-11-02
 */
@Service
@Transactional(readOnly = true)
public class StudentProjectpollItemService extends CrudService<StudentProjectpollItemDao, StudentProjectpollItem> {

	public StudentProjectpollItem get(String id) {
		return super.get(id);
	}
	
	public List<StudentProjectpollItem> findList(StudentProjectpollItem studentProjectpollItem) {
		return super.findList(studentProjectpollItem);
	}
	
	public Page<StudentProjectpollItem> findPage(Page<StudentProjectpollItem> page, StudentProjectpollItem studentProjectpollItem) {
		return super.findPage(page, studentProjectpollItem);
	}
	
	@Transactional(readOnly = false)
	public void save(StudentProjectpollItem studentProjectpollItem) {
		super.save(studentProjectpollItem);
	}
	
	@Transactional(readOnly = false)
	public void delete(StudentProjectpollItem studentProjectpollItem) {
		super.delete(studentProjectpollItem);
	}
	
}