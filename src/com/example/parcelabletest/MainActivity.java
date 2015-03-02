package com.example.parcelabletest;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity
{
	private ImageView img;
	private TextView textview1;
	private TextView textview2;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img = (ImageView) findViewById(R.id.imageView1);
		textview1 = (TextView) findViewById(R.id.textView1);
		textview2 = (TextView) findViewById(R.id.textView2);
		Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher);
		String name = "name";
		int num = 1;
		
		map.put("myimg", bitmap);
		map.put("name", name);
		map.put("num", num);
		
		img.setImageBitmap(bitmap);
		textview1.setText(name);
		textview2.setText(num+"");
		
		img.setOnClickListener(new OnClickListener()
			{
				
				@Override
				public void onClick(View v)
				{
					// TODO Auto-generated method stub
					ParcelableMap p = new ParcelableMap();
					Intent intent = new Intent(MainActivity.this, SecondActivity.class);
					Bundle bundle = new Bundle();
					p.setMap(map);
					bundle.putParcelable("mymap", p);
					intent.putExtras(bundle);
					startActivity(intent);
				}
			});
	}
}
