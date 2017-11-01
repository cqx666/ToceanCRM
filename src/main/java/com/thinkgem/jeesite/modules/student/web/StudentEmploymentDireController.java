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
import com.thinkgem.jeesite.modules.student.entity.StudentEmploymentDire;
import com.thinkgem.jeesite.modules.student.service.StudentEmploymentDireService;

/**
 * 学员就业Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentEmploymentDire")
public class StudentEmploymentDireController extends BaseController {

	@Autowired
	private StudentEmploymentDireService studentEmploymentDireService;
	
	@ModelAttribute
	public StudentEmploymentDire get(@RequestParam(required=false) String id) {
		StudentEmploymentDire entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentEmploymentDireService.get(id);
		}
		if (entity == null){
			entity = new StudentEmploymentDire();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentEmploymentDire:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentEmploymentDire studentEmploymentDire, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentEmploymentDire> page = studentEmploymentDireService.findPage(new Page<StudentEmploymentDire>(request, response), studentEmploymentDire); 
		model.addAttribute("page", page);
		return "modules/student/studentEmploymentDireList";
	}

	@RequiresPermissions("student:studentEmploymentDire:view")
	@RequestMapping(value = "form")
	public String form(StudentEmploymentDire studentEmploymentDire, Model model) {
		model.addAttribute("studentEmploymentDire", studentEmploymentDire);
		return "modules/student/studentEmploymentDireForm";
	}

	@RequiresPermissions("student:studentEmploymentDire:edit")
	@RequestMapping(value = "save")
	public String save(StudentEmploymentDire studentEmploymentDire, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentEmploymentDire)){
			return form(studentEmploymentDire, model);
		}
		studentEmploymentDireService.save(studentEmploymentDire);
		addMessage(redirectAttributes, "保存就业成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentEmploymentDire/?repage";
	}
	
	@RequiresPermissions("student:studentEmploymentDire:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentEmploymentDire studentEmploymentDire, RedirectAttributes redirectAttributes) {
		studentEmploymentDireService.delete(studentEmploymentDire);
		addMessage(redirectAttributes, "删除就业成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentEmploymentDire/?repage";
	}

}