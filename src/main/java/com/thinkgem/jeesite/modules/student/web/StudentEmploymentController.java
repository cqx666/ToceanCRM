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
import com.thinkgem.jeesite.modules.student.entity.StudentEmployment;
import com.thinkgem.jeesite.modules.student.service.StudentEmploymentService;

/**
 * 学员就业Controller
 * @author cqx
 * @version 2017-10-30
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentEmployment")
public class StudentEmploymentController extends BaseController {

	@Autowired
	private StudentEmploymentService studentEmploymentService;
	
	@ModelAttribute
	public StudentEmployment get(@RequestParam(required=false) String id) {
		StudentEmployment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentEmploymentService.get(id);
		}
		if (entity == null){
			entity = new StudentEmployment();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentEmployment:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentEmployment studentEmployment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentEmployment> page = studentEmploymentService.findPage(new Page<StudentEmployment>(request, response), studentEmployment); 
		model.addAttribute("page", page);
		return "modules/student/studentEmploymentList";
	}

	@RequiresPermissions("student:studentEmployment:view")
	@RequestMapping(value = "form")
	public String form(StudentEmployment studentEmployment, Model model) {
		model.addAttribute("studentEmployment", studentEmployment);
		return "modules/student/studentEmploymentForm";
	}

	@RequiresPermissions("student:studentEmployment:edit")
	@RequestMapping(value = "save")
	public String save(StudentEmployment studentEmployment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentEmployment)){
			return form(studentEmployment, model);
		}
		studentEmploymentService.save(studentEmployment);
		addMessage(redirectAttributes, "保存就业成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentEmployment/?repage";
	}
	
	@RequiresPermissions("student:studentEmployment:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentEmployment studentEmployment, RedirectAttributes redirectAttributes) {
		studentEmploymentService.delete(studentEmployment);
		addMessage(redirectAttributes, "删除就业成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentEmployment/?repage";
	}

}