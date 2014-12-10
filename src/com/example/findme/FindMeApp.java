package com.example.findme;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class FindMeApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		ParseObject.registerSubclass(Notice.class);

		Parse.initialize(this, "XaleNqb8plMKReJIkuAwbokajOkcKo1RkOGdPUcN", "EqxiSF75OYaPQcOMYRR3K8yJursh6sbyHSLpldTT");
	}
}
