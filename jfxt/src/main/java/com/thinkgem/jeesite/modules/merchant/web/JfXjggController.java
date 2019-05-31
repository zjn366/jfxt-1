/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.app.util.AppResult;
import com.thinkgem.jeesite.modules.merchant.entity.JfXx;
import com.thinkgem.jeesite.modules.merchant.service.JfXxService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.merchant.entity.JfXjgg;
import com.thinkgem.jeesite.modules.merchant.service.JfXjggService;

import java.util.Date;
import java.util.List;

/**
 * 巡检公告Controller
 * @author wangdandan
 * @version 2019-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/merchant/jfXjgg")
public class JfXjggController extends BaseController {

	@Autowired
	private JfXjggService jfXjggService;
	@Autowired
	private JfXxService jfXxService;

	@ModelAttribute
	public JfXjgg get(@RequestParam(required=false) String id) {
		JfXjgg entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jfXjggService.get(id);
		}
		if (entity == null){
			entity = new JfXjgg();
		}
		return entity;
	}

	@RequiresPermissions("merchant:jfXjgg:view")
	@RequestMapping(value = {"list", ""})
	public String list(JfXjgg jfXjgg, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JfXjgg> page = jfXjggService.findPage(new Page<JfXjgg>(request, response), jfXjgg);

		List<JfXx> jfXxList=jfXxService.findList(new JfXx());
		model.addAttribute("jfXxList", jfXxList);

		model.addAttribute("page", page);
		return "modules/merchant/jfXjggList";
	}

	@RequiresPermissions("merchant:jfXjgg:view")
	@RequestMapping(value = "form")
	public String form(JfXjgg jfXjgg, Model model) {
		model.addAttribute("jfXjgg", jfXjgg);

		List<JfXx> jfXxList=jfXxService.findList(new JfXx());
		model.addAttribute("jfXxList", jfXxList);
		return "modules/merchant/jfXjggForm";
	}

	@RequiresPermissions("merchant:jfXjgg:edit")
	@RequestMapping(value = "save")
	public String save(JfXjgg jfXjgg, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jfXjgg)){
			return form(jfXjgg, model);
		}
		if("1".equals(jfXjgg.getSffb())){
			jfXjgg.setFbr(UserUtils.getUser());
			jfXjgg.setFbrq(new Date());
		}else{
			jfXjgg.setSffb("0");
		}
		jfXjggService.save(jfXjgg);
		addMessage(redirectAttributes, "保存巡检公告成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfXjgg/?repage";
	}
	
	@RequiresPermissions("merchant:jfXjgg:edit")
	@RequestMapping(value = "delete")
	public String delete(JfXjgg jfXjgg, RedirectAttributes redirectAttributes) {
		jfXjggService.delete(jfXjgg);
		addMessage(redirectAttributes, "删除巡检公告成功");
		return "redirect:"+Global.getAdminPath()+"/merchant/jfXjgg/?repage";
	}

}