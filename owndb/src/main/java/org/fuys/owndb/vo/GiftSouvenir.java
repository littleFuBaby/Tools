package org.fuys.owndb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GiftSouvenir extends Gift implements Serializable {

	private String origin;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return super.toString() + " GiftSouvenir [origin=" + origin + "]";
	}
}
