/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**

 * 学员转班Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentShiftclass extends DataEntity<StudentShiftclass> {
	
	private static final long serialVersionUID = 1L;

	private Date shiftdate;		// 转班时间
	private String reason;		// 转班原因
	private Long classtoId;		// 转到哪里去
	private Long classfromId;		// 从哪里转
	private Long oldclassUserid;		// 原班级
	private Long newclassUserid;		// 转入班级

	
	public StudentShiftclass() {
		super();
	}

	public StudentShiftclass(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getShiftdate() {
		return shiftdate;
	}

	public void setShiftdate(Date shiftdate) {
		this.shiftdate = shiftdate;
	}
	

	@Length(min=0, max=255, message="转班原因长度必须介于 0 和 255 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Long getClasstoId() {
		return classtoId;
	}

	public void setClasstoId(Long classtoId) {
		this.classtoId = classtoId;
	}
	
	public Long getClassfromId() {
		return classfromId;
	}

	public void setClassfromId(Long classfromId) {
		this.classfromId = classfromId;
	}
	
	public Long getOldclassUserid() {
		return oldclassUserid;
	}

	public void setOldclassUserid(Long oldclassUserid) {
		this.oldclassUserid = oldclassUserid;
	}
	
	public Long getNewclassUserid() {
		return newclassUserid;
	}

	public void setNewclassUserid(Long newclassUserid) {
		this.newclassUserid = newclassUserid;
	}
	
}