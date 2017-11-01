/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.thinkgem.jeesite.modules.sys.entity.User;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 数据字典Entity
 * @author cqx
 * @version 2017-11-01
 */
public class SysDict extends DataEntity<SysDict> {
	
	private static final long serialVersionUID = 1L;
	private String value;		// 数据值
	private String label;		// 标签名
	private String type;		// 类型
	private String description;		// 描述
	private String sort;		// 排序（升序）
	private SysDict parent;		// 父级编号
	private User create_by;		// 创建者
	private Date create_date;		// 创建时间
	private User update_by;		// 更新者
	private Date update_date;		// 更新时间
	
	public SysDict() {
		super();
	}

	public SysDict(String id){
		super(id);
	}

	@Length(min=1, max=100, message="数据值长度必须介于 1 和 100 之间")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Length(min=1, max=100, message="标签名长度必须介于 1 和 100 之间")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Length(min=1, max=100, message="类型长度必须介于 1 和 100 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=1, max=100, message="描述长度必须介于 1 和 100 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	@JsonBackReference
	public SysDict getParent() {
		return parent;
	}

	public void setParent(SysDict parent) {
		this.parent = parent;
	}
	
	@NotNull(message="创建者不能为空")
	public User getCreate_by() {
		return create_by;
	}

	public void setCreate_by(User create_by) {
		this.create_by = create_by;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="创建时间不能为空")
	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	@NotNull(message="更新者不能为空")
	public User getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(User update_by) {
		this.update_by = update_by;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="更新时间不能为空")
	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
}