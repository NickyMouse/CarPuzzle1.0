package com.sandy.nicky.car.dataobject;

import com.sandy.nicky.car.constants.CountryEnum;

public class CountryItem {

	private String countryName;

	private int flagImgId;

	public CountryItem(CountryEnum country) {
		this.countryName = country.getCnName();
		this.flagImgId = country.getImgId();
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getFlagImgId() {
		return flagImgId;
	}

	public void setFlagImgId(int flagImgId) {
		this.flagImgId = flagImgId;
	}

}
