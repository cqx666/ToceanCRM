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
import com.thinkgem.jeesite.modules.student.entity.StudentEmploymentLoca;
import com.thinkgem.jeesite.modules.student.service.StudentEmploymentLocaService;

/**
 * 学员就业地点Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentEmploymentLoca")
public class StudentEmploymentLocaController extends BaseController {

	@Autowired
	private StudentEmploymentLocaService studentEmploymentLocaService;
	
	@ModelAttribute
	public StudentEmploymentLoca get(@RequestParam(required=false) String id) {
		StudentEmploymentLoca entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentEmploymentLocaService.get(id);
		}
		if (entity == null){
			entity = new StudentEmploymentLoca();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentEmploymentLoca:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentEmploymentLoca studentEmploymentLoca, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentEmploymentLoca> page = studentEmploymentLocaService.findPage(new Page<StudentEmploymentLoca>(request, response), studentEmploymentLoca); 
		model.addAttribute("page", page);
		return "modules/student/studentEmploymentLocaList";
	}

	@RequiresPermissions("student:studentEmploymentLoca:view")
	@RequestMapping(value = "form")
	public String form(StudentEmploymentLoca studentEmploymentLoca, Model model) {
		model.addAttribute("studentEmploymentLoca", studentEmploymentLoca);
		return "modules/student/studentEmploymentLocaForm";
	}

	@RequiresPermissions("student:studentEmploymentLoca:edit")
	@RequestMapping(value = "save")
	public String save(StudentEmploymentLoca studentEmploymentLoca, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentEmploymentLoca)){
			return form(studentEmploymentLoca, model);
		}
		studentEmploymentLocaService.save(studentEmploymentLoca);
		addMessage(redirectAttributes, "保存就业地点成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentEmploymentLoca/?repage";
	}
	
	@RequiresPermissions("student:studentEmploymentLoca:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentEmploymentLoca studentEmploymentLoca, RedirectAttributes redirectAttributes) {
		studentEmploymentLocaService.delete(studentEmploymentLoca);
		addMessage(redirectAttributes, "删除就业地点成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentEmploymentLoca/?repage";
	}

}