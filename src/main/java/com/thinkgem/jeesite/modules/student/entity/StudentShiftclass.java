/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学籍变更Entity
 * @author cqx
 * @version 2017-10-30
 */
public class StudentShiftclass extends DataEntity<StudentShiftclass> {
	
	private static final long serialVersionUID = 1L;
	private Date shiftdate;		// shiftdate
	private String reason;		// reason
	private Long classtoId;		// classto_id
	private Long classfromId;		// classfrom_id
	private Long oldclassUserid;		// oldclass_userid
	private Long newclassUserid;		// newclass_userid
	
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
	
	@Length(min=0, max=255, message="reason长度必须介于 0 和 255 之间")
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