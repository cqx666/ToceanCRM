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
import com.thinkgem.jeesite.modules.student.entity.StudentIntroduce;
import com.thinkgem.jeesite.modules.student.service.StudentIntroduceService;

/**
 * 学员介绍Controller
 * @author cqx
 * @version 2017-11-01

 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentIntroduce")
public class StudentIntroduceController extends BaseController {

	@Autowired
	private StudentIntroduceService studentIntroduceService;
	
	@ModelAttribute
	public StudentIntroduce get(@RequestParam(required=false) String id) {
		StudentIntroduce entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentIntroduceService.get(id);
		}
		if (entity == null){
			entity = new StudentIntroduce();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentIntroduce:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentIntroduce studentIntroduce, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentIntroduce> page = studentIntroduceService.findPage(new Page<StudentIntroduce>(request, response), studentIntroduce); 
		model.addAttribute("page", page);
		return "modules/student/studentIntroduceList";
	}

	@RequiresPermissions("student:studentIntroduce:view")
	@RequestMapping(value = "form")
	public String form(StudentIntroduce studentIntroduce, Model model) {
		model.addAttribute("studentIntroduce", studentIntroduce);
		return "modules/student/studentIntroduceForm";
	}

	@RequiresPermissions("student:studentIntroduce:edit")
	@RequestMapping(value = "save")
	public String save(StudentIntroduce studentIntroduce, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentIntroduce)){
			return form(studentIntroduce, model);
		}
		studentIntroduceService.save(studentIntroduce);

		addMessage(redirectAttributes, "保存介绍成功");

		return "redirect:"+Global.getAdminPath()+"/student/studentIntroduce/?repage";
	}
	
	@RequiresPermissions("student:studentIntroduce:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentIntroduce studentIntroduce, RedirectAttributes redirectAttributes) {
		studentIntroduceService.delete(studentIntroduce);

		addMessage(redirectAttributes, "删除介绍成功");

		return "redirect:"+Global.getAdminPath()+"/student/studentIntroduce/?repage";
	}

}