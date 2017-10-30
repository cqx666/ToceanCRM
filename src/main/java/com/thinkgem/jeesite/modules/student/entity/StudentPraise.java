/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员表扬Entity
 * @author cqx
 * @version 2017-10-30
 */
public class StudentPraise extends DataEntity<StudentPraise> {
	
	private static final long serialVersionUID = 1L;
	private Date praisedate;		// praisedate
	private String praiseway;		// praiseway
	private String reason;		// reason
	private String score;		// score
	private Long studentId;		// student_id
	private String booker;		// booker
	private Date bookdate;		// bookdate
	private String confirmer;		// confirmer
	private Date confirmdate;		// confirmdate
	private String approve;		// approve
	private String status;		// status
	private String headship;		// headship
	private String opinion;		// opinion
	
	public StudentPraise() {
		super();
	}

	public StudentPraise(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPraisedate() {
		return praisedate;
	}

	public void setPraisedate(Date praisedate) {
		this.praisedate = praisedate;
	}
	
	@Length(min=0, max=20, message="praiseway长度必须介于 0 和 20 之间")
	public String getPraiseway() {
		return praiseway;
	}

	public void setPraiseway(String praiseway) {
		this.praiseway = praiseway;
	}
	
	@Length(min=0, max=255, message="reason长度必须介于 0 和 255 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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
	
	@Length(min=0, max=10, message="approve长度必须介于 0 和 10 之间")
	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}
	
	@Length(min=0, max=11, message="status长度必须介于 0 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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