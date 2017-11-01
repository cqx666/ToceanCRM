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
import com.thinkgem.jeesite.modules.student.entity.StudentPraise;
import com.thinkgem.jeesite.modules.student.service.StudentPraiseService;

/**
 * 学员表扬Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentPraise")
public class StudentPraiseController extends BaseController {

	@Autowired
	private StudentPraiseService studentPraiseService;
	
	@ModelAttribute
	public StudentPraise get(@RequestParam(required=false) String id) {
		StudentPraise entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentPraiseService.get(id);
		}
		if (entity == null){
			entity = new StudentPraise();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentPraise:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentPraise studentPraise, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentPraise> page = studentPraiseService.findPage(new Page<StudentPraise>(request, response), studentPraise); 
		model.addAttribute("page", page);
		return "modules/student/studentPraiseList";
	}

	@RequiresPermissions("student:studentPraise:view")
	@RequestMapping(value = "form")
	public String form(StudentPraise studentPraise, Model model) {
		model.addAttribute("studentPraise", studentPraise);
		return "modules/student/studentPraiseForm";
	}

	@RequiresPermissions("student:studentPraise:edit")
	@RequestMapping(value = "save")
	public String save(StudentPraise studentPraise, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentPraise)){
			return form(studentPraise, model);
		}
		studentPraiseService.save(studentPraise);
		addMessage(redirectAttributes, "保存表扬成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentPraise/?repage";
	}
	
	@RequiresPermissions("student:studentPraise:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentPraise studentPraise, RedirectAttributes redirectAttributes) {
		studentPraiseService.delete(studentPraise);
		addMessage(redirectAttributes, "删除表扬成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentPraise/?repage";
	}

}