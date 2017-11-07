/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目详情管理Entity
 * @author cqx
 * @version 2017-11-02
 */
public class StudentProjectpollItem extends DataEntity<StudentProjectpollItem> {
	
	private static final long serialVersionUID = 1L;
	private String weighscore;		// 高分
	private String pollscore;		// 考核分数
	private String other;		// 说明
	private Long pollId;		// 考核
	private Long studentId;		// 学员
	
	public StudentProjectpollItem() {
		super();
	}

	public StudentProjectpollItem(String id){
		super(id);
	}

	@Length(min=1, max=11, message="高分长度必须介于 1 和 11 之间")
	public String getWeighscore() {
		return weighscore;
	}

	public void setWeighscore(String weighscore) {
		this.weighscore = weighscore;
	}
	
	@Length(min=1, max=11, message="考核分数长度必须介于 1 和 11 之间")
	public String getPollscore() {
		return pollscore;
	}

	public void setPollscore(String pollscore) {
		this.pollscore = pollscore;
	}
	
	@Length(min=0, max=255, message="说明长度必须介于 0 和 255 之间")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	public Long getPollId() {
		return pollId;
	}

	public void setPollId(Long pollId) {
		this.pollId = pollId;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
}