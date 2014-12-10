package com.example.findme;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FunctionCallback;
import com.parse.Parse;
import com.parse.ParseCloud;
import com.parse.ParseException;

//import com.parse.GetCallback;
//import com.parse.ParseException;
//import com.parse.ParseQuery;


public class MainActivity extends Activity {
	
	private String noticeMsg;
	private String version;
	private Button p1;
	private Button p2;
	private Button p3;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		
		this.p1 = (Button) findViewById(R.id.p1);
		this.p2 = (Button) findViewById(R.id.p2);
		this.p3 = (Button) findViewById(R.id.p3);
				
		this.p1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onp1ButtonClicked();
			}
			
		});
		
		this.p2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onp2ButtonClicked();
			}
			
		});
		
		this.p3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onp3ButtonClicked();
			}
			
		});
			
	}
	private void onp1ButtonClicked() {
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
//		finish();
		
		this.sayToast("P1");
	}
	
	private void onp2ButtonClicked() {
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
//		finish();
		
		this.sayToast("P2");
	}
	
	private void onp3ButtonClicked() {
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
//		finish();
		
		this.sayToast("P3");
	}
	
	
	
	private void sayToast(String hi)
	{
		Toast.makeText(getApplicationContext(), hi, Toast.LENGTH_SHORT).show();
	}
	
	
}
