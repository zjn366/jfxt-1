/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.web;

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
import com.thinkgem.jeesite.modules.merchant.entity.JfGlbz;
import com.thinkgem.jeesite.modules.merchant.service.JfGlbzService;

/**
 * 网元管理标准和要求Controller
 * @author wangdandan
 * @version 2019-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/merchant/jfGlbz")
public class JfGlbzController extends BaseController {

	@Autowired
	private JfGlbzService jfGlbzService;
	
	@ModelAttribute
	public JfGlbz get(@RequestParam(required=false) String id) {
		JfGlbz entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jfGlbzService.get(id);
		}
		if (entity == null){
			entity = new JfGlbz();
		}
		return entity;
	}
	
	@RequiresPermissions("merchant:jfGlbz:view")
	@RequestMapping(value = {"list", ""})
	public String list(JfGlbz jfGlbz, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JfGlbz> page = jfGlbzService.findPage(new Page<JfGlbz>(request, response), jfGlbz); 
		model.addAttribute("page", page);
		return "modules/merchant/jfGlbzList";
	}

	@RequiresPermissions("merchant:jfGlbz:view")
	@RequestMapping(value = "form")
	public String form(JfGlbz jfGlbz, Model model) {
		model.addAttribute("jfGlbz", jfGlbz);
		return "modules/merchant/jfGlbzForm";
	}

	@RequiresPermissions("merchant:jfGlbz:edit")
	@RequestMapping(value = "save")
	public String save(JfGlbz jfGlbz, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jfGlbz)){
			return form(jfGlbz, model);
		}
		jfGlbzService.save(jfGlbz);
		addMessage(redirectAttributes, "保存网元管理标准和要求成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfGlbz/?repage";
	}
	
	@RequiresPermissions("merchant:jfGlbz:edit")
	@RequestMapping(value = "delete")
	public String delete(JfGlbz jfGlbz, RedirectAttributes redirectAttributes) {
		jfGlbzService.delete(jfGlbz);
		addMessage(redirectAttributes, "删除网元管理标准和要求成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfGlbz/?repage";
	}

}