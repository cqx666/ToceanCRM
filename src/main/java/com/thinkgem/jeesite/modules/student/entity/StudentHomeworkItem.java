/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员作业Entity
 * @author cqx
 * @version 2017-11-03
 */
public class StudentHomeworkItem extends DataEntity<StudentHomeworkItem> {
	
	private static final long serialVersionUID = 1L;
	private String studentId;		// 学员
	private String classesId;		// 班级
	private String homeworkId;		// 作业标题
	private String courseId;		// 课程
	private String filename;		// 源代码和文档
	private String score;		// 分数
	private String comment;		// 评语
	private String status;		// 状态
	
	public StudentHomeworkItem() {
		super();
	}

	public StudentHomeworkItem(String id){
		super(id);
	}

	@Length(min=1, max=20, message="学员长度必须介于 1 和 20 之间")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	@Length(min=0, max=20, message="班级长度必须介于 0 和 20 之间")
	public String getClassesId() {
		return classesId;
	}

	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}
	
	@Length(min=1, max=20, message="作业标题长度必须介于 1 和 20 之间")
	public String getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	@Length(min=1, max=20, message="课程长度必须介于 1 和 20 之间")
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	@Length(min=0, max=64, message="源代码和文档长度必须介于 0 和 64 之间")
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
	
	@Length(min=0, max=255, message="评语长度必须介于 0 和 255 之间")
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
	
}