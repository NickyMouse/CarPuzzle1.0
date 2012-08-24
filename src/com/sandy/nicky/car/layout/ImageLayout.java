package com.sandy.nicky.car.layout;

import net.youmi.android.AdManager;
import net.youmi.android.AdView;
import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageLayout extends LinearLayout {
	private Context ctx;
	private ImageView[][] imageViewArr;

	public ImageLayout(Context context, ImageView[][] imageViewArray) {
		super(context);
		imageViewArr = imageViewArray;
		ctx = context;
		setContent();
	}

	private void setContent() {
		LinearLayout linear = new LinearLayout(ctx);

		linear.setOrientation(LinearLayout.VERTICAL);

		for (int i = 0; i < imageViewArr.length; i++) {
			LinearLayout linearLayout = new LinearLayout(ctx);
			linearLayout.setOrientation(LinearLayout.HORIZONTAL);

			int length = imageViewArr[i].length;

			for (int j = 0; j < length; j++) {
				ImageView imageView = (ImageView) imageViewArr[i][j];

				if (imageView != null) {
					linearLayout.addView(imageView, new LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
				}
			}

			linear.addView(linearLayout);
		}

		// 初始化广告条，可以使用其他的构造函数设置文字类型广告的背景色、透明度及字体颜色
		AdManager.init(ctx, "da987421a2e03f3e", "957871407d2500ee", 30, false);
		AdView adView = new AdView(ctx, null);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.gravity = Gravity.BOTTOM;
		linear.addView(adView, params);
		this.addView(linear);
	}
}
