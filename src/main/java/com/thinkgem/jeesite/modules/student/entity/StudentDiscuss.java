/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;


/**
 * 分组讨论Entity
 * @author cqx
 * @version 2017-10-30
 */
public class StudentDiscuss extends DataEntity<StudentDiscuss> {

	private static final long serialVersionUID = 1L;
	private Long createrid;		// 创建时间
	private String content;		// 讨论内容
	private Date date;		// 讨论日期
	private String evaluation;		// 评价
	private String score;		// 评分
	private String advice;		// 建议
	private Long pmId;		// 项目经理id
	private Long divgroup;		// 小组id
	private String classname; // 班级名称
	private String groupname; //小组名称
	private String managername; //经理名称

	public StudentDiscuss() {
		super();
	}

	public StudentDiscuss(String id){
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

	@Length(min=1, max=11, message="score长度必须介于 1 和 11 之间")
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

	public Long getPmId() {
		return pmId;
	}

	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}

	public Long getDivgroup() {
		return divgroup;
	}

	public void setDivgroup(Long divgroup) {
		this.divgroup = divgroup;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String mangername) {
		this.managername = managername;
	}
}