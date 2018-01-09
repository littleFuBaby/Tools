package org.fuys.owndb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Capital implements Serializable {
	
	private String countryId;
	private String capitalId;
	private String name;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCapitalId() {
		return capitalId;
	}
	public void setCapitalId(String capitalId) {
		this.capitalId = capitalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Capital [countryId=" + countryId + ", capitalId=" + capitalId + ", name=" + name + "]";
	}

}
