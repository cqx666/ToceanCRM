/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员就业Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentEmploymentDire extends DataEntity<StudentEmploymentDire> {
	
	private static final long serialVersionUID = 1L;
	private String direName;		// 就业方向名称
	
	public StudentEmploymentDire() {
		super();
	}

	public StudentEmploymentDire(String id){
		super(id);
	}

	@Length(min=0, max=20, message="就业方向名称长度必须介于 0 和 20 之间")
	public String getDireName() {
		return direName;
	}

	public void setDireName(String direName) {
		this.direName = direName;
	}
	
}