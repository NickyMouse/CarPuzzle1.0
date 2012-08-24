package com.sandy.nicky.car;

import java.util.ArrayList;
import java.util.List;

import net.youmi.android.AdManager;
import net.youmi.android.AdView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sandy.nicky.car.constants.CountryEnum;
import com.sandy.nicky.car.dataobject.CountryItem;

public class CountrySelectionActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.country_selection_list_layout);

		// 初始化广告条，可以使用其他的构造函数设置文字类型广告的背景色、透明度及字体颜色
		AdManager.init(this, "da987421a2e03f3e", "957871407d2500ee", 30, false);
		LinearLayout adViewLayout = (LinearLayout) findViewById(R.id.adViewLayout);
		adViewLayout.addView(new AdView(this), new LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));

		Window mWindow = getWindow();
		mWindow.setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_bar_no_img);
		TextView title_country_name = (TextView) findViewById(R.id.title_country_name);
		title_country_name.setText("选择国家");

		ListView countryListView = (ListView) findViewById(R.id.country_list_view);

		List<CountryItem> countryItems = new ArrayList<CountryItem>();
		for (CountryEnum country : CountryEnum.values()) {
			countryItems.add(new CountryItem(country));
		}
		countryListView.setAdapter(new CountryItemAdapter(this,
				R.layout.country_selection_list_content, countryItems));

	}

	private class CountryItemAdapter extends ArrayAdapter<CountryItem> {

		private List<CountryItem> countryItems;

		private int reousrceId;

		public CountryItemAdapter(Context context, int resourceId,
				List<CountryItem> countryItems) {
			super(context, resourceId, countryItems);
			this.countryItems = countryItems;
			this.reousrceId = resourceId;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			RelativeLayout countryView;

			CountryItem country = getItem(position);
			if (convertView == null) {
				countryView = new RelativeLayout(getContext());
				String inflater = Context.LAYOUT_INFLATER_SERVICE;
				LayoutInflater vi;
				vi = (LayoutInflater) getContext().getSystemService(inflater);
				vi.inflate(reousrceId, countryView, true);
			} else {
				countryView = (RelativeLayout) convertView;
			}
			TextView country_name_view = (TextView) countryView
					.findViewById(R.id.country_name);
			country_name_view.setText(country.getCountryName());
			ImageView country_flag_view = (ImageView) countryView
					.findViewById(R.id.country_flag);
			country_flag_view.setImageResource(country.getFlagImgId());

			countryView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					TextView countryTextView = (TextView) v
							.findViewById(R.id.country_name);
					Intent intent = new Intent();
					intent.setAction("com.sandy.nicky.car.CarSelectionActivity");
					intent.putExtra("lable", countryTextView.getText());
					startActivity(intent);
				}
			});
			return countryView;
		}

	}

}
