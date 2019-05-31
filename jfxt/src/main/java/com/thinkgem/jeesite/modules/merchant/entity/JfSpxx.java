/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.merchant.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品信息Entity
 * @author wangdandan
 * @version 2019-04-11
 */
public class JfSpxx extends DataEntity<JfSpxx> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 产品名称
	private String cpbh;		// 产品编号
	private String cpxh;		// 产品型号
	private String cpzl;		// 重量
	private String cpgys;		// 供应商
	private String kzzd1;		// 扩展字段1
	private String kzzd2;		// 扩展字段2
	private String kzzd3;		// 扩展字段3
	private String kzzd4;		// 扩展字段4
	private String cpcbj;		// 成本价
	private String cpsjsx;		// 售价上限
	private String cpsjxx;		// 售价下限
	private String cpzk;		// 折扣
	private String cpkcl;		// 库存量
	private String cpyxq;		// 有效期
	private Date cpjggxsj;		// 价格更新时间
	private String cpsl;		// 数量

	private String limit;//app分页

	public String getLimit () {
		return limit;
	}

	public void setLimit (String limit) {
		this.limit = limit;
	}

	public JfSpxx() {
		super();
	}

	public JfSpxx(String id){
		super(id);
	}

	@Length(min=0, max=255, message="产品名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="产品编号长度必须介于 0 和 255 之间")
	public String getCpbh() {
		return cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}
	
	@Length(min=0, max=255, message="产品型号长度必须介于 0 和 255 之间")
	public String getCpxh() {
		return cpxh;
	}

	public void setCpxh(String cpxh) {
		this.cpxh = cpxh;
	}
	
	@Length(min=0, max=255, message="重量长度必须介于 0 和 255 之间")
	public String getCpzl() {
		return cpzl;
	}

	public void setCpzl(String cpzl) {
		this.cpzl = cpzl;
	}
	
	@Length(min=0, max=1000, message="供应商长度必须介于 0 和 1000 之间")
	public String getCpgys() {
		return cpgys;
	}

	public void setCpgys(String cpgys) {
		this.cpgys = cpgys;
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
	
	public String getCpcbj() {
		return cpcbj;
	}

	public void setCpcbj(String cpcbj) {
		this.cpcbj = cpcbj;
	}
	
	public String getCpsjsx() {
		return cpsjsx;
	}

	public void setCpsjsx(String cpsjsx) {
		this.cpsjsx = cpsjsx;
	}
	
	public String getCpsjxx() {
		return cpsjxx;
	}

	public void setCpsjxx(String cpsjxx) {
		this.cpsjxx = cpsjxx;
	}
	
	@Length(min=0, max=10, message="折扣长度必须介于 0 和 10 之间")
	public String getCpzk() {
		return cpzk;
	}

	public void setCpzk(String cpzk) {
		this.cpzk = cpzk;
	}
	
	public String getCpkcl() {
		return cpkcl;
	}

	public void setCpkcl(String cpkcl) {
		this.cpkcl = cpkcl;
	}
	
	@Length(min=0, max=10, message="有效期长度必须介于 0 和 10 之间")
	public String getCpyxq() {
		return cpyxq;
	}

	public void setCpyxq(String cpyxq) {
		this.cpyxq = cpyxq;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCpjggxsj() {
		return cpjggxsj;
	}

	public void setCpjggxsj(Date cpjggxsj) {
		this.cpjggxsj = cpjggxsj;
	}
	
	public String getCpsl() {
		return cpsl;
	}

	public void setCpsl(String cpsl) {
		this.cpsl = cpsl;
	}
	
}