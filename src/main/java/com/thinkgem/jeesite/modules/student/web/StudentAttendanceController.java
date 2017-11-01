/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.student.entity.StudentAttendance;
import com.thinkgem.jeesite.modules.student.service.StudentAttendanceService;

/**
 * 学员考勤Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentAttendance")
public class StudentAttendanceController extends BaseController {

	@Autowired
	private StudentAttendanceService studentAttendanceService;
	
	@ModelAttribute
	public StudentAttendance get(@RequestParam(required=false) String id) {
		StudentAttendance entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentAttendanceService.get(id);
		}
		if (entity == null){
			entity = new StudentAttendance();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentAttendance:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentAttendance studentAttendance, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentAttendance> page = studentAttendanceService.findPage(new Page<StudentAttendance>(request, response), studentAttendance); 
		model.addAttribute("page", page);
		return "modules/student/studentAttendanceList";
	}

	@RequiresPermissions("student:studentAttendance:view")
	@RequestMapping(value = "form")
	public String form(StudentAttendance studentAttendance, Model model) {
		model.addAttribute("studentAttendance", studentAttendance);
		return "modules/student/studentAttendanceForm";
	}

	@RequiresPermissions("student:studentAttendance:edit")
	@RequestMapping(value = "save")
	public String save(StudentAttendance studentAttendance, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentAttendance)){
			return form(studentAttendance, model);
		}
		studentAttendanceService.save(studentAttendance);
		addMessage(redirectAttributes, "保存考勤成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentAttendance/?repage";
	}
	
	@RequiresPermissions("student:studentAttendance:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentAttendance studentAttendance, RedirectAttributes redirectAttributes) {
		studentAttendanceService.delete(studentAttendance);
		addMessage(redirectAttributes, "删除考勤成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentAttendance/?repage";
	}

}