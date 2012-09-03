package com.sandy.nicky.car.constants;

import java.util.HashMap;
import java.util.Map;

import com.sandy.nicky.car.R;

public enum CarEnum {
	// 德国
	VOLKSWAGEN("大众", "volkswagen", R.drawable.volkswagen,
			R.drawable.car_volkswagen), AUDI("奧迪", "audi", R.drawable.audi,
			R.drawable.car_audi), BENZ("奔驰", "benz", R.drawable.benz,
			R.drawable.car_benz), LORINSER("劳伦士", "lorinser",
			R.drawable.lorinser, R.drawable.car_lorinser), MAYBACH("迈巴赫",
			"maybach", R.drawable.maybach, R.drawable.car_maybach), OPEL("欧宝",
			"opel", R.drawable.opel, R.drawable.car_opel), PORSCHE("保时捷",
			"porsche", R.drawable.porsche, R.drawable.car_porsche), SMART(
			"斯玛特", "smart", R.drawable.smart, R.drawable.car_smart), BMW("宝马",
			"bmw", R.drawable.bmw, R.drawable.car_bmw),

	// 美国
	GMC("GMC", "gmc", R.drawable.gmc, R.drawable.car_gmc), JEEP("吉普", "jeep",
			R.drawable.jeep, R.drawable.car_jeep), ROSSION("ROSSION",
			"rossion", R.drawable.rossion, R.drawable.car_rossion), BUICK("别克",
			"buick", R.drawable.buick, R.drawable.car_buick), DODGE("道奇",
			"dodge", R.drawable.dodge, R.drawable.car_dodge), FORD("福特",
			"ford", R.drawable.ford, R.drawable.car_ford), HUMMER("悍马",
			"hummer", R.drawable.hummer, R.drawable.car_hummer), CADILLAC(
			"凯迪拉克", "cadillac", R.drawable.cadillac, R.drawable.car_cadillac), CORVETTE(
			"克尔维特", "corvette", R.drawable.corvette, R.drawable.car_corvette), CHRYSLER(
			"克莱斯勒", "chrysler", R.drawable.chrysler, R.drawable.car_chrysler), LINCON(
			"林肯", "lincon", R.drawable.lincon, R.drawable.car_lincon), PONTIAC(
			"庞迪克", "pontiac", R.drawable.pontiac, R.drawable.car_pontiac), SATURN(
			"土星", "saturn", R.drawable.saturn, R.drawable.car_saturn), CHEVROLET(
			"雪佛兰", "chevrolet", R.drawable.chevrolet, R.drawable.car_chevrolet),

	// 日本
	HONDA("本田", "honda", R.drawable.honda, R.drawable.car_honda), TOYOTA("丰田",
			"toyota", R.drawable.toyota, R.drawable.car_toyota), LEXUS("雷克萨斯",
			"lexus", R.drawable.lexus, R.drawable.car_lexus), SUZUKI("铃木",
			"suzuki", R.drawable.suzuki, R.drawable.car_suzuki), MAZDA("马自达",
			"mazda", R.drawable.mazda, R.drawable.car_mazda), NISSAN("尼桑",
			"nissan", R.drawable.nissan, R.drawable.car_nissan), ACURA("讴歌",
			"acura", R.drawable.acura, R.drawable.car_acura), MITSUBISHI("三菱",
			"mitsubishi", R.drawable.mitsubishi, R.drawable.car_mitsubishi), SUBARU(
			"斯巴鲁", "subaru", R.drawable.subaru, R.drawable.car_subaru), INFINITI(
			"英菲尼迪", "infiniti", R.drawable.infiniti, R.drawable.car_infiniti), MITSUOKA(
			"光冈", "mitsuoka", R.drawable.mitsuoka, R.drawable.car_mitsuoka),

	// 中国
	BYD("比亚迪", "byd", R.drawable.byd, R.drawable.car_byd), DIHAO("帝豪", "dihao",
			R.drawable.dihao, R.drawable.car_dihao), DONGFENG("东风", "dongfeng",
			R.drawable.dongfeng, R.drawable.car_dongfeng), FOTON("福田", "foton",
			R.drawable.foton, R.drawable.car_foton), HAIMA("海马", "haima",
			R.drawable.haima, R.drawable.car_haima), GEELY("吉利", "geely",
			R.drawable.geely, R.drawable.car_geely), JIANGHUAI("江淮",
			"jianghuai", R.drawable.jianghuai, R.drawable.car_jianghuai), RUIQI(
			"瑞麒", "ruiqi", R.drawable.ruiqi, R.drawable.car_ruiqi), JIEFANG(
			"解放", "jiefang", R.drawable.jiefang, R.drawable.car_jiefang), CHANGAN(
			"长安", "changan", R.drawable.changan, R.drawable.car_changan), GREATWALL(
			"长城", "greatwall", R.drawable.greatwall, R.drawable.car_greatwall), ZHONGHUA(
			"中华", "zhonghua", R.drawable.zhonghua, R.drawable.car_ruiqi),

	// 意大利
	ALFA_ROMEO("阿尔法罗密欧", "alfa_romeo", R.drawable.alfa_romeo,
			R.drawable.car_alfa_romeo), BUGATTI("布加迪", "bugatti",
			R.drawable.bugatti, R.drawable.car_bugatti), FERRARI("法拉利",
			"ferrari", R.drawable.ferrari, R.drawable.car_ferrari), FIAT("菲亚特",
			"fiat", R.drawable.fiat, R.drawable.car_fiat), LAMBORGHINI("兰博基尼",
			"lamborghini", R.drawable.lamborghini, R.drawable.car_lamborghini), MASERATI(
			"玛莎拉蒂", "maserati", R.drawable.maserati, R.drawable.car_maserati), PAGANI(
			"帕加尼", "pagani", R.drawable.pagani, R.drawable.car_pagani),

	// 法国
	VENTURI("文图瑞", "venturi", R.drawable.venturi, R.drawable.car_venturi), CITROEN(
			"雪铁龙", "citroen", R.drawable.citroen, R.drawable.car_citroen), PEUGEOT(
			"标志", "peugeot", R.drawable.peugeot, R.drawable.car_peugeot), RENAULT(
			"雷诺", "renault", R.drawable.renault, R.drawable.car_renault),

	// 英国
	ASTON_MARTIN("阿斯顿 马丁", "aston_martin", R.drawable.aston_martin,
			R.drawable.car_aston_martin), BENTLEY("宾利", "bentley",
			R.drawable.bentley, R.drawable.car_bentley), JAGUAR("捷豹",
			"jaguar", R.drawable.jaguar, R.drawable.car_jaguar), LAND_ROVER(
			"路虎", "land_rover", R.drawable.land_rover,
			R.drawable.car_land_rover), MCLAREN("迈凯轮", "mclaren",
			R.drawable.mclaren, R.drawable.car_mclaren), ROVER("罗孚", "rover",
			R.drawable.rover, R.drawable.car_rover), RR("莱斯莱斯", "rr",
			R.drawable.rr, R.drawable.car_rr);

	private static Map<String, CarEnum> map = new HashMap<String, CarEnum>();
	private static Map<String, CarEnum> cnMap = new HashMap<String, CarEnum>();
	private static Map<Integer, CarEnum> puzzleImgIdMap = new HashMap<Integer, CarEnum>();
	private String cnName;
	private String enName;
	private int imgId;
	private int puzzleImgId;

	static {
		for (CarEnum car : CarEnum.values()) {
			map.put(car.getEnName(), car);
		}
		for (CarEnum car : CarEnum.values()) {
			cnMap.put(car.getCnName(), car);
		}
		for (CarEnum car : CarEnum.values()) {
			puzzleImgIdMap.put(car.getPuzzleImgId(), car);
		}

	}

	private CarEnum(String cnName, String enName, int imgId, int puzzleImgId) {
		this.cnName = cnName;
		this.enName = enName;
		this.imgId = imgId;
		this.puzzleImgId = puzzleImgId;
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

	public int getPuzzleImgId() {
		return this.puzzleImgId;
	}

	public static CarEnum getCarEnum(String enName) {
		return map.get(enName);
	}

	public static CarEnum getCarEnumByCnName(String cnName) {
		return cnMap.get(cnName);
	}

	public static CarEnum getCarEnumByPuzzleImgId(Integer puzzleImgId) {
		return puzzleImgIdMap.get(puzzleImgId);
	}

}
