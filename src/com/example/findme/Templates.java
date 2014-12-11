package com.example.findme;

//Armor.java
import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Templates")
public class Templates extends ParseObject {
	
	public Templates()
	{
//			System.out.println("Telegraph has been called. Maybe it's not that good.");	DEBUGGING PRINT
	}
	
	// Full Text to the server
	public Templates(String lastVersion) {
		
	}
	
	public String getDescription() {
		return getString("description");
	}
	
	public String getimageURL() {
		return getString("imageURL");
	}

	public String getNotice() {
		return getString("Notice");
	}


}
