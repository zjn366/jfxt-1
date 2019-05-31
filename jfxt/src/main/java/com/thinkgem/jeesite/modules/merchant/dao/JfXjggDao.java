/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.merchant.entity.JfXjgg;

import java.util.List;

/**
 * 巡检公告DAO接口
 * @author wangdandan
 * @version 2019-04-11
 */
@MyBatisDao
public interface JfXjggDao extends CrudDao<JfXjgg> {
    public List<JfXjgg> findListZx(JfXjgg jfXjgg) ;
}