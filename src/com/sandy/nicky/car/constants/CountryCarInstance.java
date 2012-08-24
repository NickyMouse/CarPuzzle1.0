package com.sandy.nicky.car.constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CountryCarInstance {

	private Map<CountryEnum, List<CarEnum>> countryCar = new HashMap<CountryEnum, List<CarEnum>>();

	public Map<CountryEnum, List<CarEnum>> getCountryCar() {
		return this.countryCar;
	}

	private static CountryCarInstance instance;

	private CountryCarInstance() {
		Properties properties = new Properties();
		try {
			properties.load(CountryCarInstance.class
					.getResourceAsStream("car.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<Object> set = properties.keySet();
		for (Object str : set.toArray()) {
			String carStr = (String) properties.get(str);
			String[] cars = carStr.split(",");
			CountryEnum country = CountryEnum.getCountryEnum(str.toString());
			List<CarEnum> carList = new ArrayList<CarEnum>();
			countryCar.put(country, carList);
			for (String car : cars) {
				carList.add(CarEnum.getCarEnum(car));
			}
		}
	}

	public static CountryCarInstance getInstance() {
		if (instance == null) {
			return new CountryCarInstance();
		}
		return instance;
	}
}
