package com.example.findme;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseQuery;

//import com.parse.GetCallback;
//import com.parse.ParseException;
//import com.parse.ParseQuery;


public class NewCaseActivity extends Activity {
	
	private Context context;
	private ArrayList<ImageButton> caseBtn;
	private ArrayList<TextView> caseText;
	private ArrayList<String> newCaseList;
	private ArrayList<String> imageURL;
	private ArrayList<Bitmap> myImage;
	private Bitmap tempImg;
	private Drawable tempDraw;
	private int numOfCase;
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newcase);
		context = this;
		Parse.initialize(this, "XaleNqb8plMKReJIkuAwbokajOkcKo1RkOGdPUcN", "EqxiSF75OYaPQcOMYRR3K8yJursh6sbyHSLpldTT");
		
		caseBtn = new ArrayList<ImageButton>();
		caseText = new ArrayList<TextView>();
		newCaseList = new ArrayList<String>();
		imageURL = new ArrayList<String>();
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		
		
		this.pullCaseListfromParse();
		
		
		caseBtn.add((ImageButton) findViewById(R.id.button1));
		caseBtn.add((ImageButton) findViewById(R.id.button2));
		caseBtn.add((ImageButton) findViewById(R.id.button3));
		caseBtn.add((ImageButton) findViewById(R.id.button4));
		caseBtn.add((ImageButton) findViewById(R.id.button5));
		caseBtn.add((ImageButton) findViewById(R.id.button6));
		caseBtn.add((ImageButton) findViewById(R.id.button7));
		caseBtn.add((ImageButton) findViewById(R.id.button8));
		caseBtn.add((ImageButton) findViewById(R.id.button9));
		
		caseText.add((TextView) findViewById(R.id.textView1));
		caseText.add((TextView) findViewById(R.id.textView2));
		caseText.add((TextView) findViewById(R.id.textView3));
		caseText.add((TextView) findViewById(R.id.textView4));
		caseText.add((TextView) findViewById(R.id.textView5));
		caseText.add((TextView) findViewById(R.id.textView6));
		caseText.add((TextView) findViewById(R.id.textView7));
		caseText.add((TextView) findViewById(R.id.textView8));
		caseText.add((TextView) findViewById(R.id.textView9));
		
		for(int i = 0;i<9;i++)
		{			
			caseBtn.get(i).setVisibility(View.INVISIBLE);
		}
		
		
//		this.p1.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				onp1ButtonClicked();
//			}
//			
//		});
//		
//		this.p2.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				onp2ButtonClicked();
//			}
//			
//		});
//		
//		this.p3.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				onp3ButtonClicked();
//			}
//			
//		});
			
	}
	private void onp1ButtonClicked() {
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
		
		this.sayToast("P1");
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
	
	private void showButton(){

		for(int i = 0; i < numOfCase; i++)
		{
			caseBtn.get(i).setVisibility(View.VISIBLE);
			myImage.add(getBitmapFromURL(imageURL.get(i)));
			caseBtn.get(i).setImageBitmap(myImage.get(i));
			
//			tempDraw = new BitmapDrawable(myImage.get(i));
//			caseBtn.setBackgroundDrawable(tempDraw);
//			caseBtn.get(i).setBackgroundResource("HTTP://URL.HERE");
			
			caseText.get(i).setText(newCaseList.get(i));
			caseText.get(i).setTextSize(7);
			caseText.get(i).setBackgroundColor(getResources().getColor(R.color.white));
			progressBar.setVisibility(View.INVISIBLE);
		}
		
		
	}
	
	public Bitmap getBitmapFromURL(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoInput(true);
	        connection.connect();
	        InputStream input = connection.getInputStream();
	        Bitmap myBitmap = BitmapFactory.decodeStream(input);
	        return myBitmap;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
	private void pullCaseListfromParse() {
		
		ParseQuery<Templates> query = ParseQuery.getQuery(Templates.class);
		
		query.whereExists("description");
		query.whereExists("imageURL");
//		query.whereDoesNotExist("parenttemplateid");
//		query.whereNotEqualTo("parenttemplateid",(null));
//		query.whereDoesNotExist("description");
		
		query.findInBackground(new FindCallback<Templates>() {
			@Override
			public void done(List<Templates> queueResult, ParseException e) {
				
				if(queueResult != null)
				{
					sayToast("Size:" + queueResult.size());
					numOfCase = queueResult.size();
					for(int i = 0; i<numOfCase;i++)
					{	
						newCaseList.add(queueResult.get(i).getDescription());
						imageURL.add(queueResult.get(i).getimageURL());
					}
				}
				new Handler().postDelayed(new Runnable() {
		            @Override
		            public void run() {
//		            	checkNotice(); 다음행동
		            	for(int i = 0; i<numOfCase;i++)
						{
		            		System.out.println(newCaseList.get(i));
						}
		            	showButton();
		            }
				}, 800);
				
			}
		});
		
	}
		
	private void sayToast(String hi)
	{
		Toast.makeText(getApplicationContext(), hi, Toast.LENGTH_SHORT).show();
	}
	
	
}
