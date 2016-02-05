package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PreferencesModel {

	public String ListToString (List<String> data) {
		String ret = "";
		for (String _url: data) {
			ret += _url+"\r\n";
		}
		return ret;
	}
	
	public List<String> StringToList (String data) {
		String lines[] = data.split("\r\n");
		List<String> retData = new ArrayList<>();

		for(String line: lines) {
			retData.add(line);
		}
		return retData;
	}
	
	static public List<String> initConfigFile (String configFile) {

		List<String> webItems = new ArrayList<String>(); 
		
		try {
			File file = new File(configFile);
			if ( file != null )
				file.createNewFile();
			InputStream in = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line = reader.readLine();

            while(line != null){
            	webItems.add(line); 
                line = reader.readLine();
            }  
            reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return webItems;
	}
	

	
}
