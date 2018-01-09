package org.fuys.owndb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Province implements Serializable {

	private String provinceId;
	private String name;
	private Country country;
	
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", name=" + name + ", country=" + country + "]";
	}
	
}
