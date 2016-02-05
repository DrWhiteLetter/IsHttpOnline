package model;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebItemDataModel {
	
	private String _url;
	
	public WebItemDataModel (String url ) {
		this._url = this.prepareURL(url);
	}
	
	public String getUrl () {
		return this._url;
	}
	
	private String prepareURL(String url) {
		url = url.replace("http://", "");
		url = "http://" + url;
		return url;
	}
	
	public boolean getOnlineStatus() {
		
		boolean online = false; 
		try {	
			
			URL url = new URL( this.getUrl() );
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("HEAD");
			
			int responseCode = huc.getResponseCode();
			if ( responseCode == 200 ) {
				online = true;
			} else {
				System.out.println( responseCode );
			}
            
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// Only for Debugging! 
			//e.printStackTrace();
		} 
		
		return online;
	}
	
}
