/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员就业Entity
 * @author cqx
 * @version 2017-10-30
 */
public class StudentEmployment extends DataEntity<StudentEmployment> {
	
	private static final long serialVersionUID = 1L;
	private String stuName;		// 申请人姓名
	private Long stuClass;		// 申请人班级
	private Long direId;		// 期望就业方向
	private Long locaId;		// 期望就业地点
	private Date empTime;		// 期望推荐时间
	private String recoJob;		// 是否需要拓胜推荐工作
	private Long fileId;		// file_id
	
	public StudentEmployment() {
		super();
	}

	public StudentEmployment(String id){
		super(id);
	}

	@Length(min=0, max=20, message="申请人姓名长度必须介于 0 和 20 之间")
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public Long getStuClass() {
		return stuClass;
	}

	public void setStuClass(Long stuClass) {
		this.stuClass = stuClass;
	}
	
	public Long getDireId() {
		return direId;
	}

	public void setDireId(Long direId) {
		this.direId = direId;
	}
	
	public Long getLocaId() {
		return locaId;
	}

	public void setLocaId(Long locaId) {
		this.locaId = locaId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEmpTime() {
		return empTime;
	}

	public void setEmpTime(Date empTime) {
		this.empTime = empTime;
	}
	
	@Length(min=0, max=2, message="是否需要拓胜推荐工作长度必须介于 0 和 2 之间")
	public String getRecoJob() {
		return recoJob;
	}

	public void setRecoJob(String recoJob) {
		this.recoJob = recoJob;
	}
	
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	
}