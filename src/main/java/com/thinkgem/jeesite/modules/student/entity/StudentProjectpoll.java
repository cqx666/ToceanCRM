/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目考核Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentProjectpoll extends DataEntity<StudentProjectpoll> {
	
	private static final long serialVersionUID = 1L;
	private String projectname;		// 项目名称
	private Long classesId;		// 班级
	private String team;		// 小组
	private Date polldate;		// 考核日期
	private String location;		// 位置
	private String score;		// 总分
	private String polltype;		// 考核类型
	private String source;		// 源头
	private String filename;		// 文件名
	
	public StudentProjectpoll() {
		super();
	}

	public StudentProjectpoll(String id){
		super(id);
	}

	@Length(min=1, max=50, message="项目名称长度必须介于 1 和 50 之间")
	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	
	@NotNull(message="班级不能为空")
	public Long getClassesId() {
		return classesId;
	}

	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	
	@Length(min=1, max=10, message="小组长度必须介于 1 和 10 之间")
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPolldate() {
		return polldate;
	}

	public void setPolldate(Date polldate) {
		this.polldate = polldate;
	}
	
	@Length(min=0, max=50, message="位置长度必须介于 0 和 50 之间")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Length(min=0, max=11, message="总分长度必须介于 0 和 11 之间")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Length(min=1, max=11, message="考核类型长度必须介于 1 和 11 之间")
	public String getPolltype() {
		return polltype;
	}

	public void setPolltype(String polltype) {
		this.polltype = polltype;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=50, message="文件名长度必须介于 0 和 50 之间")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}