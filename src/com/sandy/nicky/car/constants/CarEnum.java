package com.sandy.nicky.car.constants;

import java.util.HashMap;
import java.util.Map;

import com.sandy.nicky.car.R;

public enum CarEnum {
	// �¹�
	VOLKSWAGEN("����", "volkswagen", R.drawable.volkswagen,
			R.drawable.car_volkswagen), AUDI("�W��", "audi", R.drawable.audi,
			R.drawable.car_audi), BENZ("����", "benz", R.drawable.benz,
			R.drawable.car_benz), LORINSER("����ʿ", "lorinser",
			R.drawable.lorinser, R.drawable.car_lorinser), MAYBACH("���ͺ�",
			"maybach", R.drawable.maybach, R.drawable.car_maybach), OPEL("ŷ��",
			"opel", R.drawable.opel, R.drawable.car_opel), PORSCHE("��ʱ��",
			"porsche", R.drawable.porsche, R.drawable.car_porsche), RR("��˹��˹",
			"rr", R.drawable.rr, R.drawable.car_rr), SMART("˹����", "smart",
			R.drawable.smart, R.drawable.car_smart), BMW("����", "bmw",
			R.drawable.bmw, R.drawable.car_bmw),

	// ����
	GMC("GMC", "gmc", R.drawable.gmc, R.drawable.car_gmc), JEEP("����", "jeep",
			R.drawable.jeep, R.drawable.car_jeep), ROSSION("ROSSION",
			"rossion", R.drawable.rossion, R.drawable.car_rossion), BUICK("���",
			"buick", R.drawable.buick, R.drawable.car_buick), DODGE("����",
			"dodge", R.drawable.dodge, R.drawable.car_dodge), FORD("����",
			"ford", R.drawable.ford, R.drawable.car_ford), HUMMER("����",
			"hummer", R.drawable.hummer, R.drawable.car_hummer), CADILLAC(
			"��������", "cadillac", R.drawable.cadillac, R.drawable.car_cadillac), CORVETTE(
			"�˶�ά��", "corvette", R.drawable.corvette, R.drawable.car_corvette), CHRYSLER(
			"����˹��", "chrysler", R.drawable.chrysler, R.drawable.car_chrysler), LINCON(
			"�ֿ�", "lincon", R.drawable.lincon, R.drawable.car_lincon), PONTIAC(
			"�ӵϿ�", "pontiac", R.drawable.pontiac, R.drawable.car_pontiac), SATURN(
			"����", "saturn", R.drawable.saturn, R.drawable.car_saturn), CHEVROLET(
			"ѩ����", "chevrolet", R.drawable.chevrolet, R.drawable.car_chevrolet),

	// �ձ�
	HONDA("����", "honda", R.drawable.honda, R.drawable.car_honda), TOYOTA("����",
			"toyota", R.drawable.toyota, R.drawable.car_toyota), LEXUS("�׿���˹",
			"lexus", R.drawable.lexus, R.drawable.car_lexus), SUZUKI("��ľ",
			"suzuki", R.drawable.suzuki, R.drawable.car_suzuki), MAZDA("���Դ�",
			"mazda", R.drawable.mazda, R.drawable.car_mazda), NISSAN("��ɣ",
			"nissan", R.drawable.nissan, R.drawable.car_nissan), ACURA("ک��",
			"acura", R.drawable.acura, R.drawable.car_acura), MITSUBISHI("����",
			"mitsubishi", R.drawable.mitsubishi, R.drawable.car_mitsubishi), SUBARU(
			"˹��³", "subaru", R.drawable.subaru, R.drawable.car_subaru), INFINITI(
			"Ӣ�����", "infiniti", R.drawable.infiniti, R.drawable.car_infiniti), MITSUOKA(
			"���", "mitsuoka", R.drawable.mitsuoka, R.drawable.car_mitsuoka),

	// �й�
	BYD("���ǵ�", "byd", R.drawable.byd, R.drawable.car_byd), DIHAO("�ۺ�", "dihao",
			R.drawable.dihao, R.drawable.car_dihao), DONGFENG("����", "dongfeng",
			R.drawable.dongfeng, R.drawable.car_dongfeng), FOTON("����", "foton",
			R.drawable.foton, R.drawable.car_foton), HAIMA("����", "haima",
			R.drawable.haima, R.drawable.car_haima), GEELY("����", "geely",
			R.drawable.geely, R.drawable.car_geely), JIANGHUAI("����",
			"jianghuai", R.drawable.jianghuai, R.drawable.car_jianghuai), RUIQI(
			"����", "ruiqi", R.drawable.ruiqi, R.drawable.car_ruiqi), JIEFANG(
			"���", "jiefang", R.drawable.jiefang, R.drawable.car_jiefang), CHANGAN(
			"����", "changan", R.drawable.changan, R.drawable.car_changan), GREATWALL(
			"����", "greatwall", R.drawable.greatwall, R.drawable.car_greatwall), ZHONGHUA(
			"�л�", "zhonghua", R.drawable.zhonghua, R.drawable.car_ruiqi);
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
