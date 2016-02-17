package view;


import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PreferencesView extends JFrame {

	private static final long serialVersionUID = 1L;  
	
	public JTextArea txtWebItems;
	public JButton btnSave;
	public JButton btnAddUrl;
	public JButton btnDelUrl;
	public JTextField txtUrl;
	public JList<String> lstWebItems;
	public DefaultListModel<String> lstWebItemModel;
	
	public PreferencesView() {
		this.initForm();
	}
	
	private void initForm () {
		this.setBounds(500, 200, 400, 250);
		this.setLayout(new FlowLayout());
		this.setTitle("Properties");
		
		/*
		// Refresh Time
		JPanel panRefresh = new JPanel();
		panRefresh.setBorder(new EmptyBorder(10, 10, 10, 10));
		JLabel lblRefresh = new JLabel("Refresh time:");
		//JTextField txtRefresh = new JTextField();
		panRefresh.add(lblRefresh);
		//panRefresh.add(txtRefresh);
		this.add(panRefresh);
		*/
		
		lstWebItemModel = new DefaultListModel<String>();
		
		// Website Items
		JPanel panWebItems = new JPanel();
		lstWebItems = new JList<String>(lstWebItemModel);
		lstWebItems.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblWebItems = new JLabel("Websites:\r\n");
		panWebItems.add(lblWebItems);
		panWebItems.add(lstWebItems);
		this.add(panWebItems);
		
		// Input 
		JPanel panInput = new JPanel();
		JLabel lblUrl = new JLabel("http://");
		txtUrl = new JTextField(22);
		panInput.add(lblUrl);
		panInput.add(txtUrl);
		this.add(panInput);
		
		
		// Steuerung
		JPanel panButtons = new JPanel();
		btnAddUrl = new JButton("Add");
		btnDelUrl = new JButton("Delete");

		panButtons.add(btnAddUrl);
		panButtons.add(btnDelUrl);
		this.add(panButtons);
		
		// Save Button
		JPanel panSave = new JPanel();
		btnSave = new JButton("Save");
		panSave.add(btnSave);
		this.add(panSave);
		
	}
	
	public void setJButtonSave(ActionListener l){
        this.btnSave.addActionListener(l);
    }
	
	public void setJButtonAddUrlListener(ActionListener l) {
		this.btnAddUrl.addActionListener(l);
	}
	
	public void setJButtonDelUrlListener(ActionListener l) {
		this.btnDelUrl.addActionListener(l);
	}

}
