/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.merchant.entity.JfXjgg;
import com.thinkgem.jeesite.modules.merchant.dao.JfXjggDao;

/**
 * 巡检公告Service
 * @author wangdandan
 * @version 2019-04-11
 */
@Service
@Transactional(readOnly = true)
public class JfXjggService extends CrudService<JfXjggDao, JfXjgg> {

	@Autowired
	private JfXjggDao jfXjggDao ;

	public JfXjgg get(String id) {
		return super.get(id);
	}
	
	public List<JfXjgg> findList(JfXjgg jfXjgg) {
		return super.findList(jfXjgg);
	}
	
	public Page<JfXjgg> findPage(Page<JfXjgg> page, JfXjgg jfXjgg) {
		return super.findPage(page, jfXjgg);
	}
	
	@Transactional(readOnly = false)
	public void save(JfXjgg jfXjgg) {
		super.save(jfXjgg);
	}
	
	@Transactional(readOnly = false)
	public void delete(JfXjgg jfXjgg) {
		super.delete(jfXjgg);
	}

	public List<JfXjgg> findListZx(JfXjgg jfXjgg) {
		return jfXjggDao.findListZx(jfXjgg);
	}


}