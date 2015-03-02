package com.example.parcelabletest;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity
{
	private ImageView img;
	private TextView textview1;
	private TextView textview2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		img = (ImageView) findViewById(R.id.imageView1);
		textview1 = (TextView) findViewById(R.id.textView1);
		textview2 = (TextView) findViewById(R.id.textView2);
		
		
		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		ParcelableMap p = bundle.getParcelable("mymap");
		Map<String, Object> map = p.getMap();
		
		img.setImageBitmap((Bitmap)map.get("myimg"));
		textview1.setText((String)map.get("name"));
		textview2.setText((Integer)map.get("num")+"");
		
	}
}
