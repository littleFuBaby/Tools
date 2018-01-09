package org.fuys.owndb.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Country implements Serializable {
	
	private String countryId;
	private String name;
	private Capital capital;
	private List<Province> provinces;
	
	public List<Province> getProvinces() {
		return provinces;
	}
	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
	public Capital getCapital() {
		return capital;
	}
	public void setCapital(Capital capital) {
		this.capital = capital;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", name=" + name + ", capital=" + capital + ", provinces="
				+ provinces + "]";
	}

}
