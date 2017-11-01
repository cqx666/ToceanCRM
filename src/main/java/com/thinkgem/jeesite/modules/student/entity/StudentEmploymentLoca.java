/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员就业地点Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentEmploymentLoca extends DataEntity<StudentEmploymentLoca> {
	
	private static final long serialVersionUID = 1L;
	private String locaName;		// 就业地点名称
	
	public StudentEmploymentLoca() {
		super();
	}

	public StudentEmploymentLoca(String id){
		super(id);
	}

	@Length(min=0, max=20, message="就业地点名称长度必须介于 0 和 20 之间")
	public String getLocaName() {
		return locaName;
	}

	public void setLocaName(String locaName) {
		this.locaName = locaName;
	}
	
}