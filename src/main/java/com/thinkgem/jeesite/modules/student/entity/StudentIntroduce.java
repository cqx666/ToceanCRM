/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员转介绍Entity
 * @author cqx
 * @version 2017-10-30
 */
public class StudentIntroduce extends DataEntity<StudentIntroduce> {
	
	private static final long serialVersionUID = 1L;
	private String student;		// student
	private Date introdate;		// introdate
	private Long employee;		// employee_id
	private Long studentId;		// student_id
	
	public StudentIntroduce() {
		super();
	}

	public StudentIntroduce(String id){
		super(id);
	}

	@Length(min=0, max=10, message="student长度必须介于 0 和 10 之间")
	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getIntrodate() {
		return introdate;
	}

	public void setIntrodate(Date introdate) {
		this.introdate = introdate;
	}
	
	public Long getEmployee() {
		return employee;
	}

	public void setEmployee(Long employee) {
		this.employee = employee;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
}