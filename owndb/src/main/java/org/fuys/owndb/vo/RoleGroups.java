package org.fuys.owndb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoleGroups implements Serializable {
	
	private Integer rid;
	private Integer gid;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "RoleGroups [rid=" + rid + ", gid=" + gid + "]";
	}

}
