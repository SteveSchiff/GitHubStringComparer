package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class ComparatorWindow {

	private JFrame frame;
	private JTextField sourceTextField;
	private JTextField matchTextField;
	private String matchText = matchTextField.getText();
	private String sourceText = sourceTextField.getText();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparatorWindow window = new ComparatorWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComparatorWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(102, 0, 0));
		frame.getContentPane().setBackground(new Color(51, 255, 0));
		frame.setBounds(100, 100, 530, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel sourceLabel = new JLabel("Source");
		sourceLabel.setBounds(50, 33, 46, 14);
		frame.getContentPane().add(sourceLabel);
		
		sourceTextField = new JTextField();
		sourceTextField.setBackground(new Color(204, 255, 51));
		sourceTextField.setBounds(106, 30, 256, 20);
		frame.getContentPane().add(sourceTextField);
		sourceTextField.setColumns(10);
		
		matchTextField = new JTextField();
		matchTextField.setBackground(new Color(204, 255, 102));
		matchTextField.setBounds(106, 75, 256, 20);
		frame.getContentPane().add(matchTextField);
		matchTextField.setColumns(10);
		
		JLabel matchLabel = new JLabel("Match");
		matchLabel.setBounds(50, 78, 46, 14);
		frame.getContentPane().add(matchLabel);
		
		JButton sourceBrowseButton = new JButton("Browse...");
		sourceBrowseButton.setToolTipText("may not need this button");
		sourceBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		sourceBrowseButton.setBounds(393, 29, 89, 23);
		frame.getContentPane().add(sourceBrowseButton);
		
		JButton matchBrowseButton = new JButton("Browse...");
		matchBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		matchBrowseButton.setToolTipText("may not need this button");
		matchBrowseButton.setBounds(393, 74, 89, 23);
		frame.getContentPane().add(matchBrowseButton);
		
		JButton compareButton = new JButton("Compare");
		compareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(compareStrings(sourceText, matchText)){
					JOptionPane.showMessageDialog(null, "They match!");
				}
				else {
					JOptionPane.showMessageDialog(null, "NOT the same! Beware!");
				}
			}
		});
		compareButton.setBounds(41, 124, 89, 23);
		frame.getContentPane().add(compareButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(153, 0, 0));
		menuBar.setBackground(new Color(153, 204, 102));
		menuBar.setBounds(-4, 0, 518, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(new Color(102, 204, 204));
		menuBar.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
	} // end initialize() method
	
	public boolean compareStrings(String sourceText, String compareText) {
		
		boolean isSame = false;
		isSame = sourceText.equals(matchTextField);
		return isSame;
	}
}
