package com.bina.gui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;


public class MainFrame extends JFrame {
	public MainFrame() {
	}
	public void init() {
		//initiate frame parameters
		JFrame frame = new JFrame("Bina2022");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setPreferredSize(new Dimension(640, 480));

		//Declaring the columns list component				
		JList compJlst = new JList();
		ArrayList<JLabel> heshbonotLblArr = new ArrayList<JLabel>(); 
		ArrayList<JTextField> heshbonotTxtFieldArr = new ArrayList<JTextField>(); 
		compJlst.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Vector<String> strVect = new Vector<String>();
		JTextField columnTextField = new JTextField(26);
		//setting the orientation to RTL
		columnTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JButton addButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//populating the JList
				strVect.add(columnTextField.getText());	
				String[] strArr = new String[strVect.size()];
				strArr = strVect.toArray(strArr);
				compJlst.setListData(strArr);
				//populating the labels Collection
				JLabel heshLbl = new JLabel(columnTextField.getText());
				JTextField heshbonitText = new JTextField(20);
				//preventing the JTextField from streching . 
				heshbonitText.setMaximumSize( heshbonitText.getPreferredSize() );
				heshbonotLblArr.add(heshLbl); 
				heshbonotTxtFieldArr.add(heshbonitText);
				//clearing the Text Field
				columnTextField.setText("");
			}
		});
		//Creating Panel for the "עריכת שדות" table 
		JPanel ctrlPane = new JPanel();
		ctrlPane.add(columnTextField);
		ctrlPane.add(addButton);
		JScrollPane jScrollPane = new JScrollPane(compJlst);
//		jScrollPane.setPreferredSize(new Dimension(700, 182));
		jScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "טבלת חשבונות ראשית - עריכת שדות",
				TitledBorder.CENTER, TitledBorder.TOP));
		JPanel tableStructurpanel = new JPanel(new BorderLayout());
		tableStructurpanel.add(ctrlPane, BorderLayout.CENTER);
		tableStructurpanel.add(jScrollPane, BorderLayout.SOUTH);


		//Creating Panel for the "וח  חשבונות" table 
		JTable table = new JTable();
		JScrollPane tableScrollPane = new JScrollPane(table);
//		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "דוח  חשבונות",
				TitledBorder.CENTER, TitledBorder.TOP));


		//Creating the "Heshbonot" panel
		JPanel HeshbonotPanel = new JPanel();
		// Set the BoxLayout to be Y_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(HeshbonotPanel, BoxLayout.Y_AXIS);
		// Set the Boxayout to be Y_AXIS from top to down
		//BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		HeshbonotPanel.setLayout(boxlayout);


		JPanel Buttonspanel = new JPanel(new FlowLayout(100,100,100));
		//Creating the Main Buttons navigating panel 
		JButton leftButton = new JButton("ערוך עמודות בטבלה");
		leftButton.setPreferredSize(new Dimension(100, 100));
		Buttonspanel.add(leftButton);
		JButton centerButton = new JButton("חשבונות");
		centerButton.setPreferredSize(new Dimension(100, 100));
		Buttonspanel.add(centerButton);
		JButton rightButton = new JButton("דוח חשבונות");
		rightButton.setPreferredSize(new Dimension(100, 100));
		Buttonspanel.add(rightButton);


		frame.getContentPane().add(Buttonspanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);


		//listener to the left Button
		leftButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.getContentPane().removeAll();
				frame.setVisible(false);
				frame.getContentPane().add(tableStructurpanel);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});

		//		JPanel lblTextTempPanel = new JPanel();
		//listener to the center leftButton 
		centerButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				//populating HeshbonotPanel
				for(int i=0,j=0;i<heshbonotTxtFieldArr.size();i++,j++){

					HeshbonotPanel.add(heshbonotLblArr.get(j));
					heshbonotTxtFieldArr.get(i).setText("temporary");
					HeshbonotPanel.add(heshbonotTxtFieldArr.get(i));
					//				
					//					lblTextTempPanel.add(heshbonotLblArr.get(j));
					//					heshbonotTxtFieldArr.get(i).setText("temporary");
					//					lblTextTempPanel.add(heshbonotTxtFieldArr.get(i));
					//					HeshbonotPanel.add(lblTextTempPanel);


				}
				frame.getContentPane().removeAll();
				frame.setVisible(false);
				frame.getContentPane().add(HeshbonotPanel);
//				frame.setPreferredSize(new Dimension(640, 480));
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);


			}
		});
		//listener to the center leftButton
		rightButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
//				
			}
		});


		//Adding listener upon closing window event
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, 
						"Are you sure you want to close this window?", "Close Window?", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){

					frame.getContentPane().removeAll();
					frame.setVisible(false);
					frame.getContentPane().add(Buttonspanel);
					frame.setVisible(true);
				}
			}
		});
	}
}


