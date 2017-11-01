/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员作业类型Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentHomeworkClasses extends DataEntity<StudentHomeworkClasses> {
	
	private static final long serialVersionUID = 1L;
	private String homeworkId;		// 作业外键
	private Long classesId;		// 班级外键
	
	public StudentHomeworkClasses() {
		super();
	}

	public StudentHomeworkClasses(String id){
		super(id);
	}

	@Length(min=1, max=64, message="作业外键长度必须介于 1 和 64 之间")
	public String getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	@NotNull(message="班级外键不能为空")
	public Long getClassesId() {
		return classesId;
	}

	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	
}