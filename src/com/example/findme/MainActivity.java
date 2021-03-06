package com.example.findme;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
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
	private Button newCaseActivityBtn;
	private Button p2;
	private Button p3;
	private Context context;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		
		Parse.initialize(this, "XaleNqb8plMKReJIkuAwbokajOkcKo1RkOGdPUcN", "EqxiSF75OYaPQcOMYRR3K8yJursh6sbyHSLpldTT");
		
		this.newCaseActivityBtn = (Button) findViewById(R.id.newCaseActivityBtn);
		this.p2 = (Button) findViewById(R.id.p2);
		this.p3 = (Button) findViewById(R.id.p3);
				
		this.newCaseActivityBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onNewCaseActivityButtonClicked();
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
	private void onNewCaseActivityButtonClicked() {
		Intent intent = new Intent(this, NewCaseActivity.class);
		startActivity(intent);
	
//		this.sayToast("NewCaseActivity");
	}
	
	private void onp2ButtonClicked() {
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
		
		
		this.sayToast("P2");
	}
	
	private void onp3ButtonClicked() {
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
		
		this.sayToast("P3");
	}
	
	
	
	private void sayToast(String hi)
	{
		Toast.makeText(getApplicationContext(), hi, Toast.LENGTH_SHORT).show();
	}
	
	
}
