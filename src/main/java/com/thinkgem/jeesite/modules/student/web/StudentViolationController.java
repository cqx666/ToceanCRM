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
import com.thinkgem.jeesite.modules.student.entity.StudentViolation;
import com.thinkgem.jeesite.modules.student.service.StudentViolationService;

/**
 * 学员违纪Controller
 * @author cqx
 * @version 2017-10-30
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentViolation")
public class StudentViolationController extends BaseController {

	@Autowired
	private StudentViolationService studentViolationService;
	
	@ModelAttribute
	public StudentViolation get(@RequestParam(required=false) String id) {
		StudentViolation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentViolationService.get(id);
		}
		if (entity == null){
			entity = new StudentViolation();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentViolation:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentViolation studentViolation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentViolation> page = studentViolationService.findPage(new Page<StudentViolation>(request, response), studentViolation); 
		model.addAttribute("page", page);
		return "modules/student/studentViolationList";
	}

	@RequiresPermissions("student:studentViolation:view")
	@RequestMapping(value = "form")
	public String form(StudentViolation studentViolation, Model model) {
		model.addAttribute("studentViolation", studentViolation);
		return "modules/student/studentViolationForm";
	}

	@RequiresPermissions("student:studentViolation:edit")
	@RequestMapping(value = "save")
	public String save(StudentViolation studentViolation, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentViolation)){
			return form(studentViolation, model);
		}
		studentViolationService.save(studentViolation);
		addMessage(redirectAttributes, "保存违纪成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentViolation/?repage";
	}
	
	@RequiresPermissions("student:studentViolation:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentViolation studentViolation, RedirectAttributes redirectAttributes) {
		studentViolationService.delete(studentViolation);
		addMessage(redirectAttributes, "删除违纪成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentViolation/?repage";
	}

}