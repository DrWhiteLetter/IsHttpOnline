package view;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PreferencesView extends JFrame {

	private static final long serialVersionUID = 1L;  
	
	public JTextArea txtWebItems;
	public JButton btnSave;
	
	public PreferencesView() {
		this.initForm();
	}
	
	private void initForm () {
		this.setBounds(500, 200, 400, 200);
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
		
		// Website Items
		JPanel panWebItems = new JPanel();
		txtWebItems = new JTextArea(5,20);
		txtWebItems.setMargin(new Insets(10,10,10,10));
		JLabel lblWebItems = new JLabel("Websites:\r\n");
		panWebItems.add(lblWebItems);
		panWebItems.add(txtWebItems);
		this.add(panWebItems);
		
		// Save Button
		JPanel panSave = new JPanel();
		btnSave = new JButton("Save");
		panSave.add(btnSave);
		this.add(panSave);
		
	}
	
	public void setJButtonSave(ActionListener l){
        this.btnSave.addActionListener(l);
    }

}
