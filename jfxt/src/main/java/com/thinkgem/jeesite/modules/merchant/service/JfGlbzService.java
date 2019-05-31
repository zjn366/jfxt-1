/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.merchant.entity.JfGlbz;
import com.thinkgem.jeesite.modules.merchant.dao.JfGlbzDao;

/**
 * 网元管理标准和要求Service
 * @author wangdandan
 * @version 2019-04-11
 */
@Service
@Transactional(readOnly = true)
public class JfGlbzService extends CrudService<JfGlbzDao, JfGlbz> {

	public JfGlbz get(String id) {
		return super.get(id);
	}
	
	public List<JfGlbz> findList(JfGlbz jfGlbz) {
		return super.findList(jfGlbz);
	}
	
	public Page<JfGlbz> findPage(Page<JfGlbz> page, JfGlbz jfGlbz) {
		return super.findPage(page, jfGlbz);
	}
	
	@Transactional(readOnly = false)
	public void save(JfGlbz jfGlbz) {
		super.save(jfGlbz);
	}
	
	@Transactional(readOnly = false)
	public void delete(JfGlbz jfGlbz) {
		super.delete(jfGlbz);
	}
	
}