package com.sandy.nicky.car;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sandy.nicky.car.Adapter.CarSelectionAdapter;
import com.sandy.nicky.car.constants.CarEnum;
import com.sandy.nicky.car.constants.CountryCarInstance;
import com.sandy.nicky.car.constants.CountryEnum;
import com.sandy.nicky.car.dataobject.CarItem;

public class CarSelectionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.car_selection_layout);
		Intent intent = getIntent();
		// …Ë÷√titleBar
		final String lable = intent.getStringExtra("lable");
		Window mWindow = getWindow();
		mWindow.setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);

		ImageView title_country_flag = (ImageView) findViewById(R.id.title_country_flag);
		TextView title_country_name = (TextView) findViewById(R.id.title_country_name);
		title_country_flag.setImageResource(CountryEnum.getCountryEnumByCnName(
				lable).getImgId());
		title_country_name.setText(lable);
		CountryEnum country = CountryEnum.getCountryEnumByCnName(lable);

		GridView countryNameView = (GridView) findViewById(R.id.car_selection_view);
		List<CarEnum> carList = CountryCarInstance.getInstance()
				.getCountryCar().get(country);
		List<CarItem> carItems = new ArrayList<CarItem>();
		if (carList != null && carList.size() > 0) {
			for (CarEnum car : carList) {
				carItems.add(new CarItem(car));
			}
		}
		countryNameView.setAdapter(new CarSelectionAdapter(this,
				R.layout.car_selection_content, carItems));

	}

}
