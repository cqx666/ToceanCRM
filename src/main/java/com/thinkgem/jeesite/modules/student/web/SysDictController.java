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
import com.thinkgem.jeesite.modules.student.entity.SysDict;
import com.thinkgem.jeesite.modules.student.service.SysDictService;

/**
 * 数据字典Controller
 * @author cqx
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/sysDict")
public class SysDictController extends BaseController {

	@Autowired
	private SysDictService sysDictService;
	
	@ModelAttribute
	public SysDict get(@RequestParam(required=false) String id) {
		SysDict entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysDictService.get(id);
		}
		if (entity == null){
			entity = new SysDict();
		}
		return entity;
	}
	
	@RequiresPermissions("student:sysDict:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysDict sysDict, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysDict> page = sysDictService.findPage(new Page<SysDict>(request, response), sysDict); 
		model.addAttribute("page", page);
		return "modules/student/sysDictList";
	}

	@RequiresPermissions("student:sysDict:view")
	@RequestMapping(value = "form")
	public String form(SysDict sysDict, Model model) {
		model.addAttribute("sysDict", sysDict);
		return "modules/student/sysDictForm";
	}

	@RequiresPermissions("student:sysDict:edit")
	@RequestMapping(value = "save")
	public String save(SysDict sysDict, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysDict)){
			return form(sysDict, model);
		}
		sysDictService.save(sysDict);
		addMessage(redirectAttributes, "保存字典成功");
		return "redirect:"+Global.getAdminPath()+"/student/sysDict/?repage";
	}
	
	@RequiresPermissions("student:sysDict:edit")
	@RequestMapping(value = "delete")
	public String delete(SysDict sysDict, RedirectAttributes redirectAttributes) {
		sysDictService.delete(sysDict);
		addMessage(redirectAttributes, "删除字典成功");
		return "redirect:"+Global.getAdminPath()+"/student/sysDict/?repage";
	}

}