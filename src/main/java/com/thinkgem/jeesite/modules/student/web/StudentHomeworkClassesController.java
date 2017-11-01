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
import com.thinkgem.jeesite.modules.student.entity.StudentHomeworkClasses;
import com.thinkgem.jeesite.modules.student.service.StudentHomeworkClassesService;

/**
 * 学员作业类型Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentHomeworkClasses")
public class StudentHomeworkClassesController extends BaseController {

	@Autowired
	private StudentHomeworkClassesService studentHomeworkClassesService;
	
	@ModelAttribute
	public StudentHomeworkClasses get(@RequestParam(required=false) String id) {
		StudentHomeworkClasses entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentHomeworkClassesService.get(id);
		}
		if (entity == null){
			entity = new StudentHomeworkClasses();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentHomeworkClasses:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentHomeworkClasses studentHomeworkClasses, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentHomeworkClasses> page = studentHomeworkClassesService.findPage(new Page<StudentHomeworkClasses>(request, response), studentHomeworkClasses); 
		model.addAttribute("page", page);
		return "modules/student/studentHomeworkClassesList";
	}

	@RequiresPermissions("student:studentHomeworkClasses:view")
	@RequestMapping(value = "form")
	public String form(StudentHomeworkClasses studentHomeworkClasses, Model model) {
		model.addAttribute("studentHomeworkClasses", studentHomeworkClasses);
		return "modules/student/studentHomeworkClassesForm";
	}

	@RequiresPermissions("student:studentHomeworkClasses:edit")
	@RequestMapping(value = "save")
	public String save(StudentHomeworkClasses studentHomeworkClasses, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentHomeworkClasses)){
			return form(studentHomeworkClasses, model);
		}
		studentHomeworkClassesService.save(studentHomeworkClasses);
		addMessage(redirectAttributes, "保存作业类型成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentHomeworkClasses/?repage";
	}
	
	@RequiresPermissions("student:studentHomeworkClasses:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentHomeworkClasses studentHomeworkClasses, RedirectAttributes redirectAttributes) {
		studentHomeworkClassesService.delete(studentHomeworkClasses);
		addMessage(redirectAttributes, "删除作业类型成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentHomeworkClasses/?repage";
	}

}