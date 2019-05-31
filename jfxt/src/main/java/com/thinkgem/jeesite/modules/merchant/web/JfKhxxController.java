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
import com.thinkgem.jeesite.modules.merchant.entity.JfKhxx;
import com.thinkgem.jeesite.modules.merchant.service.JfKhxxService;

/**
 * 客户信息Controller
 * @author wangdandan
 * @version 2019-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/merchant/jfKhxx")
public class JfKhxxController extends BaseController {

	@Autowired
	private JfKhxxService jfKhxxService;
	
	@ModelAttribute
	public JfKhxx get(@RequestParam(required=false) String id) {
		JfKhxx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jfKhxxService.get(id);
		}
		if (entity == null){
			entity = new JfKhxx();
		}
		return entity;
	}
	
	@RequiresPermissions("merchant:jfKhxx:view")
	@RequestMapping(value = {"list", ""})
	public String list(JfKhxx jfKhxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JfKhxx> page = jfKhxxService.findPage(new Page<JfKhxx>(request, response), jfKhxx); 
		model.addAttribute("page", page);
		return "modules/merchant/jfKhxxList";
	}

	@RequiresPermissions("merchant:jfKhxx:view")
	@RequestMapping(value = "form")
	public String form(JfKhxx jfKhxx, Model model) {
		model.addAttribute("jfKhxx", jfKhxx);
		return "modules/merchant/jfKhxxForm";
	}

	@RequiresPermissions("merchant:jfKhxx:edit")
	@RequestMapping(value = "save")
	public String save(JfKhxx jfKhxx, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jfKhxx)){
			return form(jfKhxx, model);
		}
		jfKhxxService.save(jfKhxx);
		addMessage(redirectAttributes, "保存客户信息成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfKhxx/?repage";
	}
	
	@RequiresPermissions("merchant:jfKhxx:edit")
	@RequestMapping(value = "delete")
	public String delete(JfKhxx jfKhxx, RedirectAttributes redirectAttributes) {
		jfKhxxService.delete(jfKhxx);
		addMessage(redirectAttributes, "删除客户信息成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfKhxx/?repage";
	}

}