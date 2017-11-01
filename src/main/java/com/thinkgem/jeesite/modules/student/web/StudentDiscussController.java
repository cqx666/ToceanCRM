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
import com.thinkgem.jeesite.modules.student.entity.StudentDiscuss;
import com.thinkgem.jeesite.modules.student.service.StudentDiscussService;

/**
 * 分组讨论Controller
 * @author cqx
 * @version 2017-10-30
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentDiscuss")
public class StudentDiscussController extends BaseController {

	@Autowired
	private StudentDiscussService studentDiscussService;
	
	@ModelAttribute
	public StudentDiscuss get(@RequestParam(required=false) String id) {
		StudentDiscuss entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentDiscussService.get(id);
		}
		if (entity == null){
			entity = new StudentDiscuss();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentDiscuss:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentDiscuss studentDiscuss, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentDiscuss> page = studentDiscussService.findPage(new Page<StudentDiscuss>(request, response), studentDiscuss); 
		model.addAttribute("page", page);
		return "modules/student/studentDiscussList";
	}

	@RequiresPermissions("student:studentDiscuss:view")
	@RequestMapping(value = "form")
	public String form(StudentDiscuss studentDiscuss, Model model) {
		model.addAttribute("studentDiscuss", studentDiscuss);
		return "modules/student/studentDiscussForm";
	}

	@RequiresPermissions("student:studentDiscuss:edit")
	@RequestMapping(value = "save")
	public String save(StudentDiscuss studentDiscuss, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentDiscuss)){
			return form(studentDiscuss, model);
		}
		studentDiscussService.save(studentDiscuss);
		addMessage(redirectAttributes, "保存讨论成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentDiscuss/?repage";
	}
	
	@RequiresPermissions("student:studentDiscuss:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentDiscuss studentDiscuss, RedirectAttributes redirectAttributes) {
		studentDiscussService.delete(studentDiscuss);
		addMessage(redirectAttributes, "删除讨论成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentDiscuss/?repage";
	}

}