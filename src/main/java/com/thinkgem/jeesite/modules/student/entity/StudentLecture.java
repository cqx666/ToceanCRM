/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员演讲Entity
 * @author cqx

 * @version 2017-11-01

 */
public class StudentLecture extends DataEntity<StudentLecture> {

	private static final long serialVersionUID = 1L;
	private Long createrid;		// 序号
	private String content;		//演讲内容

	private Date date;		// 演讲日期
	private String evaluation;		// 评价
	private String score;		// 评分
	private String advice;		// 建议

	private Long employee;		// 项目经理id
	private Long studentId;		// 学员id
	private String studentname; //学员名字
	private String classname; //班级
	private String systemname;//项目经理


	public StudentLecture() {
		super();
	}

	public StudentLecture(String id){
		super(id);
	}

	public Long getCreaterid() {
		return createrid;
	}

	public void setCreaterid(Long createrid) {
		this.createrid = createrid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}


	@Length(min=1, max=11, message="评分长度必须介于 1 和 11 之间")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}




	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSystemname() {
		return systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}
}