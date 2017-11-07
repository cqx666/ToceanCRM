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
import com.thinkgem.jeesite.modules.student.entity.Classes;
import com.thinkgem.jeesite.modules.student.service.ClassesService;

/**
 * 班级管理Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/classes")
public class ClassesController extends BaseController {

	@Autowired
	private ClassesService classesService;
	
	@ModelAttribute
	public Classes get(@RequestParam(required=false) String id) {
		Classes entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = classesService.get(id);
		}
		if (entity == null){
			entity = new Classes();
		}
		return entity;
	}
	
	@RequiresPermissions("student:classes:view")
	@RequestMapping(value = {"list", ""})
	public String list(Classes classes, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Classes> page = classesService.findPage(new Page<Classes>(request, response), classes); 
		model.addAttribute("page", page);
		return "modules/student/classesList";
	}

	@RequiresPermissions("student:classes:view")
	@RequestMapping(value = "form")
	public String form(Classes classes, Model model) {
		model.addAttribute("classes", classes);
		return "modules/student/classesForm";
	}

	@RequiresPermissions("student:classes:edit")
	@RequestMapping(value = "save")
	public String save(Classes classes, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, classes)){
			return form(classes, model);
		}
		classesService.save(classes);
		addMessage(redirectAttributes, "保存班级成功");
		return "redirect:"+Global.getAdminPath()+"/student/classes/?repage";
	}
	
	@RequiresPermissions("student:classes:edit")
	@RequestMapping(value = "delete")
	public String delete(Classes classes, RedirectAttributes redirectAttributes) {
		classesService.delete(classes);
		addMessage(redirectAttributes, "删除班级成功");
		return "redirect:"+Global.getAdminPath()+"/student/classes/?repage";
	}

}