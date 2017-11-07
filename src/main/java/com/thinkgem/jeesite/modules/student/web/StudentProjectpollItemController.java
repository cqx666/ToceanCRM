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
import com.thinkgem.jeesite.modules.student.entity.StudentProjectpollItem;
import com.thinkgem.jeesite.modules.student.service.StudentProjectpollItemService;

/**
 * 项目详情管理Controller
 * @author cqx
 * @version 2017-11-02
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentProjectpollItem")
public class StudentProjectpollItemController extends BaseController {

	@Autowired
	private StudentProjectpollItemService studentProjectpollItemService;
	
	@ModelAttribute
	public StudentProjectpollItem get(@RequestParam(required=false) String id) {
		StudentProjectpollItem entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentProjectpollItemService.get(id);
		}
		if (entity == null){
			entity = new StudentProjectpollItem();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentProjectpollItem:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentProjectpollItem studentProjectpollItem, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentProjectpollItem> page = studentProjectpollItemService.findPage(new Page<StudentProjectpollItem>(request, response), studentProjectpollItem); 
		model.addAttribute("page", page);
		return "modules/student/studentProjectpollItemList";
	}

	@RequiresPermissions("student:studentProjectpollItem:view")
	@RequestMapping(value = "form")
	public String form(StudentProjectpollItem studentProjectpollItem, Model model) {
		model.addAttribute("studentProjectpollItem", studentProjectpollItem);
		return "modules/student/studentProjectpollItemForm";
	}

	@RequiresPermissions("student:studentProjectpollItem:edit")
	@RequestMapping(value = "save")
	public String save(StudentProjectpollItem studentProjectpollItem, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentProjectpollItem)){
			return form(studentProjectpollItem, model);
		}
		studentProjectpollItemService.save(studentProjectpollItem);
		addMessage(redirectAttributes, "保存项目详情成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentProjectpollItem/?repage";
	}
	
	@RequiresPermissions("student:studentProjectpollItem:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentProjectpollItem studentProjectpollItem, RedirectAttributes redirectAttributes) {
		studentProjectpollItemService.delete(studentProjectpollItem);
		addMessage(redirectAttributes, "删除项目详情成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentProjectpollItem/?repage";
	}

}