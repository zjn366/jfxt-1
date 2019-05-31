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
import com.thinkgem.jeesite.modules.merchant.entity.JfSpxx;
import com.thinkgem.jeesite.modules.merchant.service.JfSpxxService;

/**
 * 商品信息Controller
 * @author wangdandan
 * @version 2019-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/merchant/jfSpxx")
public class JfSpxxController extends BaseController {

	@Autowired
	private JfSpxxService jfSpxxService;
	
	@ModelAttribute
	public JfSpxx get(@RequestParam(required=false) String id) {
		JfSpxx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jfSpxxService.get(id);
		}
		if (entity == null){
			entity = new JfSpxx();
		}
		return entity;
	}
	
	@RequiresPermissions("merchant:jfSpxx:view")
	@RequestMapping(value = {"list", ""})
	public String list(JfSpxx jfSpxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JfSpxx> page = jfSpxxService.findPage(new Page<JfSpxx>(request, response), jfSpxx); 
		model.addAttribute("page", page);
		return "modules/merchant/jfSpxxList";
	}

	@RequiresPermissions("merchant:jfSpxx:view")
	@RequestMapping(value = "form")
	public String form(JfSpxx jfSpxx, Model model) {
		model.addAttribute("jfSpxx", jfSpxx);
		return "modules/merchant/jfSpxxForm";
	}

	@RequiresPermissions("merchant:jfSpxx:edit")
	@RequestMapping(value = "save")
	public String save(JfSpxx jfSpxx, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jfSpxx)){
			return form(jfSpxx, model);
		}
		jfSpxxService.save(jfSpxx);
		addMessage(redirectAttributes, "保存商品信息成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfSpxx/?repage";
	}
	
	@RequiresPermissions("merchant:jfSpxx:edit")
	@RequestMapping(value = "delete")
	public String delete(JfSpxx jfSpxx, RedirectAttributes redirectAttributes) {
		jfSpxxService.delete(jfSpxx);
		addMessage(redirectAttributes, "删除商品信息成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfSpxx/?repage";
	}

}