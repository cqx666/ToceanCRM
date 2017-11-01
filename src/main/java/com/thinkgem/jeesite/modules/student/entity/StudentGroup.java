/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员分组Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentGroup extends DataEntity<StudentGroup> {
	
	private static final long serialVersionUID = 1L;
	private String groupId;		// 分组外键
	private Long studentUserid;		// 学生表外键
	
	public StudentGroup() {
		super();
	}

	public StudentGroup(String id){
		super(id);
	}

	@Length(min=1, max=64, message="分组外键长度必须介于 1 和 64 之间")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	@NotNull(message="学生表外键不能为空")
	public Long getStudentUserid() {
		return studentUserid;
	}

	public void setStudentUserid(Long studentUserid) {
		this.studentUserid = studentUserid;
	}
	
}