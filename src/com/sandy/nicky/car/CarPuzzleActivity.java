package com.sandy.nicky.car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.sandy.nicky.car.constants.CarEnum;
import com.sandy.nicky.car.layout.ImageLayout;

public class CarPuzzleActivity extends Activity {

	private static final int NUM_LINES = 3;

	private static final int ERROR = 1;
	private static final int SUCCESS = 2;

	private int image = 0;

	private Bitmap bitmap;

	private ImageView[][] imageViewArray;
	private Bitmap[][] bitmapArray;
	private int[] imageArray;

	private float scaleWidth;
	private float scaleHeight;
	private int blockWidth;
	private int blockHeight;

	private int clickNum = 0;
	private Point po;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		// 设置titleBar
		String carName = intent.getStringExtra("lable");
		image = CarEnum.getCarEnumByCnName(carName).getPuzzleImgId();

		imageViewArray = new ImageView[NUM_LINES + 1][NUM_LINES + 1];
		bitmapArray = new Bitmap[NUM_LINES + 1][NUM_LINES + 1];
		imageArray = new int[(NUM_LINES + 1) * (NUM_LINES + 1)];

		// Set Full Screen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		bitmap = BitmapFactory.decodeResource(getResources(), image);
		int bitmapWidth = bitmap.getWidth();
		int bitmapHeight = bitmap.getHeight();

		// 获取屏幕尺寸大小，需要乘以density
		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
		float density = getResources().getDisplayMetrics().density;
		float screenWidth = displayMetrics.widthPixels * density;
		float screenHeight = displayMetrics.heightPixels * density;

		scaleWidth = screenWidth / bitmapWidth;
		scaleHeight = screenHeight * 2 / 3 / bitmapHeight;

		blockWidth = bitmapWidth / (NUM_LINES + 1);
		blockHeight = bitmapHeight / (NUM_LINES + 1);

		produceRandomImageViewArray();
		ready4ImageContent();
		ImageLayout imageLayout = new ImageLayout(this, imageViewArray);

		setContentView(imageLayout);
	}

	/**
	 * This private method is to preparing for image fragment displaying.
	 */
	private void ready4ImageContent() {
		Matrix matrix = new Matrix();

		matrix.postScale(scaleWidth, scaleHeight);

		// Divide
		Bitmap fragment[][] = new Bitmap[NUM_LINES + 1][NUM_LINES + 1];
		for (int i = 0; i < NUM_LINES + 1; i++) {
			for (int j = 0; j < NUM_LINES + 1; j++) {
				int x = j * blockWidth;
				int y = i * blockHeight;

				Bitmap mapi = Bitmap.createBitmap(bitmap, x, y, blockWidth,
						blockHeight, matrix, true);
				fragment[i][j] = mapi;
			}
		}

		// Synchronize to bit image array(imageArray)
		for (int i = 0; i < imageArray.length; i++) {
			int x = imageArray[i] / (NUM_LINES + 1);
			int y = imageArray[i] % (NUM_LINES + 1);

			int xx = i / (NUM_LINES + 1);
			int yy = i % (NUM_LINES + 1);

			bitmapArray[xx][yy] = fragment[x][y];
		}

		// Show fragment in image content
		for (int i = 0; i < bitmapArray.length; i++) {
			for (int j = 0; j < bitmapArray[i].length; j++) {
				BitmapDrawable draw = new BitmapDrawable(bitmapArray[i][j]);

				ImageView imageView = new ImageView(this);
				imageView.setImageDrawable(draw);
				imageView.setScaleType(ScaleType.FIT_XY);// for bottom of the
															// image displaying
				imageView.setOnClickListener(OnClickImageView);

				imageViewArray[i][j] = imageView;
			}
		}
	}

	/**
	 * This private method is to produce random image view array.
	 */
	private void produceRandomImageViewArray() {
		int imageLen = (NUM_LINES + 1) * (NUM_LINES + 1);

		int array[] = new int[(NUM_LINES + 1) * (NUM_LINES + 1)];

		for (int i = 0; i < imageLen; i++) {
			array[i] = i;
		}

		int length = imageLen;

		for (int i = 0; i < imageLen; i++) {
			int index = (int) Math.floor(Math.random() * length);

			imageArray[i] = array[index];

			for (int j = index; j < array.length - 1; j++) {
				array[j] = array[j + 1];
			}

			length--;
		}
	}

	/**
	 * This private method is to check whether puzzle has finished.
	 */
	private boolean hasCompleted() {
		for (int i = 0; i < (NUM_LINES + 1) * (NUM_LINES + 1); i++) {
			if (imageArray[i] != i) {
				return false;
			}
		}

		return true;
	}

	private android.view.View.OnClickListener OnClickImageView = new ImageView.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (clickNum == 0)// 说明这次点击是第一次点击，即需要交换的第一个图片
			{
				// clickView = (ImageView) v;
				for (int i = 0; i < imageViewArray.length; i++) {
					boolean f = false;
					for (int j = 0; j < imageViewArray[i].length; j++) {
						ImageView imgg = imageViewArray[i][j];
						if (imgg == v) {
							po = new Point(i, j);
							clickNum++;
							f = true;
							break;
						}
					}
					if (f) {
						break;
					}
				}
			} else // 说明这次点击是第二次点击，即需要交换的第二个图片
			{
				// clickView = (ImageView) v;
				for (int i = 0; i < imageViewArray.length; i++) {
					for (int j = 0; j < imageViewArray[i].length; j++) {
						ImageView imgg = imageViewArray[i][j];
						if (imgg == v) {
							if (po != null) {
								changeBitmapPosition(i, j, po.x, po.y);
								po = null;
								clickNum = 0;
							}
						}
					}
				}
			}
		}
	};

	/**
	 * 
	 * @param x
	 *            所点击图片在数组内一维的位置
	 * @param y
	 *            所点击图片在数组内二维的位置
	 * @param x1
	 *            所点击图片需要被交换到得在数组内一维的位置
	 * @param y1
	 *            所点击图片需要被交换到得在数组内二维的位置
	 */
	private void changeBitmapPosition(int x, int y, int x1, int y1) {
		if (Math.abs(x - x1) + Math.abs(y - y1) != 1) {
			showDialog(ERROR);
		} else {
			Bitmap bitF = null;
			Bitmap bitS = null;
			Point p1 = new Point();
			Point p2 = new Point();

			int len = bitmapArray.length;
			for (int i = 0; i < len; i++) {
				int leng = bitmapArray[i].length;
				for (int j = 0; j < leng; j++) {
					Bitmap mapi = bitmapArray[i][j];
					if ((i == x) && (j == y)) {
						bitF = mapi;
						p1.x = i;
						p1.y = j;
					} else if ((i == x1) && (j == y1)) {
						bitS = mapi;
						p2.x = i;
						p2.y = j;
					}
				}
			}
			bitmapArray[p1.x][p1.y] = bitS;
			int temp = imageArray[p1.x * (NUM_LINES + 1) + p1.y];
			imageArray[p1.x * (NUM_LINES + 1) + p1.y] = imageArray[p2.x
					* (NUM_LINES + 1) + p2.y];
			bitmapArray[p2.x][p2.y] = bitF;
			imageArray[p2.x * (NUM_LINES + 1) + p2.y] = temp;

			for (int i = 0; i < bitmapArray.length; i++) {
				for (int j = 0; j < bitmapArray[i].length; j++) {
					ImageView img = new ImageView(this);
					BitmapDrawable draw = new BitmapDrawable(bitmapArray[i][j]);
					img.setImageDrawable(draw);
					img.setScaleType(ScaleType.FIT_XY);// 如果不加这句，会出现最后一行不能整天显示的效果
					img.setOnClickListener(OnClickImageView);
					imageViewArray[i][j] = img;
				}
			}

			ImageLayout imageLayout = new ImageLayout(this, imageViewArray);
			setContentView(imageLayout);

			if (hasCompleted()) {
				showDialog(SUCCESS);
			}
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case SUCCESS:
			return buildSuccessDialog(CarPuzzleActivity.this);
		case ERROR:
			return buildErrorDialog(CarPuzzleActivity.this);
		}

		return null;
	}

	private AlertDialog buildErrorDialog(Context context) {
		Builder builder = new AlertDialog.Builder(context);
		builder.setPositiveButton("error", null);
		return builder.create();
	}

	private AlertDialog buildSuccessDialog(final Context context) {
		Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Well Done!");
		builder.setMessage("Congratulations!")
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						CarPuzzleActivity.this.finish();
					}
				})
				.setNegativeButton("SAVE",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								CarPuzzleActivity cpa = (CarPuzzleActivity) context;
								CarEnum car = CarEnum
										.getCarEnumByPuzzleImgId(cpa.image);
								Bitmap bitmap = cpa.bitmap;
								File d = new File("/sdcard/CarPuzzle/");
								if (!d.exists()) {
									d.mkdirs();
								}
								File f = new File("/sdcard/CarPuzzle/"
										+ car.getEnName() + ".png");
								int i = 0;
								while (f.exists()) {
									f = new File("/sdcard/CarPuzzle/"
											+ car.getEnName() + "[" + i + "]"
											+ ".png");
									i++;
								}
								try {
									f.createNewFile();
								} catch (IOException e) {
									e.printStackTrace();
								}
								FileOutputStream fOut = null;
								try {
									fOut = new FileOutputStream(f);
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								}
								bitmap.compress(CompressFormat.PNG, 100, fOut);
								try {
									fOut.flush();
								} catch (IOException e) {
									e.printStackTrace();
								}
								try {
									fOut.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});

		return builder.create();
	}
}