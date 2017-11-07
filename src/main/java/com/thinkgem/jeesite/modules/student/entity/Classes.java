/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 班级管理Entity
 * @author cqx
 * @version 2017-11-01
 */
public class Classes extends DataEntity<Classes> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 班级名称
	private Date opendate;		// 开班日期
	private Date closedate;		// 结束日期
	private String monitor;		// 班长
	private String studentamount;		// 班级人数
	private String other;		// other
	private Long typeId;		// 类型
	private Long classroomId;		// 教室
	private Long teacherId;		// 教师
	private Long pmId;		// 经理
	private Long subareaId;		// 子范围
	private String qq;		// QQ

	public Classes() {
		super();
	}

	public Classes(String id){
		super(id);
	}

	public String getName() {
		return name;
	}
	@Length(min=0, max=20, message="班级名称长度必须介于 0 和 20 之间")
	public void setName(String name) {
		this.name = name;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}
	
	@Length(min=0, max=20, message="班长长度必须介于 0 和 20 之间")
	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	
	@Length(min=1, max=11, message="班级人数长度必须介于 1 和 11 之间")
	public String getStudentamount() {
		return studentamount;
	}

	public void setStudentamount(String studentamount) {
		this.studentamount = studentamount;
	}
	
	@Length(min=0, max=255, message="other长度必须介于 0 和 255 之间")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}
	
	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	
	public Long getPmId() {
		return pmId;
	}

	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}
	
	public Long getSubareaId() {
		return subareaId;
	}

	public void setSubareaId(Long subareaId) {
		this.subareaId = subareaId;
	}
	
	@Length(min=0, max=10, message="QQ长度必须介于 0 和 10 之间")
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
}