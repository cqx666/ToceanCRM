/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学员档案Entity
 * @author cqx
 * @version 2017-10-30
 */
public class StudentInfo extends DataEntity<StudentInfo> {
	
	private static final long serialVersionUID = 1L;
	private Long userid;		// userid
	private String code;		// code
	private String statuschange;		// statuschange
	private String studenttype;		// studenttype
	private String sex;		// sex
	private String birthplace;		// birthplace
	private Date birthday;		// birthday
	private String married;		// married
	private String school;		// school
	private String academy;		// academy
	private String department;		// department
	private String collegemajor;		// collegemajor
	private String schoolrecord;		// schoolrecord
	private String graduatedate;		// graduatedate
	private String cancel;		// cancel
	private String telephone;		// telephone
	private String gtelephone;		// gtelephone
	private String email;		// email
	private String qq;		// qq
	private String msn;		// msn
	private String homephone;		// homephone
	private String homeaddress;		// homeaddress
	private String comminucationaddress;		// comminucationaddress
	private String credentialno;		// credentialno
	private String guardian;		// guardian
	private String guardianphone;		// guardianphone
	private String relation;		// relation
	private String urgencyperson;		// urgencyperson
	private String urgencyphone;		// urgencyphone
	private String traincompany;		// traincompany
	private String traintime;		// traintime
	private String traincontext;		// traincontext
	private String oldcompany;		// oldcompany
	private String oldheadship;		// oldheadship
	private String oldsalary;		// oldsalary
	private String familybackgroud;		// familybackgroud
	private String parentstatus;		// parentstatus
	private String jobdesign;		// jobdesign
	private String target;		// target
	private String hobby;		// hobby
	private String economy;		// economy
	private String qulityscore;		// qulityscore
	private String skillscore;		// skillscore
	private String innerheadship;		// innerheadship
	private Date daneigraduatedate;		// daneigraduatedate
	private String pic;		// pic
	private String picfilename;		// picfilename
	private String resume;		// resume
	private String resumefilename;		// resumefilename
	private String repayedcredit;		// repayedcredit
	private String careerexclamation;		// careerexclamation
	private String company;		// company
	private String headship;		// headship
	private String salary;		// salary
	private String returnvist;		// returnvist
	private String other;		// other
	private Long classesId;		// classes_id
	private Long subareaId;		// subarea_id
	private String attendanceno;		// attendanceno
	private String teacherevaluation;		// teacherevaluation
	private String pmevaluation;		// pmevaluation
	private String firstwritten;		// firstwritten
	private String secondwritten;		// secondwritten
	private String thirdwritten;		// thirdwritten
	private String scjp;		// scjp
	private String firstpoll;		// firstpoll
	private String secondpoll;		// secondpoll
	private String thirdpoll;		// thirdpoll
	private Long fileId;		// file_id
	
	public StudentInfo() {
		super();
	}

	public StudentInfo(String id){
		super(id);
	}

	@NotNull(message="userid不能为空")
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=20, message="code长度必须介于 0 和 20 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=500, message="statuschange长度必须介于 0 和 500 之间")
	public String getStatuschange() {
		return statuschange;
	}

	public void setStatuschange(String statuschange) {
		this.statuschange = statuschange;
	}
	
	@Length(min=0, max=20, message="studenttype长度必须介于 0 和 20 之间")
	public String getStudenttype() {
		return studenttype;
	}

	public void setStudenttype(String studenttype) {
		this.studenttype = studenttype;
	}
	
	@Length(min=0, max=10, message="sex长度必须介于 0 和 10 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=100, message="birthplace长度必须介于 0 和 100 之间")
	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=10, message="married长度必须介于 0 和 10 之间")
	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}
	
	@Length(min=0, max=50, message="school长度必须介于 0 和 50 之间")
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	@Length(min=0, max=20, message="academy长度必须介于 0 和 20 之间")
	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}
	
	@Length(min=0, max=20, message="department长度必须介于 0 和 20 之间")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Length(min=0, max=20, message="collegemajor长度必须介于 0 和 20 之间")
	public String getCollegemajor() {
		return collegemajor;
	}

	public void setCollegemajor(String collegemajor) {
		this.collegemajor = collegemajor;
	}
	
	@Length(min=0, max=10, message="schoolrecord长度必须介于 0 和 10 之间")
	public String getSchoolrecord() {
		return schoolrecord;
	}

	public void setSchoolrecord(String schoolrecord) {
		this.schoolrecord = schoolrecord;
	}
	
	@Length(min=0, max=10, message="graduatedate长度必须介于 0 和 10 之间")
	public String getGraduatedate() {
		return graduatedate;
	}

	public void setGraduatedate(String graduatedate) {
		this.graduatedate = graduatedate;
	}
	
	@Length(min=1, max=1, message="cancel长度必须介于 1 和 1 之间")
	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	
	@Length(min=0, max=50, message="telephone长度必须介于 0 和 50 之间")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Length(min=0, max=50, message="gtelephone长度必须介于 0 和 50 之间")
	public String getGtelephone() {
		return gtelephone;
	}

	public void setGtelephone(String gtelephone) {
		this.gtelephone = gtelephone;
	}
	
	@Length(min=0, max=50, message="email长度必须介于 0 和 50 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=50, message="qq长度必须介于 0 和 50 之间")
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Length(min=0, max=50, message="msn长度必须介于 0 和 50 之间")
	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}
	
	@Length(min=0, max=50, message="homephone长度必须介于 0 和 50 之间")
	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	
	@Length(min=0, max=50, message="homeaddress长度必须介于 0 和 50 之间")
	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
	
	@Length(min=0, max=100, message="comminucationaddress长度必须介于 0 和 100 之间")
	public String getComminucationaddress() {
		return comminucationaddress;
	}

	public void setComminucationaddress(String comminucationaddress) {
		this.comminucationaddress = comminucationaddress;
	}
	
	@Length(min=0, max=50, message="credentialno长度必须介于 0 和 50 之间")
	public String getCredentialno() {
		return credentialno;
	}

	public void setCredentialno(String credentialno) {
		this.credentialno = credentialno;
	}
	
	@Length(min=0, max=10, message="guardian长度必须介于 0 和 10 之间")
	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}
	
	@Length(min=0, max=50, message="guardianphone长度必须介于 0 和 50 之间")
	public String getGuardianphone() {
		return guardianphone;
	}

	public void setGuardianphone(String guardianphone) {
		this.guardianphone = guardianphone;
	}
	
	@Length(min=0, max=10, message="relation长度必须介于 0 和 10 之间")
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	@Length(min=0, max=20, message="urgencyperson长度必须介于 0 和 20 之间")
	public String getUrgencyperson() {
		return urgencyperson;
	}

	public void setUrgencyperson(String urgencyperson) {
		this.urgencyperson = urgencyperson;
	}
	
	@Length(min=0, max=20, message="urgencyphone长度必须介于 0 和 20 之间")
	public String getUrgencyphone() {
		return urgencyphone;
	}

	public void setUrgencyphone(String urgencyphone) {
		this.urgencyphone = urgencyphone;
	}
	
	@Length(min=0, max=50, message="traincompany长度必须介于 0 和 50 之间")
	public String getTraincompany() {
		return traincompany;
	}

	public void setTraincompany(String traincompany) {
		this.traincompany = traincompany;
	}
	
	@Length(min=0, max=255, message="traintime长度必须介于 0 和 255 之间")
	public String getTraintime() {
		return traintime;
	}

	public void setTraintime(String traintime) {
		this.traintime = traintime;
	}
	
	@Length(min=0, max=50, message="traincontext长度必须介于 0 和 50 之间")
	public String getTraincontext() {
		return traincontext;
	}

	public void setTraincontext(String traincontext) {
		this.traincontext = traincontext;
	}
	
	@Length(min=0, max=50, message="oldcompany长度必须介于 0 和 50 之间")
	public String getOldcompany() {
		return oldcompany;
	}

	public void setOldcompany(String oldcompany) {
		this.oldcompany = oldcompany;
	}
	
	@Length(min=0, max=20, message="oldheadship长度必须介于 0 和 20 之间")
	public String getOldheadship() {
		return oldheadship;
	}

	public void setOldheadship(String oldheadship) {
		this.oldheadship = oldheadship;
	}
	
	@Length(min=0, max=11, message="oldsalary长度必须介于 0 和 11 之间")
	public String getOldsalary() {
		return oldsalary;
	}

	public void setOldsalary(String oldsalary) {
		this.oldsalary = oldsalary;
	}
	
	@Length(min=0, max=255, message="familybackgroud长度必须介于 0 和 255 之间")
	public String getFamilybackgroud() {
		return familybackgroud;
	}

	public void setFamilybackgroud(String familybackgroud) {
		this.familybackgroud = familybackgroud;
	}
	
	@Length(min=0, max=255, message="parentstatus长度必须介于 0 和 255 之间")
	public String getParentstatus() {
		return parentstatus;
	}

	public void setParentstatus(String parentstatus) {
		this.parentstatus = parentstatus;
	}
	
	@Length(min=0, max=255, message="jobdesign长度必须介于 0 和 255 之间")
	public String getJobdesign() {
		return jobdesign;
	}

	public void setJobdesign(String jobdesign) {
		this.jobdesign = jobdesign;
	}
	
	@Length(min=0, max=255, message="target长度必须介于 0 和 255 之间")
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
	@Length(min=0, max=255, message="hobby长度必须介于 0 和 255 之间")
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	@Length(min=0, max=50, message="economy长度必须介于 0 和 50 之间")
	public String getEconomy() {
		return economy;
	}

	public void setEconomy(String economy) {
		this.economy = economy;
	}
	
	public String getQulityscore() {
		return qulityscore;
	}

	public void setQulityscore(String qulityscore) {
		this.qulityscore = qulityscore;
	}
	
	public String getSkillscore() {
		return skillscore;
	}

	public void setSkillscore(String skillscore) {
		this.skillscore = skillscore;
	}
	
	@Length(min=0, max=20, message="innerheadship长度必须介于 0 和 20 之间")
	public String getInnerheadship() {
		return innerheadship;
	}

	public void setInnerheadship(String innerheadship) {
		this.innerheadship = innerheadship;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDaneigraduatedate() {
		return daneigraduatedate;
	}

	public void setDaneigraduatedate(Date daneigraduatedate) {
		this.daneigraduatedate = daneigraduatedate;
	}
	
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Length(min=0, max=255, message="picfilename长度必须介于 0 和 255 之间")
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
	
	@Length(min=0, max=255, message="resumefilename长度必须介于 0 和 255 之间")
	public String getResumefilename() {
		return resumefilename;
	}

	public void setResumefilename(String resumefilename) {
		this.resumefilename = resumefilename;
	}
	
	@Length(min=1, max=1, message="repayedcredit长度必须介于 1 和 1 之间")
	public String getRepayedcredit() {
		return repayedcredit;
	}

	public void setRepayedcredit(String repayedcredit) {
		this.repayedcredit = repayedcredit;
	}
	
	public String getCareerexclamation() {
		return careerexclamation;
	}

	public void setCareerexclamation(String careerexclamation) {
		this.careerexclamation = careerexclamation;
	}
	
	@Length(min=0, max=20, message="company长度必须介于 0 和 20 之间")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Length(min=0, max=20, message="headship长度必须介于 0 和 20 之间")
	public String getHeadship() {
		return headship;
	}

	public void setHeadship(String headship) {
		this.headship = headship;
	}
	
	@Length(min=0, max=11, message="salary长度必须介于 0 和 11 之间")
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getReturnvist() {
		return returnvist;
	}

	public void setReturnvist(String returnvist) {
		this.returnvist = returnvist;
	}
	
	@Length(min=0, max=255, message="other长度必须介于 0 和 255 之间")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	public Long getClassesId() {
		return classesId;
	}

	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	
	public Long getSubareaId() {
		return subareaId;
	}

	public void setSubareaId(Long subareaId) {
		this.subareaId = subareaId;
	}
	
	@Length(min=0, max=10, message="attendanceno长度必须介于 0 和 10 之间")
	public String getAttendanceno() {
		return attendanceno;
	}

	public void setAttendanceno(String attendanceno) {
		this.attendanceno = attendanceno;
	}
	
	public String getTeacherevaluation() {
		return teacherevaluation;
	}

	public void setTeacherevaluation(String teacherevaluation) {
		this.teacherevaluation = teacherevaluation;
	}
	
	public String getPmevaluation() {
		return pmevaluation;
	}

	public void setPmevaluation(String pmevaluation) {
		this.pmevaluation = pmevaluation;
	}
	
	public String getFirstwritten() {
		return firstwritten;
	}

	public void setFirstwritten(String firstwritten) {
		this.firstwritten = firstwritten;
	}
	
	public String getSecondwritten() {
		return secondwritten;
	}

	public void setSecondwritten(String secondwritten) {
		this.secondwritten = secondwritten;
	}
	
	public String getThirdwritten() {
		return thirdwritten;
	}

	public void setThirdwritten(String thirdwritten) {
		this.thirdwritten = thirdwritten;
	}
	
	public String getScjp() {
		return scjp;
	}

	public void setScjp(String scjp) {
		this.scjp = scjp;
	}
	
	public String getFirstpoll() {
		return firstpoll;
	}

	public void setFirstpoll(String firstpoll) {
		this.firstpoll = firstpoll;
	}
	
	public String getSecondpoll() {
		return secondpoll;
	}

	public void setSecondpoll(String secondpoll) {
		this.secondpoll = secondpoll;
	}
	
	public String getThirdpoll() {
		return thirdpoll;
	}

	public void setThirdpoll(String thirdpoll) {
		this.thirdpoll = thirdpoll;
	}
	
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	
}