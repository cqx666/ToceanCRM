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
 * @version 2017-11-02
 */
public class StudentPraise extends DataEntity<StudentPraise> {

    private static final long serialVersionUID = 1L;
    private Date praisedate;		// 表扬时间
    private String praiseway;		// 表扬方式
    private String reason;		// 表扬原因
    private String score;		// 表扬加分
    private String classes;		// 班级
    private String student;		// 学员
    private String booker;		// 登记人
    private Date bookdate;		// 登记时间
    private String confirmer;		// 证实者
    private Date confirmdate;		// 证实时间
    private String approve;		// 赞成
    private String status;		// 状态
    private String headship;		// 职务
    private String opinion;		// 意见

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

    @Length(min=0, max=20, message="表扬方式长度必须介于 0 和 20 之间")
    public String getPraiseway() {
        return praiseway;
    }

    public void setPraiseway(String praiseway) {
        this.praiseway = praiseway;
    }

    @Length(min=0, max=255, message="表扬原因长度必须介于 0 和 255 之间")
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

    @Length(min=0, max=64, message="班级长度必须介于 0 和 64 之间")
    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Length(min=0, max=64, message="学员长度必须介于 0 和 64 之间")
    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    @Length(min=0, max=10, message="登记人长度必须介于 0 和 10 之间")
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

    @Length(min=0, max=10, message="证实者长度必须介于 0 和 10 之间")
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

    @Length(min=0, max=10, message="赞成长度必须介于 0 和 10 之间")
    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }

    @Length(min=0, max=11, message="状态长度必须介于 0 和 11 之间")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Length(min=0, max=255, message="职务长度必须介于 0 和 255 之间")
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