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
import com.thinkgem.jeesite.modules.student.entity.StudentHomework;
import com.thinkgem.jeesite.modules.student.service.StudentHomeworkService;

/**
 * 学员作业布置Controller
 * @author cqx
 * @version 2017-11-03
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentHomework")
public class StudentHomeworkController extends BaseController {

	@Autowired
	private StudentHomeworkService studentHomeworkService;
	
	@ModelAttribute
	public StudentHomework get(@RequestParam(required=false) String id) {
		StudentHomework entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentHomeworkService.get(id);
		}
		if (entity == null){
			entity = new StudentHomework();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentHomework:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentHomework studentHomework, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentHomework> page = studentHomeworkService.findPage(new Page<StudentHomework>(request, response), studentHomework); 
		model.addAttribute("page", page);
		return "modules/student/studentHomeworkList";
	}

	@RequiresPermissions("student:studentHomework:view")
	@RequestMapping(value = "form")
	public String form(StudentHomework studentHomework, Model model) {
		model.addAttribute("studentHomework", studentHomework);
		return "modules/student/studentHomeworkForm";
	}

	@RequiresPermissions("student:studentHomework:edit")
	@RequestMapping(value = "save")
	public String save(StudentHomework studentHomework, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentHomework)){
			return form(studentHomework, model);
		}
		studentHomeworkService.save(studentHomework);
		addMessage(redirectAttributes, "保存作业成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentHomework/?repage";
	}
	
	@RequiresPermissions("student:studentHomework:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentHomework studentHomework, RedirectAttributes redirectAttributes) {
		studentHomeworkService.delete(studentHomework);
		addMessage(redirectAttributes, "删除作业成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentHomework/?repage";
	}

}