/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.merchant.entity.JfXx;
import com.thinkgem.jeesite.modules.merchant.service.JfXxService;
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
import com.thinkgem.jeesite.modules.merchant.entity.JfZg;
import com.thinkgem.jeesite.modules.merchant.service.JfZgService;

import java.util.List;

/**
 * 整改Controller
 * @author wangdandan
 * @version 2019-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/merchant/jfZg")
public class JfZgController extends BaseController {

	@Autowired
	private JfZgService jfZgService;

	@Autowired
	private JfXxService jfXxService;

	@ModelAttribute
	public JfZg get(@RequestParam(required=false) String id) {
		JfZg entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jfZgService.get(id);
		}
		if (entity == null){
			entity = new JfZg();
		}
		return entity;
	}
	
	@RequiresPermissions("merchant:jfZg:view")
	@RequestMapping(value = {"list", ""})
	public String list(JfZg jfZg, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JfZg> page = jfZgService.findPage(new Page<JfZg>(request, response), jfZg); 
		model.addAttribute("page", page);

		List<JfXx> jfXxList=jfXxService.findList(new JfXx());
		model.addAttribute("jfXxList", jfXxList);
		return "modules/merchant/jfZgList";
	}

	@RequiresPermissions("merchant:jfZg:view")
	@RequestMapping(value = "form")
	public String form(JfZg jfZg, Model model) {
		model.addAttribute("jfZg", jfZg);

		List<JfXx> jfXxList=jfXxService.findList(new JfXx());
		model.addAttribute("jfXxList", jfXxList);
		return "modules/merchant/jfZgForm";
	}

	@RequiresPermissions("merchant:jfZg:edit")
	@RequestMapping(value = "save")
	public String save(JfZg jfZg, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jfZg)){
			return form(jfZg, model);
		}
		jfZgService.save(jfZg);
		addMessage(redirectAttributes, "保存整改成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfZg/?repage";
	}
	
	@RequiresPermissions("merchant:jfZg:edit")
	@RequestMapping(value = "delete")
	public String delete(JfZg jfZg, RedirectAttributes redirectAttributes) {
		jfZgService.delete(jfZg);
		addMessage(redirectAttributes, "删除整改成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfZg/?repage";
	}

}