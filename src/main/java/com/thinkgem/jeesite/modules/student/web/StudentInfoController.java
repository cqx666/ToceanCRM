/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.thinkgem.jeesite.modules.student.entity.Classes;
import com.thinkgem.jeesite.modules.student.entity.StudentFile;
import com.thinkgem.jeesite.modules.student.utils.POIUtil;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import org.apache.poi.util.SystemOutLogger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.student.entity.StudentInfo;
import com.thinkgem.jeesite.modules.student.service.StudentInfoService;


import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**

 * 学生信息Controller
 * @author cqx
 * @version 2017-11-01

 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentInfo")
public class StudentInfoController extends BaseController {

	@Autowired
	private StudentInfoService studentInfoService;


	@ModelAttribute
	public StudentInfo get(@RequestParam(required = false) String id) {
		StudentInfo entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = studentInfoService.get(id);
		}
		if (entity == null) {
			entity = new StudentInfo();
		}
		return entity;
	}

	@RequiresPermissions("student:studentInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentInfo studentInfo, HttpServletRequest request, HttpServletResponse response, Model model) {

		Page<StudentInfo> page = studentInfoService.findPage(new Page<StudentInfo>(request, response), studentInfo);
		model.addAttribute("page", page);

		return "modules/student/studentInfoList";
	}

	@RequiresPermissions("student:studentInfo:view")
	@RequestMapping(value = "form")
	public String form(StudentInfo studentInfo, Model model) {
		model.addAttribute("studentInfo", studentInfo);
		return "modules/student/studentInfoForm";
	}

	@RequiresPermissions("student:studentInfo:edit")
	@RequestMapping(value = "save")
	public String save(StudentInfo studentInfo, Model model, RedirectAttributes redirectAttributes
	) {
		if (!beanValidator(model, studentInfo)) {
			return form(studentInfo, model);
		}


		studentInfoService.save(studentInfo);

		addMessage(redirectAttributes, "保存学生成功");

		return "redirect:" + Global.getAdminPath() + "/student/studentInfo/?repage";
	}
	@RequiresPermissions("student:studentInfo:edit")
	@RequestMapping(value = "upload")
	public String upload( MultipartFile xyxximportfile) {//写上传的文件
		List<String[]> list= null;
		try {
			list = POIUtil.readExcel(xyxximportfile);
			System.out.print("*************++++"+list.size()+"++++++++++++++---------------------");
			System.out.print("*************++++"+list.get(1)[1]+"++++++++++++++---------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0;i<=list.size();i++){
			try {
				//得到导入的数据
				//list数据 是一行数据，按照模版解析
				String name = list.get(i)[0];//学生名字
				String password=list.get(i)[1];//密码
				String studentnumber = list.get(i)[2];//学号
				String statusChange = list.get(i)[3];//学业状态
				String studentType = list.get(i)[4];//学生类型
				String sex = list.get(i)[5];//性别
				String birthPlace = list.get(i)[6];//出生地点
				String birthDay = list.get(i)[7];//生日
				String married = list.get(i)[8];//婚姻状态
				String school = list.get(i)[9];//学校
				String academy = list.get(i)[10];//学院
				String department = list.get(i)[11];//系部
				String collegeMajor = list.get(i)[12];//主修课
				String schoolRecord = list.get(i)[13];//学历
				String graduateDate = list.get(i)[14];//
				String cancel = list.get(i)[15];//注销
				String telephone = list.get(i)[16];//入学时联系电话
				String gTelephone = list.get(i)[17];//毕业时联系电话
				String email = list.get(i)[18];//邮箱
				String qq = list.get(i)[19];//QQ
				String msn = list.get(i)[20];//MSN
				String homePhone = list.get(i)[21];//家庭电话
				String homeAddress = list.get(i)[22];//家庭地址
				String comminucationAddress = list.get(i)[23];//通讯地址
				String credentialNo = list.get(i)[24];//证件号码
				String guardian = list.get(i)[25];//监护人
				String guardianPhone = list.get(i)[26];//监护人电话
				String relation = list.get(i)[27];//与本人关系
				String urgencyPerson = list.get(i)[28];//紧急联系人
				String urgencyPhone = list.get(i)[29];//紧急联系电话
				String trainCompany = list.get(i)[30];//原参加培训的公司
				String trainTime = list.get(i)[31];//培训时间
				String trainContext = list.get(i)[32];//培训内容
				String oldCompany = list.get(i)[33];//原工作单位
				String oldHeadShip = list.get(i)[34];//原单位职位
				String oldSalary = list.get(i)[35];//原单位薪水
				String familyBackgroud = list.get(i)[36];//家庭背景
				String parentStatus = list.get(i)[37];//父母状况
				String jobDesign = list.get(i)[38];//职业规划
				String target = list.get(i)[39];//期望目标
				String hobby = list.get(i)[40];//爱好
				String economy = list.get(i)[41];//经济能力
				String qulityScore = list.get(i)[42];//职业素质基础分
				String skillScore = list.get(i)[43];//技术能力基础分
				String innerHeadShip = list.get(i)[44];//职位
				String daneiGraduateDate = list.get(i)[45];//达内毕业时间
				String pic = list.get(i)[46];//照片
				String picFileName = list.get(i)[47];//照片文件名
				String resume = list.get(i)[48];//简历
				String resumeFileName = list.get(i)[49];//简历文件名
				String repayedCredit = list.get(i)[50];//是否还清贷款
				String careerExclamation = list.get(i)[51];//就业感言
				String company = list.get(i)[52];//就业公司
				String headShip = list.get(i)[53];//就业职位
				String salary = list.get(i)[54];//就业薪水
				String returnVist = list.get(i)[55];//回访记录
				String remarks = list.get(i)[56];//备注
				String classes_id = list.get(i)[57];//班级外键
				String subArea_id = list.get(i)[58];//子范围
				String attendanceNo = list.get(i)[59];//考勤号
				String teacherEvaluation = list.get(i)[60];//班主任评价
				String pmEvaluation = list.get(i)[61];//项目经理评价
				String firstWritten = list.get(i)[62];//第一次考试成绩
				String secondWritten = list.get(i)[63];//第二次考试成绩
				String thirdWritten = list.get(i)[64];//第三次考试成绩
				String scjp = list.get(i)[65];//SCJP考试成绩
				String firstPoll = list.get(i)[66];//第一次项目考核成绩
				String secondPoll = list.get(i)[67];//第二次项目考核成绩
				String thirdPoll = list.get(i)[68];//第三次项目考核成绩
				String file_id = list.get(i)[69];//文件关联外键
				String office_id= list.get(i)[70];
				String area_id = list.get(i)[71];//归属区域

				StudentInfo stu=new StudentInfo();
				stu.setId(UUID.randomUUID().toString());
				stu.setPassword(password);
				stu.setName(name);
				stu.setStudentnumber(studentnumber);
				stu.setStatuschange(statusChange);
				stu.setStudenttype(studentType);
				stu.setSex(sex);
				stu.setBirthplace(birthPlace);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				Date date = sdf.parse(birthDay);
				stu.setBirthday(date);
				stu.setMarried(married);
				stu.setSchool(school);
				stu.setAcademy(academy);
				stu.setDepartment(department);
				stu.setCollegemajor(collegeMajor);
				stu.setSchoolrecord(schoolRecord);
				stu.setGraduatedate(graduateDate);
				stu.setCancel(cancel);
				stu.setTelephone(telephone);
				stu.setGtelephone(gTelephone);
				stu.setEmail(email);
				stu.setQq(qq);
				stu.setMsn(msn);
				stu.setHomephone(homePhone);
				stu.setHomeaddress(homeAddress);
				stu.setComminucationaddress(comminucationAddress);
				stu.setCredentialno(credentialNo);
				stu.setGuardian(guardian);
				stu.setGtelephone(guardianPhone);
				stu.setRelation(relation);
				stu.setUrgencyperson(urgencyPerson);
				stu.setUrgencyphone(urgencyPhone);
				stu.setTraincompany(trainCompany);
				stu.setTraintime(trainTime);
				stu.setTraincontext(trainContext);
				stu.setOldcompany(oldCompany);
				stu.setOldheadship(oldHeadShip);
				stu.setOldsalary(oldSalary);
				stu.setFamilybackgroud(familyBackgroud);
				stu.setParentstatus(parentStatus);
				stu.setJobdesign(jobDesign);
				stu.setTarget(target);
				stu.setHobby(hobby);
				stu.setEconomy(economy);
				stu.setQulityscore(qulityScore);
				stu.setEconomy(economy);
				stu.setQulityscore(qulityScore);
				stu.setSkillscore(skillScore);
				stu.setInnerheadship(innerHeadShip);
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd ");
				Date daneiGraduatedate = sdf1.parse(daneiGraduateDate);
				stu.setDaneigraduatedate(daneiGraduatedate);
				stu.setPic(pic);
				stu.setPicfilename(picFileName);
				stu.setResume(resume);
				stu.setResumefilename(resumeFileName);
				stu.setRepayedcredit(repayedCredit);
				stu.setCareerexclamation(careerExclamation);
				stu.setCompany(company);
				stu.setHeadship(headShip);
				stu.setSalary(salary);
				stu.setReturnvist(returnVist);
				stu.setRemarks(remarks);
				Classes c=new Classes();
				c.setId(classes_id);
				stu.setClasses(c);
				stu.setSubareaId(subArea_id);
				stu.setAttendanceno(attendanceNo);
				stu.setTeacherevaluation(teacherEvaluation);
				stu.setPmevaluation(pmEvaluation);
				stu.setFirstwritten(firstWritten);
				stu.setSecondwritten(secondWritten);
				stu.setTeacherevaluation(thirdWritten);
				stu.setScjp(scjp);
				stu.setFirstpoll(firstPoll);
				stu.setSecondpoll(secondPoll);
				stu.setThirdpoll(thirdPoll);
				StudentFile sf=new StudentFile();
				sf.setId(file_id);
				stu.setStudentfile(sf);
				Office o=new Office();
				o.setId(office_id);
				stu.setOffice(o);
				Area a=new Area();
				a.setId(area_id);
				stu.setArea(a);
				studentInfoService.save(stu);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return "redirect:" + Global.getAdminPath() + "/student/studentInfo/?repage";
	}


	@RequiresPermissions("student:studentInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentInfo studentInfo, RedirectAttributes redirectAttributes,String id) {
		StudentInfo si=new StudentInfo();
		String[] ids=id.split(",");
		for(int i=0;i<ids.length;i++){
			//System.out.print(ids[i]+"***--aaaaaaaaaaaaaaaaccccccccccccccc-++");
			si.setId(ids[i]);
			studentInfoService.delete(si);
		}


		addMessage(redirectAttributes, "删除学生成功");

		return "redirect:"+Global.getAdminPath()+"/student/studentInfo/?repage";
	}

}