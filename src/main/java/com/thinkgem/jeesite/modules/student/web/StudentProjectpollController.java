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
import com.thinkgem.jeesite.modules.student.entity.StudentProjectpoll;
import com.thinkgem.jeesite.modules.student.service.StudentProjectpollService;

/**
 * 项目考核Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentProjectpoll")
public class StudentProjectpollController extends BaseController {

	@Autowired
	private StudentProjectpollService studentProjectpollService;
	
	@ModelAttribute
	public StudentProjectpoll get(@RequestParam(required=false) String id) {
		StudentProjectpoll entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentProjectpollService.get(id);
		}
		if (entity == null){
			entity = new StudentProjectpoll();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentProjectpoll:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentProjectpoll studentProjectpoll, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentProjectpoll> page = studentProjectpollService.findPage(new Page<StudentProjectpoll>(request, response), studentProjectpoll); 
		model.addAttribute("page", page);
		return "modules/student/studentProjectpollList";
	}

	@RequiresPermissions("student:studentProjectpoll:view")
	@RequestMapping(value = "form")
	public String form(StudentProjectpoll studentProjectpoll, Model model) {
		model.addAttribute("studentProjectpoll", studentProjectpoll);
		return "modules/student/studentProjectpollForm";
	}

	@RequiresPermissions("student:studentProjectpoll:edit")
	@RequestMapping(value = "save")
	public String save(StudentProjectpoll studentProjectpoll, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentProjectpoll)){
			return form(studentProjectpoll, model);
		}
		studentProjectpollService.save(studentProjectpoll);
		addMessage(redirectAttributes, "保存项目考核成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentProjectpoll/?repage";
	}
	
	@RequiresPermissions("student:studentProjectpoll:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentProjectpoll studentProjectpoll, RedirectAttributes redirectAttributes) {
		studentProjectpollService.delete(studentProjectpoll);
		addMessage(redirectAttributes, "删除项目考核成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentProjectpoll/?repage";
	}

}