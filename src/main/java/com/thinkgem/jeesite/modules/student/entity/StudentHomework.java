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
 * 学员作业布置Entity
 * @author cqx
 * @version 2017-11-03
 */
public class StudentHomework extends DataEntity<StudentHomework> {

    private static final long serialVersionUID = 1L;
    private String title;		// 作业标题
    private Long classesId;		// 班级
    private Date makedate;		// 布置日期
    private String teacher;		// 老师
    private String courseId;		// 课程
    private String other;		// 说明
    private String status;		// 状态

    public StudentHomework() {
        super();
    }

    public StudentHomework(String id){
        super(id);
    }

    @Length(min=1, max=50, message="作业标题长度必须介于 1 和 50 之间")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull(message="班级不能为空")
    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message="布置日期不能为空")
    public Date getMakedate() {
        return makedate;
    }

    public void setMakedate(Date makedate) {
        this.makedate = makedate;
    }

    @Length(min=1, max=10, message="老师长度必须介于 1 和 10 之间")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Length(min=1, max=20, message="课程长度必须介于 1 和 20 之间")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Length(min=0, max=255, message="说明长度必须介于 0 和 255 之间")
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Length(min=1, max=11, message="状态长度必须介于 1 和 11 之间")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}