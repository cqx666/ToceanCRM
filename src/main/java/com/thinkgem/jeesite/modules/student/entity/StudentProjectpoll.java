/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目考核Entity
 * @author cqx
 * @version 2017-10-30
 */
public class StudentProjectpoll extends DataEntity<StudentProjectpoll> {
	
	private static final long serialVersionUID = 1L;
	private Date polldate;		// polldate
	private String team;		// team
	private String score;		// score
	private String projectname;		// projectname
	private String location;		// location
	private String polltype;		// polltype
	private Long classesId;		// classes_id
	private String source;		// source
	private String filename;		// filename
	
	public StudentProjectpoll() {
		super();
	}

	public StudentProjectpoll(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPolldate() {
		return polldate;
	}

	public void setPolldate(Date polldate) {
		this.polldate = polldate;
	}
	
	@Length(min=0, max=10, message="team长度必须介于 0 和 10 之间")
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	@Length(min=1, max=11, message="score长度必须介于 1 和 11 之间")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Length(min=0, max=50, message="projectname长度必须介于 0 和 50 之间")
	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	
	@Length(min=0, max=50, message="location长度必须介于 0 和 50 之间")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Length(min=1, max=11, message="polltype长度必须介于 1 和 11 之间")
	public String getPolltype() {
		return polltype;
	}

	public void setPolltype(String polltype) {
		this.polltype = polltype;
	}
	
	public Long getClassesId() {
		return classesId;
	}

	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=50, message="filename长度必须介于 0 和 50 之间")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}