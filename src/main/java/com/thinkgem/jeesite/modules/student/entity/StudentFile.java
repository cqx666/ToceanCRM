/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员文件Entity
 * @author cqx
 * @version 2017-11-01
 */
public class StudentFile extends DataEntity<StudentFile> {
	
	private static final long serialVersionUID = 1L;
	private String pic;		// 图片
	private String picfilename;		// 图片名字
	private String resume;		// 简历
	private String resumefilename;		// 简历名称
	
	public StudentFile() {
		super();
	}

	public StudentFile(String id){
		super(id);
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Length(min=0, max=255, message="图片名字长度必须介于 0 和 255 之间")
	public String getPicfilename() {
		return picfilename;
	}

	public void setPicfilename(String picfilename) {
		this.picfilename = picfilename;
	}
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	@Length(min=0, max=255, message="简历名称长度必须介于 0 和 255 之间")
	public String getResumefilename() {
		return resumefilename;
	}

	public void setResumefilename(String resumefilename) {
		this.resumefilename = resumefilename;
	}
	
}