package com.thinkgem.jeesite.modules.student.service;

import com.thinkgem.jeesite.modules.student.entity.Classes;
import com.thinkgem.jeesite.modules.student.entity.StudentFile;
import com.thinkgem.jeesite.modules.student.entity.StudentInfo;
import com.thinkgem.jeesite.modules.student.utils.HxlsOptRowsInterface;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
@Transactional(readOnly = true)
public class XyxxImportServiceImpl implements HxlsOptRowsInterface{
    @Autowired
    private StudentInfoService studentInfoService;
    @Transactional(readOnly = false)
    @Override
    public String optRows(int sheetIndex, int curRow, List<String> rowlist) throws Exception {
        try {
            //得到导入的数据
            //rowlist数据 是一行数据，按照模版解析
            String name = rowlist.get(0);//学生名字
            String password=rowlist.get(1);//密码
            String studentnumber = rowlist.get(2);//学号
            String statusChange = rowlist.get(3);//学业状态
            String studentType = rowlist.get(4);//学生类型
            String sex = rowlist.get(5);//性别
            String birthPlace = rowlist.get(6);//出生地点
            String birthDay = rowlist.get(7);//生日
            String married = rowlist.get(8);//婚姻状态
            String school = rowlist.get(9);//学校
            String academy = rowlist.get(10);//学院
            String department = rowlist.get(11);//系部
            String collegeMajor = rowlist.get(12);//主修课
            String schoolRecord = rowlist.get(13);//学历
            String graduateDate = rowlist.get(14);//
            String cancel = rowlist.get(15);//注销
            String telephone = rowlist.get(16);//入学时联系电话
            String gTelephone = rowlist.get(17);//毕业时联系电话
            String email = rowlist.get(18);//邮箱
            String qq = rowlist.get(19);//QQ
            String msn = rowlist.get(20);//MSN
            String homePhone = rowlist.get(21);//家庭电话
            String homeAddress = rowlist.get(22);//家庭地址
            String comminucationAddress = rowlist.get(23);//通讯地址
            String credentialNo = rowlist.get(24);//证件号码
            String guardian = rowlist.get(25);//监护人
            String guardianPhone = rowlist.get(26);//监护人电话
            String relation = rowlist.get(27);//与本人关系
            String urgencyPerson = rowlist.get(28);//紧急联系人
            String urgencyPhone = rowlist.get(29);//紧急联系电话
            String trainCompany = rowlist.get(30);//原参加培训的公司
            String trainTime = rowlist.get(31);//培训时间
            String trainContext = rowlist.get(32);//培训内容
            String oldCompany = rowlist.get(33);//原工作单位
            String oldHeadShip = rowlist.get(34);//原单位职位
            String oldSalary = rowlist.get(35);//原单位薪水
            String familyBackgroud = rowlist.get(36);//家庭背景
            String parentStatus = rowlist.get(37);//父母状况
            String jobDesign = rowlist.get(38);//职业规划
            String target = rowlist.get(39);//期望目标
            String hobby = rowlist.get(40);//爱好
            String economy = rowlist.get(41);//经济能力
            String qulityScore = rowlist.get(42);//职业素质基础分
            String skillScore = rowlist.get(43);//技术能力基础分
            String innerHeadShip = rowlist.get(44);//职位
            String daneiGraduateDate = rowlist.get(45);//达内毕业时间
            String pic = rowlist.get(46);//照片
            String picFileName = rowlist.get(47);//照片文件名
            String resume = rowlist.get(48);//简历
            String resumeFileName = rowlist.get(49);//简历文件名
            String repayedCredit = rowlist.get(50);//是否还清贷款
            String careerExclamation = rowlist.get(51);//就业感言
            String company = rowlist.get(52);//就业公司
            String headShip = rowlist.get(53);//就业职位
            String salary = rowlist.get(54);//就业薪水
            String returnVist = rowlist.get(55);//回访记录
            String remarks = rowlist.get(56);//备注
            String classes_id = rowlist.get(57);//班级外键
            String subArea_id = rowlist.get(58);//子范围
            String attendanceNo = rowlist.get(59);//考勤号
            String teacherEvaluation = rowlist.get(60);//班主任评价
            String pmEvaluation = rowlist.get(61);//项目经理评价
            String firstWritten = rowlist.get(62);//第一次考试成绩
            String secondWritten = rowlist.get(63);//第二次考试成绩
            String thirdWritten = rowlist.get(64);//第三次考试成绩
            String scjp = rowlist.get(65);//SCJP考试成绩
            String firstPoll = rowlist.get(66);//第一次项目考核成绩
            String secondPoll = rowlist.get(67);//第二次项目考核成绩
            String thirdPoll = rowlist.get(68);//第三次项目考核成绩
            String file_id = rowlist.get(69);//文件关联外键
            String office_id= rowlist.get(70);
            String area_id = rowlist.get(71);//归属区域


            //进行校验
            //校验中标价格合法性
            //校验交易状态的合法性



            if(name!=null || name !=""){
                return "名字输入不能为空！";
            }else if(password!=null || password !=""){
                return "密码输入不能为空！";
            }else if(studentnumber!=null || studentnumber !=""){
                return "账号输入不能为空！";
            }
            //添加唯一校验

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

            //校验调用mapper
            studentInfoService.save(stu);
        } catch (Exception e) {
            e.printStackTrace();
            return "导入失败！";
        }


        return "success";
    }
}
