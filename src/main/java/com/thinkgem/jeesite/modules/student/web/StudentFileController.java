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
import com.thinkgem.jeesite.modules.student.entity.StudentFile;
import com.thinkgem.jeesite.modules.student.service.StudentFileService;

/**
 * 学员文件Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/studentFile")
public class StudentFileController extends BaseController {

	@Autowired
	private StudentFileService studentFileService;
	
	@ModelAttribute
	public StudentFile get(@RequestParam(required=false) String id) {
		StudentFile entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentFileService.get(id);
		}
		if (entity == null){
			entity = new StudentFile();
		}
		return entity;
	}
	
	@RequiresPermissions("student:studentFile:view")
	@RequestMapping(value = {"list", ""})
	public String list(StudentFile studentFile, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StudentFile> page = studentFileService.findPage(new Page<StudentFile>(request, response), studentFile); 
		model.addAttribute("page", page);
		return "modules/student/studentFileList";
	}

	@RequiresPermissions("student:studentFile:view")
	@RequestMapping(value = "form")
	public String form(StudentFile studentFile, Model model) {
		model.addAttribute("studentFile", studentFile);
		return "modules/student/studentFileForm";
	}

	@RequiresPermissions("student:studentFile:edit")
	@RequestMapping(value = "save")
	public String save(StudentFile studentFile, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, studentFile)){
			return form(studentFile, model);
		}
		studentFileService.save(studentFile);
		addMessage(redirectAttributes, "保存文件成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentFile/?repage";
	}
	
	@RequiresPermissions("student:studentFile:edit")
	@RequestMapping(value = "delete")
	public String delete(StudentFile studentFile, RedirectAttributes redirectAttributes) {
		studentFileService.delete(studentFile);
		addMessage(redirectAttributes, "删除文件成功");
		return "redirect:"+Global.getAdminPath()+"/student/studentFile/?repage";
	}

}