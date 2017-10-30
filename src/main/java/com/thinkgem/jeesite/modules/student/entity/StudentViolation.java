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
 * @version 2017-10-30
 */
public class StudentViolation extends DataEntity<StudentViolation> {
	
	private static final long serialVersionUID = 1L;
	private String violationdesc;		// violationdesc
	private String handleway;		// handleway
	private Date viloationdate;		// viloationdate
	private String studentattitude;		// studentattitude
	private String booker;		// booker
	private Date bookdate;		// bookdate
	private String confirmer;		// confirmer
	private Date confirmdate;		// confirmdate
	private String status;		// status
	private String score;		// score
	private String other;		// other
	private Long studentId;		// student_id
	private String approve;		// approve
	private String headship;		// headship
	private String opinion;		// opinion
	
	public StudentViolation() {
		super();
	}

	public StudentViolation(String id){
		super(id);
	}

	@Length(min=0, max=255, message="violationdesc长度必须介于 0 和 255 之间")
	public String getViolationdesc() {
		return violationdesc;
	}

	public void setViolationdesc(String violationdesc) {
		this.violationdesc = violationdesc;
	}
	
	@Length(min=0, max=20, message="handleway长度必须介于 0 和 20 之间")
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
	
	@Length(min=0, max=20, message="studentattitude长度必须介于 0 和 20 之间")
	public String getStudentattitude() {
		return studentattitude;
	}

	public void setStudentattitude(String studentattitude) {
		this.studentattitude = studentattitude;
	}
	
	@Length(min=0, max=10, message="booker长度必须介于 0 和 10 之间")
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
	
	@Length(min=0, max=10, message="confirmer长度必须介于 0 和 10 之间")
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
	
	@Length(min=1, max=11, message="status长度必须介于 1 和 11 之间")
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
	
	@Length(min=0, max=255, message="other长度必须介于 0 和 255 之间")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	@Length(min=0, max=10, message="approve长度必须介于 0 和 10 之间")
	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}
	
	@Length(min=0, max=255, message="headship长度必须介于 0 和 255 之间")
	public String getHeadship() {
		return headship;
	}

	public void setHeadship(String headship) {
		this.headship = headship;
	}
	
	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
}