package org.fuys.owndb.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Groups implements Serializable {
	
	private Integer gid;
	private String name;
	private List<Role> roles;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Groups [gid=" + gid + ", name=" + name + ", roles=" + roles + "]";
	}

}
