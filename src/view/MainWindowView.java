package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.WebItemDataModel;


public class MainWindowView extends JFrame {
	
	public JList<String> myList;
	public JLabel lblStatus; 
	private JPanel panList; 
	private JPanel panStatus;
	private String imagePath = "/images/";
	
	// Menu Bar
	private JMenuItem jmiProp;

	private static final long serialVersionUID = 1L;

	public MainWindowView () {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Is Http online");
		
        initMenuBar();
		initForm();
	}
	
	private void initMenuBar() {
		JMenuBar m = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		
		JMenuItem jmiNew = new JMenuItem("New Item");
		jmFile.add(jmiNew);
		
		jmiProp = new JMenuItem("Properties");
		jmFile.add(jmiProp);
		
        m.add(jmFile);
        this.setJMenuBar(m);
	}
	
	private void initForm() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 200, 300, 200);
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("IsHttpOnline");
		
		// Panel List
		panList = new JPanel(new GridBagLayout());
		panList.setBorder(new EmptyBorder(10,10,10,10));
		panList.setBackground(Color.WHITE);
		JLabel lblLoading = new JLabel("Loading");
		panList.add(lblLoading);
		this.add(panList, BorderLayout.PAGE_START);
		
		// Status
		panStatus = new JPanel();
		lblStatus = new JLabel();
		panStatus.add(lblStatus);
		this.add(panStatus, BorderLayout.PAGE_END); 
	}
	

	public void addWebItems ( String[] data ) {
		myList.setListData(data);
	}
	
	public void removeAllWebItems () {
		panList.removeAll();
	}
	
	public void addWebItemsToPan ( WebItemDataModel[] data ) {
		
		// Optionen for the Layoutmanager
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel[] items = new JLabel[data.length]; 
		
		this.removeAllWebItems();
		for ( int i = 0; i<data.length; i++ ) {
			// Set Icon
			String iconName = "icon-offline.png";
			if ( data[i].getOnlineStatus() ) {
				iconName = "icon-online.png";
			}
			URL resource = getClass().getResource(this.imagePath+iconName); 
			ImageIcon icon = new ImageIcon(resource);
			
			items[i] = new JLabel(data[i].getUrl(), icon, JLabel.LEFT );
			
			gbc.gridy = i + 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			panList.add(items[i], gbc);
		}
		panList.revalidate();
	}
	
	
	public void setJMenuItemListener(ActionListener l){
        this.jmiProp.addActionListener(l);
    }


}
