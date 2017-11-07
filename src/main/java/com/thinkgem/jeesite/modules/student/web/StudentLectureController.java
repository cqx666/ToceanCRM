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
import com.thinkgem.jeesite.modules.student.entity.StudentLecture;
import com.thinkgem.jeesite.modules.student.service.StudentLectureService;

/**
 * 学员演讲Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentLecture")
public class StudentLectureController extends BaseController {

	@Autowired
	private StudentLectureService studentLectureService;
	
	@ModelAttribute
	public StudentLecture get(@RequestParam(required=false) String id) {
		StudentLecture entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentLectureService.get(id);
		}
		if (entity == null){
			entity = new StudentLecture();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentLecture:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentLecture studentLecture, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentLecture> page = studentLectureService.findPage(new Page<StudentLecture>(request, response), studentLecture); 
		model.addAttribute("page", page);
		return "modules/student/studentLectureList";
	}

	@RequiresPermissions("student:studentLecture:view")
	@RequestMapping(value = "form")
	public String form(StudentLecture studentLecture, Model model) {
		model.addAttribute("studentLecture", studentLecture);
		return "modules/student/studentLectureForm";
	}

	@RequiresPermissions("student:studentLecture:edit")
	@RequestMapping(value = "save")
	public String save(StudentLecture studentLecture, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentLecture)){
			return form(studentLecture, model);
		}
		studentLectureService.save(studentLecture);
		addMessage(redirectAttributes, "保存演讲成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentLecture/?repage";
	}
	
	@RequiresPermissions("student:studentLecture:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentLecture studentLecture, RedirectAttributes redirectAttributes) {
		studentLectureService.delete(studentLecture);
		addMessage(redirectAttributes, "删除演讲成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentLecture/?repage";
	}
}