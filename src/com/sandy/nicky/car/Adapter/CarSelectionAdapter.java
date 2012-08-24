package com.sandy.nicky.car.Adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sandy.nicky.car.R;
import com.sandy.nicky.car.dataobject.CarItem;

public class CarSelectionAdapter extends ArrayAdapter<CarItem> {

	private List<CarItem> carItems = new ArrayList<CarItem>();
	private int reousrceId;

	public CarSelectionAdapter(Context context, int resourceId,
			List<CarItem> carItems) {
		super(context, resourceId, carItems);
		this.carItems = carItems;
		this.reousrceId = resourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RelativeLayout carView;

		CarItem car = getItem(position);
		if (convertView == null) {
			carView = new RelativeLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi;
			vi = (LayoutInflater) getContext().getSystemService(inflater);
			vi.inflate(reousrceId, carView, true);
		} else {
			carView = (RelativeLayout) convertView;
		}
		ImageView carImg = (ImageView) carView.findViewById(R.id.car_img);
		TextView carName = (TextView) carView.findViewById(R.id.car_name);
		carImg.setImageResource(car.getCarImgId());
		carName.setText(car.getCarName());
		carView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView carName = (TextView) v.findViewById(R.id.car_name);
				Intent intent = new Intent();
				intent.setAction("com.sandy.nicky.car.CarPuzzleActivity");
				intent.putExtra("lable", carName.getText());
				getContext().startActivity(intent);
			}

		});
		return carView;
	}

}
