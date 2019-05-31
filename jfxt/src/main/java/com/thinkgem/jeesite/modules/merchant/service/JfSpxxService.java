/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.merchant.entity.JfSpxx;
import com.thinkgem.jeesite.modules.merchant.dao.JfSpxxDao;

/**
 * 商品信息Service
 * @author wangdandan
 * @version 2019-04-11
 */
@Service
@Transactional(readOnly = true)
public class JfSpxxService extends CrudService<JfSpxxDao, JfSpxx> {

	public JfSpxx get(String id) {
		return super.get(id);
	}
	
	public List<JfSpxx> findList(JfSpxx jfSpxx) {
		return super.findList(jfSpxx);
	}
	
	public Page<JfSpxx> findPage(Page<JfSpxx> page, JfSpxx jfSpxx) {
		return super.findPage(page, jfSpxx);
	}
	
	@Transactional(readOnly = false)
	public void save(JfSpxx jfSpxx) {
		super.save(jfSpxx);
	}
	
	@Transactional(readOnly = false)
	public void delete(JfSpxx jfSpxx) {
		super.delete(jfSpxx);
	}
	
}