/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**

 * 学员介绍Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentIntroduce extends DataEntity<StudentIntroduce> {
	
	private static final long serialVersionUID = 1L;

	private String student;		// 学员
	private Date introdate;		// 介绍日期
	private Long employeeId;		// 经手人
	private Long studentId;		// 学员外键

	private String employeename;  //经手人名字
	private String introducestudent;//介绍同学
	private String introduceclass;//介绍学员班级
	public StudentIntroduce() {
		super();
	}

	public StudentIntroduce(String id){
		super(id);
	}


	@Length(min=0, max=10, message="学员长度必须介于 0 和 10 之间")
	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getEmployeename() {
		return employeename;
	}

	public String getIntroducestudent() {
		return introducestudent;
	}

	public void setIntroducestudent(String introducestudent) {
		this.introducestudent = introducestudent;
	}

	public String getIntroduceclass() {
		return introduceclass;
	}

	public void setIntroduceclass(String introduceclass) {
		this.introduceclass = introduceclass;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

	public Date getIntrodate() {
		return introdate;
	}

	public void setIntrodate(Date introdate) {
		this.introdate = introdate;
	}
	

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
}