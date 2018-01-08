package org.fuys.owndb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	
	private Integer uid;
	private String name;
	private int sex;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", sex=" + sex + "]";
	}

}
