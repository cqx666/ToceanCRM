/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员考勤Entity
 * @author cqx
 * @version 2017-10-30
 */
public class StudentAttendance extends DataEntity<StudentAttendance> {
	
	private static final long serialVersionUID = 1L;
	private Date startdate;		// startdate
	private Date enddate;		// enddate
	private String status;		// status
	private Long studentinfo;		// student_id
	
	public StudentAttendance() {
		super();
	}

	public StudentAttendance(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	@Length(min=1, max=11, message="status长度必须介于 1 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getStudentinfo() {
		return studentinfo;
	}

	public void setStudentinfo(Long studentinfo) {
		this.studentinfo = studentinfo;
	}
	
}