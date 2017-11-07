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
import com.thinkgem.jeesite.modules.student.entity.SysUser;
import com.thinkgem.jeesite.modules.student.service.SysUserService;

/**
 * 系统用户Controller
 * @author cqx
 * @version 2017-11-06
 */
@Controller
@RequestMapping(value = "${adminPath}/student/user")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService userService;
	
	@ModelAttribute
	public SysUser get(@RequestParam(required=false) String id) {
		SysUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = userService.get(id);
		}
		if (entity == null){
			entity = new SysUser();
		}
		return entity;
	}
	
	@RequiresPermissions("student:user:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysUser user, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysUser> page = userService.findPage(new Page<SysUser>(request, response), user);
		model.addAttribute("page", page);
		return "modules/student/userList";
	}

	@RequiresPermissions("student:user:view")
	@RequestMapping(value = "form")
	public String form(SysUser user, Model model) {
		model.addAttribute("user", user);
		return "modules/student/userForm";
	}

	@RequiresPermissions("student:user:edit")
	@RequestMapping(value = "save")
	public String save(SysUser user, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, user)){
			return form(user, model);
		}
		userService.save(user);
		addMessage(redirectAttributes, "保存系统用户成功");
		return "redirect:"+Global.getAdminPath()+"/student/user/?repage";
	}
	
	@RequiresPermissions("student:user:edit")
	@RequestMapping(value = "delete")
	public String delete(SysUser user, RedirectAttributes redirectAttributes) {
		userService.delete(user);
		addMessage(redirectAttributes, "删除系统用户成功");
		return "redirect:"+Global.getAdminPath()+"/student/user/?repage";
	}

}