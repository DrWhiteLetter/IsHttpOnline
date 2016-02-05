package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.MainWindowModel;
import view.MainWindowView;

public class MainWindowController {
	
	private MainWindowModel _model;
	private MainWindowView _view; 
	private int _refreshTime; 
	
	
	public MainWindowController () {
		this._model = new MainWindowModel();
		this._view = new MainWindowView();
		
		this.addListener();
	}
	
	public void setRefreshTime (int time) {
		this._refreshTime = time;
	}

	public void showView() {
		
		Intervall intv = new Intervall();
		intv._model = _model; 
		intv._view = _view;
		intv._refreshTime = this._refreshTime;
		intv.start();
		
		_view.setVisible(true);
	}
	
	private void addListener(){
        this._view.setJMenuItemListener(new JMenuItemListener());
    }
	
	class JMenuItemListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            PreferencesController prefController = new PreferencesController();
            prefController.showView();
        }
    }
}

class Intervall extends Thread {
	
	MainWindowModel _model; 
	MainWindowView _view;
	int _refreshTime; 
	
	public void run () {
		
		
		while (true){
			
			try {
				PreferencesController prefController = new PreferencesController();
				List<String> webItem = prefController.getWebItems();
				if ( webItem.size() > 0 ) {
					_view.addWebItemsToPan(_model.checkOnlineStatus(webItem));
					SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
					_view.lblStatus.setText("Last update: " + time.format(new Date()));
					sleep(1000); // Bugfix
					_view.validate();
					_view.update(_view.getGraphics());
					sleep(_refreshTime-1000); // Without the Bugfix (Time)
				} else {
					_view.removeAllWebItems();
					_view.validate();
					_view.update(_view.getGraphics());
					sleep(1000);
				}
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}