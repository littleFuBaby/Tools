package org.fuys.owndb.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Role implements Serializable {
	
	private Integer rid;
	private String name;
	private List<Groups> groupses;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Groups> getGroupses() {
		return groupses;
	}
	public void setGroupses(List<Groups> groupses) {
		this.groupses = groupses;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", name=" + name + ", groupses=" + groupses + "]";
	}

}
