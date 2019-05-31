/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 网元管理标准和要求Entity
 * @author wangdandan
 * @version 2019-04-11
 */
public class JfGlbz extends DataEntity<JfGlbz> {
	
	private static final long serialVersionUID = 1L;
	private String ddbh;		// 订单编号
	private String fkfs;		// 付款方式
	private String ysfs;		// 运输方式
	private String bjyxq;		// 报价有效期
	private String khid;		// 客户
	private String spid;		// 商品id
	private String shdz;		// 收货地址
	private String kd;		// 快递
	private String price;		// 价格
	private String kzzd1;		// 扩展字段1
	private String kzzd2;		// 扩展字段2
	private String kzzd3;		// 扩展字段3
	private String kzzd4;		// 扩展字段4
	private String kzzd5;		// 扩展字段5
	private String kzzd6;		// 扩展字段6

	private String limit;//app分页

	public String getLimit () {
		return limit;
	}

	public void setLimit (String limit) {
		this.limit = limit;
	}

	public JfGlbz() {
		super();
	}

	public JfGlbz(String id){
		super(id);
	}

	@Length(min=0, max=64, message="订单编号长度必须介于 0 和 64 之间")
	public String getDdbh() {
		return ddbh;
	}

	public void setDdbh(String ddbh) {
		this.ddbh = ddbh;
	}
	
	@Length(min=0, max=255, message="付款方式长度必须介于 0 和 255 之间")
	public String getFkfs() {
		return fkfs;
	}

	public void setFkfs(String fkfs) {
		this.fkfs = fkfs;
	}
	
	@Length(min=0, max=255, message="运输方式长度必须介于 0 和 255 之间")
	public String getYsfs() {
		return ysfs;
	}

	public void setYsfs(String ysfs) {
		this.ysfs = ysfs;
	}
	
	@Length(min=0, max=64, message="报价有效期长度必须介于 0 和 64 之间")
	public String getBjyxq() {
		return bjyxq;
	}

	public void setBjyxq(String bjyxq) {
		this.bjyxq = bjyxq;
	}
	
	@Length(min=0, max=64, message="客户长度必须介于 0 和 64 之间")
	public String getKhid() {
		return khid;
	}

	public void setKhid(String khid) {
		this.khid = khid;
	}
	
	@Length(min=0, max=64, message="商品id长度必须介于 0 和 64 之间")
	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getShdz() {
		return shdz;
	}

	public void setShdz(String shdz) {
		this.shdz = shdz;
	}
	
	@Length(min=0, max=255, message="快递长度必须介于 0 和 255 之间")
	public String getKd() {
		return kd;
	}

	public void setKd(String kd) {
		this.kd = kd;
	}
	
	@Length(min=0, max=255, message="价格长度必须介于 0 和 255 之间")
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
	
	@Length(min=0, max=255, message="扩展字段5长度必须介于 0 和 255 之间")
	public String getKzzd5() {
		return kzzd5;
	}

	public void setKzzd5(String kzzd5) {
		this.kzzd5 = kzzd5;
	}
	
	@Length(min=0, max=255, message="扩展字段6长度必须介于 0 和 255 之间")
	public String getKzzd6() {
		return kzzd6;
	}

	public void setKzzd6(String kzzd6) {
		this.kzzd6 = kzzd6;
	}
	
}