/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员作业布置Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentHomeworkItem extends DataEntity<StudentHomeworkItem> {
	
	private static final long serialVersionUID = 1L;
	private String source;		// 原因
	private String filename;		// 文件名
	private String score;		// 分数
	private String comment;		// 评论
	private String status;		// 状态
	private Long studentId;		// 学生外键
	private Long homeworkId;		// 作业外键
	
	public StudentHomeworkItem() {
		super();
	}

	public StudentHomeworkItem(String id){
		super(id);
	}

	@Length(min=0, max=64, message="原因长度必须介于 0 和 64 之间")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=64, message="文件名长度必须介于 0 和 64 之间")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Length(min=0, max=255, message="评论长度必须介于 0 和 255 之间")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Length(min=0, max=11, message="状态长度必须介于 0 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	public Long getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(Long homeworkId) {
		this.homeworkId = homeworkId;
	}
	
}