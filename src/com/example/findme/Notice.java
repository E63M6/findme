package com.example.findme;

//Armor.java
import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Notice")
public class Notice extends ParseObject {
	
	public Notice()
	{
//			System.out.println("Telegraph has been called. Maybe it's not that good.");	DEBUGGING PRINT
	}
	
	// Full Text to the server
	public Notice(String lastVersion, String noticeString) {
		
	}
	
	public String getLastVersion() {
		return getString("LastVersion");
	}

	public String getNotice() {
		return getString("Notice");
	}


}
