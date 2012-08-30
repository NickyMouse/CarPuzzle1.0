package com.sandy.nicky.car.constants;

import java.util.HashMap;
import java.util.Map;

import com.sandy.nicky.car.R;

public enum CountryEnum {

	CN("�й�", "cn", R.drawable.cn), JP("�ձ�", "jp", R.drawable.jp), GE("�¹�",
			"ge", R.drawable.ge), US("����", "us", R.drawable.us), IT("�����",
			"it", R.drawable.it),FR("����","fr",R.drawable.fr);

	private String cnName;
	private String enName;
	private int imgId;

	private CountryEnum(String cnName, String enName, int imgId) {
		this.cnName = cnName;
		this.enName = enName;
		this.imgId = imgId;
	}

	private static Map<String, CountryEnum> map = new HashMap<String, CountryEnum>();
	private static Map<String, CountryEnum> mapCn = new HashMap<String, CountryEnum>();

	static {
		for (CountryEnum country : CountryEnum.values()) {
			map.put(country.getEnName(), country);
		}
		for (CountryEnum country : CountryEnum.values()) {
			mapCn.put(country.getCnName(), country);
		}
	}

	public String getCnName() {
		return this.cnName;
	}

	public String getEnName() {
		return this.enName;
	}

	public int getImgId() {
		return this.imgId;
	}

	public static CountryEnum getCountryEnum(String enName) {
		return map.get(enName);
	}

	public static CountryEnum getCountryEnumByCnName(String cnName) {
		return mapCn.get(cnName);
	}
}
