package org.fuys.owndb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Gift implements Serializable {

	private Integer gid;
	private String name;
	private String description;
	private Double cost;
	private String flag;
	
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Gift [gid=" + gid + ", name=" + name + ", description=" + description + ", cost=" + cost + ", flag="
				+ flag + "]";
	}
}
