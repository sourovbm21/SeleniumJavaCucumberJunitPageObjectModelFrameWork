package com.qa.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CommonUtility {
	
	
	
	
	public static void  checkBrokenLinks(String linkUrl) throws IOException {
		
	try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection	 =(HttpURLConnection)url.openConnection();
			httpUrlConnection.setConnectTimeout(3000);
			httpUrlConnection.connect();
			if(httpUrlConnection.getResponseCode()>=400) {
				System.out.println(linkUrl +"--->"+httpUrlConnection.getResponseMessage()+" it is a broken link  "
						+ ""+httpUrlConnection.getResponseCode());
			}else {
				System.out.println(
						linkUrl + "--->" + httpUrlConnection.getResponseMessage() + " it is not a broken link ");

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
