/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员违纪Entity
 * @author cqx
 * @version 2017-11-02
 */
public class StudentViolation extends DataEntity<StudentViolation> {
	
	private static final long serialVersionUID = 1L;
	private String violationdesc;		// 违纪情况
	private String handleway;		// 处理方式
	private Date viloationdate;		// 违纪时间
	private String studentattitude;		// 学员态度
	private String booker;		// 登记人
	private Date bookdate;		// 登记时间
	private String confirmer;		// 证实人
	private Date confirmdate;		// 证实时间
	private String status;		// 状态
	private String score;		// 分数
	private String student;		// 学生
	private String classes;		// 班级
	private String opinion;		// 意见
	
	public StudentViolation() {
		super();
	}

	public StudentViolation(String id){
		super(id);
	}

	@Length(min=0, max=255, message="违纪情况长度必须介于 0 和 255 之间")
	public String getViolationdesc() {
		return violationdesc;
	}

	public void setViolationdesc(String violationdesc) {
		this.violationdesc = violationdesc;
	}
	
	@Length(min=0, max=20, message="处理方式长度必须介于 0 和 20 之间")
	public String getHandleway() {
		return handleway;
	}

	public void setHandleway(String handleway) {
		this.handleway = handleway;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getViloationdate() {
		return viloationdate;
	}

	public void setViloationdate(Date viloationdate) {
		this.viloationdate = viloationdate;
	}
	
	@Length(min=0, max=20, message="学员态度长度必须介于 0 和 20 之间")
	public String getStudentattitude() {
		return studentattitude;
	}

	public void setStudentattitude(String studentattitude) {
		this.studentattitude = studentattitude;
	}
	
	@Length(min=0, max=10, message="登记人长度必须介于 0 和 10 之间")
	public String getBooker() {
		return booker;
	}

	public void setBooker(String booker) {
		this.booker = booker;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBookdate() {
		return bookdate;
	}

	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}
	
	@Length(min=0, max=10, message="证实人长度必须介于 0 和 10 之间")
	public String getConfirmer() {
		return confirmer;
	}

	public void setConfirmer(String confirmer) {
		this.confirmer = confirmer;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getConfirmdate() {
		return confirmdate;
	}

	public void setConfirmdate(Date confirmdate) {
		this.confirmdate = confirmdate;
	}
	
	@Length(min=0, max=11, message="状态长度必须介于 0 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Length(min=0, max=64, message="学生长度必须介于 0 和 64 之间")
	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}
	
	@Length(min=0, max=64, message="班级长度必须介于 0 和 64 之间")
	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
}