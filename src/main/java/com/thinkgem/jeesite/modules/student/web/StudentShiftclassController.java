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
import com.thinkgem.jeesite.modules.student.entity.StudentShiftclass;
import com.thinkgem.jeesite.modules.student.service.StudentShiftclassService;

/**

 * 学员转班Controller
 * @author cqx
 * @version 2017-11-01

 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentShiftclass")
public class StudentShiftclassController extends BaseController {

	@Autowired
	private StudentShiftclassService studentShiftclassService;
	
	@ModelAttribute
	public StudentShiftclass get(@RequestParam(required=false) String id) {
		StudentShiftclass entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentShiftclassService.get(id);
		}
		if (entity == null){
			entity = new StudentShiftclass();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentShiftclass:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentShiftclass studentShiftclass, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentShiftclass> page = studentShiftclassService.findPage(new Page<StudentShiftclass>(request, response), studentShiftclass); 
		model.addAttribute("page", page);
		return "modules/student/studentShiftclassList";
	}

	@RequiresPermissions("student:studentShiftclass:view")
	@RequestMapping(value = "form")
	public String form(StudentShiftclass studentShiftclass, Model model) {
		model.addAttribute("studentShiftclass", studentShiftclass);
		return "modules/student/studentShiftclassForm";
	}

	@RequiresPermissions("student:studentShiftclass:edit")
	@RequestMapping(value = "save")
	public String save(StudentShiftclass studentShiftclass, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentShiftclass)){
			return form(studentShiftclass, model);
		}
		studentShiftclassService.save(studentShiftclass);
		addMessage(redirectAttributes, "保存转班成功");

		return "redirect:"+Global.getAdminPath()+"/student/studentShiftclass/?repage";
	}
	
	@RequiresPermissions("student:studentShiftclass:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentShiftclass studentShiftclass, RedirectAttributes redirectAttributes) {
		studentShiftclassService.delete(studentShiftclass);

		addMessage(redirectAttributes, "删除转班成功");

		return "redirect:"+Global.getAdminPath()+"/student/studentShiftclass/?repage";
	}

}