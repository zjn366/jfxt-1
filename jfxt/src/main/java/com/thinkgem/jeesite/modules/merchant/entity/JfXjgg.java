/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import java.util.Date;

/**
 * 巡检公告Entity
 * @author wangdandan
 * @version 2019-04-11
 */
public class JfXjgg extends DataEntity<JfXjgg>{
	
	private static final long serialVersionUID = 1L;
	private String ggbt;		// 公告标题
	private String ggnr;		// 公告内容
	private JfXx jfid;		// 网元
	private Date fbrq;		// 发布日期
	private User fbr;		// 发布人
	private String kzzd1;		// 扩展字段1
	private String kzzd2;		// 扩展字段2
	private String kzzd3;		// 扩展字段3
	private String kzzd4;		// 扩展字段4
	private String sffb;		// 是否发布

	private String limit;//app分页

	public String getLimit () {
		return limit;
	}

	public void setLimit (String limit) {
		this.limit = limit;
	}
	public JfXjgg() {
		super();
	}

	public JfXjgg(String id){
		super(id);
	}

	@Length(min=0, max=255, message="公告标题长度必须介于 0 和 255 之间")
	public String getGgbt() {
		return ggbt;
	}

	public void setGgbt(String ggbt) {
		this.ggbt = ggbt;
	}

	public String getGgnr() {
		return ggnr;
	}

	public void setGgnr(String ggnr) {
		this.ggnr = ggnr;
	}

	public JfXx getJfid() {
		return jfid;
	}

	public void setJfid(JfXx jfid) {
		this.jfid = jfid;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFbrq() {
		return fbrq;
	}

	public void setFbrq(Date fbrq) {
		this.fbrq = fbrq;
	}

	public User getFbr() {
		return fbr;
	}

	public void setFbr(User fbr) {
		this.fbr = fbr;
	}
	
	@Length(min=0, max=255, message="扩展字段1长度必须介于 0 和 255 之间")
	public String getKzzd1() {
		return kzzd1;
	}

	public void setKzzd1(String kzzd1) {
		this.kzzd1 = kzzd1;
	}
	
	@Length(min=0, max=255, message="扩展字段2长度必须介于 0 和 255 之间")
	public String getKzzd2() {
		return kzzd2;
	}

	public void setKzzd2(String kzzd2) {
		this.kzzd2 = kzzd2;
	}
	
	@Length(min=0, max=255, message="扩展字段3长度必须介于 0 和 255 之间")
	public String getKzzd3() {
		return kzzd3;
	}

	public void setKzzd3(String kzzd3) {
		this.kzzd3 = kzzd3;
	}
	
	@Length(min=0, max=255, message="扩展字段4长度必须介于 0 和 255 之间")
	public String getKzzd4() {
		return kzzd4;
	}

	public void setKzzd4(String kzzd4) {
		this.kzzd4 = kzzd4;
	}
	
	@Length(min=0, max=1, message="是否发布长度必须介于 0 和 1 之间")
	public String getSffb() {
		return sffb;
	}

	public void setSffb(String sffb) {
		this.sffb = sffb;
	}
	
}