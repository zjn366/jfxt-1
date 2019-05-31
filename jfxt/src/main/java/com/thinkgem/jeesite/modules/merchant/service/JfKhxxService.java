/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.merchant.entity.JfKhxx;
import com.thinkgem.jeesite.modules.merchant.dao.JfKhxxDao;

/**
 * 客户信息Service
 * @author wangdandan
 * @version 2019-04-11
 */
@Service
@Transactional(readOnly = true)
public class JfKhxxService extends CrudService<JfKhxxDao, JfKhxx> {

	public JfKhxx get(String id) {
		return super.get(id);
	}
	
	public List<JfKhxx> findList(JfKhxx jfKhxx) {
		return super.findList(jfKhxx);
	}
	
	public Page<JfKhxx> findPage(Page<JfKhxx> page, JfKhxx jfKhxx) {
		return super.findPage(page, jfKhxx);
	}
	
	@Transactional(readOnly = false)
	public void save(JfKhxx jfKhxx) {
		super.save(jfKhxx);
	}
	
	@Transactional(readOnly = false)
	public void delete(JfKhxx jfKhxx) {
		super.delete(jfKhxx);
	}
	
}