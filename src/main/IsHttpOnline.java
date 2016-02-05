package main;

import java.util.List;

import controller.MainWindowController;
import controller.PreferencesController;

public class IsHttpOnline {
	
	static MainWindowController _controller;

	public static void main(String[] args) {
		
		// take the menu bar off the jframe
		System.setProperty("apple.laf.useScreenMenuBar", "false");

		// set the name of the application menu item
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "ImageRotator");

		// Get properties 
		PreferencesController prefContr = new PreferencesController();
		List<String> myWebsites = prefContr.getWebItems();
		if ( myWebsites.size() == 0 ) {
			prefContr.showView();
		}
		
		_controller = new MainWindowController();
		_controller.setRefreshTime(20000);
		_controller.showView();
	}

}
