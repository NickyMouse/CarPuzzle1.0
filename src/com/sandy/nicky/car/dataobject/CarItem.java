package com.sandy.nicky.car.dataobject;

import com.sandy.nicky.car.constants.CarEnum;

public class CarItem {

	private String carName;

	private int carImgId;

	public CarItem(CarEnum car) {
		this.carName = car.getCnName();
		this.carImgId = car.getImgId();
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarImgId() {
		return carImgId;
	}

	public void setCarImgId(int carImgId) {
		this.carImgId = carImgId;
	}

}
