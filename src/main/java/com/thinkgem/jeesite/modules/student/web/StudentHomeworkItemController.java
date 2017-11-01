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
import com.thinkgem.jeesite.modules.student.entity.StudentHomeworkItem;
import com.thinkgem.jeesite.modules.student.service.StudentHomeworkItemService;

/**
 * 学员作业布置Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentHomeworkItem")
public class StudentHomeworkItemController extends BaseController {

	@Autowired
	private StudentHomeworkItemService studentHomeworkItemService;
	
	@ModelAttribute
	public StudentHomeworkItem get(@RequestParam(required=false) String id) {
		StudentHomeworkItem entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentHomeworkItemService.get(id);
		}
		if (entity == null){
			entity = new StudentHomeworkItem();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentHomeworkItem:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentHomeworkItem studentHomeworkItem, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentHomeworkItem> page = studentHomeworkItemService.findPage(new Page<StudentHomeworkItem>(request, response), studentHomeworkItem); 
		model.addAttribute("page", page);
		return "modules/student/studentHomeworkItemList";
	}

	@RequiresPermissions("student:studentHomeworkItem:view")
	@RequestMapping(value = "form")
	public String form(StudentHomeworkItem studentHomeworkItem, Model model) {
		model.addAttribute("studentHomeworkItem", studentHomeworkItem);
		return "modules/student/studentHomeworkItemForm";
	}

	@RequiresPermissions("student:studentHomeworkItem:edit")
	@RequestMapping(value = "save")
	public String save(StudentHomeworkItem studentHomeworkItem, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentHomeworkItem)){
			return form(studentHomeworkItem, model);
		}
		studentHomeworkItemService.save(studentHomeworkItem);
		addMessage(redirectAttributes, "保存作业布置成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentHomeworkItem/?repage";
	}
	
	@RequiresPermissions("student:studentHomeworkItem:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentHomeworkItem studentHomeworkItem, RedirectAttributes redirectAttributes) {
		studentHomeworkItemService.delete(studentHomeworkItem);
		addMessage(redirectAttributes, "删除作业布置成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentHomeworkItem/?repage";
	}

}