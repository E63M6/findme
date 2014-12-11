package com.example.findme;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FunctionCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseQuery;

//import com.parse.GetCallback;
//import com.parse.ParseException;
//import com.parse.ParseQuery;


public class GuideActivity extends Activity {
	
	private String noticeMsg;
	private String version;
	private Button sendBtn;
	private Button mainActivity;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		context = this;
		
		Parse.initialize(this, "XaleNqb8plMKReJIkuAwbokajOkcKo1RkOGdPUcN", "EqxiSF75OYaPQcOMYRR3K8yJursh6sbyHSLpldTT");
		
		this.sendBtn = (Button) findViewById(R.id.sendBtn);
		this.mainActivity = (Button) findViewById(R.id.mainActivity);
				
		this.sendBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onOkButtonClicked();
			}
			
		});
		
		this.mainActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onMainActivityButtonClicked();
			}
			
		});
//		if(isNetworkAvailable())
//		{
//			ParseQuery<Notice> query = ParseQuery.getQuery(Notice.class);
//			query.getFirstInBackground(new GetCallback<Notice>() {
//
//				@Override
//				public void done(Notice object, ParseException e) {
//					final String lastVerstion = object.getLastVersion();
//					setVersion(lastVerstion);
//					
//					final String message = object.getNotice();
//					setNoticeMsg(message);
//					
//					new Handler().postDelayed(new Runnable() {
//			            @Override
//			            public void run() {
//			            	checkNotice();
//			            }
//					}, 800);
//					
//				}
//			});
//		}
//		else
//		{
//			AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
//			builder1.setTitle(getResources().getString(R.string.unicum));
//	        builder1.setMessage(getResources().getString(R.string.turnonNetworkServices));
//	        builder1.setCancelable(true);
//	        builder1.setNegativeButton(getResources().getString(R.string.exit), 
//	        		new DialogInterface.OnClickListener() {
//	            public void onClick(DialogInterface dialog, int id) {
//	                finish();
//	            }
//	        });
//	        builder1.setPositiveButton(getResources().getString(R.string.settings),
//	                new DialogInterface.OnClickListener() {
//	            public void onClick(DialogInterface dialog, int id) {
//	            	startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
//	            }
//	        });
//	        AlertDialog alert11 = builder1.create();
//	        alert11.show();
//		}
		
	}
	
//	private void checkNotice(){
//		if(noticeMsg.length()>0)
//		{
////			System.out.println("hi");
//			AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
//			builder1.setTitle(getResources().getString(R.string.notification));
//	        builder1.setMessage(noticeMsg);
//	        builder1.setCancelable(true);
//	        builder1.setNegativeButton(getResources().getString(R.string.exit), 
//	        		new DialogInterface.OnClickListener() {
//	            public void onClick(DialogInterface dialog, int id) {
//	                finish();
//	            }
//	        });
//	        builder1.setPositiveButton(getResources().getString(R.string.ok),
//	                new DialogInterface.OnClickListener() {
//	            public void onClick(DialogInterface dialog, int id) {
//	            	checkVersion();
//	            }
//	        });
//	        AlertDialog alert11 = builder1.create();
//	        alert11.show();
//		}
//		else
//		{
//			checkVersion();
//		}
//	}
//	
//	private void checkVersion(){
//		int versionNumber=0;
//		PackageInfo pinfo;
//		try {
//			pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
//			versionNumber = pinfo.versionCode;
//		} catch (NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		if(version!=null && (versionNumber!=0))
//		{
//			onOkButtonClicked();
//		}
//		else
//		{
//			// if version == app version
//			if(versionNumber==Integer.parseInt(version))
//			{
//				onOkButtonClicked();
//			}
//			else
//			{
//				onOkButtonClicked();
//				// show dialog
//				
//				//ok: go playstore
//				//no: onOkButtonClicked();
//
//			}
//		}
//	}
			


	private void onMainActivityButtonClicked() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	private void onOkButtonClicked() {
		this.sayToast("Clicked");
	
		String input = "<PAYLOAD><USEROBJECTID>Mu1K2TuLPj</USEROBJECTID><LAISO>EN</LAISO><CASEOBJECTID>DDpLaGBXEk</CASEOBJECTID><CASENAME>Are you there, pretty?</CASENAME><BUBBLEBURST>2327</BUBBLEBURST></PAYLOAD>";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("payload", input);

	    
	    ParseCloud.callFunctionInBackground("inboundZITSMTL", params, new FunctionCallback<String>() {
	    	  public void done(String result, ParseException e) {
	    	    if (e == null) {
	    	      // result is "Hello world!"	
	    	    	
	    	    }
	    	    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
	    	  }
	    	});
		
		
		this.sayToast("Done");
		
	}
	
	void setNoticeMsg(String Msg) {
		this.noticeMsg = Msg;
	}
	
	void setVersion(String version) {
		this.version = version;
	}
	
	private boolean isNetworkAvailable()
	{
		boolean mobileNwInfo = false;  
		ConnectivityManager conxMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);  
		try { mobileNwInfo = conxMgr.getActiveNetworkInfo().isConnected(); }  
		catch (NullPointerException e) { mobileNwInfo = false; }  
		
		return mobileNwInfo;
	}
	
	private void sayToast(String hi)
	{
		Toast.makeText(getApplicationContext(), hi, Toast.LENGTH_SHORT).show();
	}
	
	
}
