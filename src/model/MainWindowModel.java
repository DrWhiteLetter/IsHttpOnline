package model;


import java.util.List;


public class MainWindowModel {
	
	public String prepareURL(String url) {
		url = url.replace("http://", "");
		url = "http://" + url;
		return url;
	}
	
	public WebItemDataModel[] checkOnlineStatus (List<String> websites) {

		WebItemDataModel[] items = new WebItemDataModel[websites.size()];
		
		int i = 0;
		for (String _url: websites) { 
			if ( !_url.isEmpty() ) {
				items[i] = new WebItemDataModel(_url);
				i++;
			}
		}
		return items;
	}
	

	
}


