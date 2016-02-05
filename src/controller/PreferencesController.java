package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import model.PreferencesModel;
import view.PreferencesView;

public class PreferencesController {
	private PreferencesView _view;
	private PreferencesModel _model;
	private List<String> _webItems; 
	public String configFile = "isHttpOnlineConfig.txt";
	
	public PreferencesController () {
		_webItems = PreferencesModel.initConfigFile("isHttpOnlineConfig.txt");
		this._view = new PreferencesView();
		this._model = new PreferencesModel();
		this.addListener();
	}
	
	public void showView () {
		_view.txtWebItems.setText(this.getWebItemsString());
		_view.setVisible(true);
	}
	
	public List<String> getWebItems () {
		this.checkWebItems(this._webItems);
		return this._webItems;
	}
	
	public String getWebItemsString () {
		return _model.ListToString(this._webItems);
	}
	
	public void setWebItems (List<String> data) {
		this._webItems = data; 
	}
	
	public void writeWebItems () {

		try {

			File file = new File(this.configFile);
			OutputStream out = new FileOutputStream(file);
			for ( String _url: this._webItems ) {
				_url = _url + "\r\n";
				out.write(_url.getBytes());
			}
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	private void checkWebItems (List<String> webItems) {
		for (int i = 0; i < webItems.size(); i++) {
			if ( _webItems.get(i).isEmpty() ) {
				_webItems.remove(i);
			}
		}
	}
	
	
	private void addListener(){
        this._view.setJButtonSave(new JButtonSaveListener());
    }
	
	class JButtonSaveListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	String data = PreferencesController.this._view.txtWebItems.getText();
        	List<String> webItems = PreferencesController.this._model.StringToList(data);
        	PreferencesController.this.setWebItems(webItems);
            PreferencesController.this.writeWebItems();
            PreferencesController.this._view.dispose();
        }
    }
}
