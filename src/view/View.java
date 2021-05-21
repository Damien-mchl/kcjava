package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.*;
import model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {
	private JFrame frame;
	private JPanel ctrlPane;
	private JLabel labelDate;
	private JSplitPane splitPane;
	private JFormattedTextField textUserId;
	private JButton butCheckinout;
	public View(String title) {
        // Create views swing UI components
		this.labelDate = new JLabel();
		labelDate.setHorizontalAlignment(SwingConstants.CENTER);
 
        // Set the view layout
        this.ctrlPane = new JPanel();
        ctrlPane.setLayout(new BorderLayout(0, 0));
        ctrlPane.add(labelDate, BorderLayout.CENTER);
        

 
        this.frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(400, 250));
        frame.getContentPane().add(ctrlPane);
        
        this.splitPane = new JSplitPane();
        ctrlPane.add(splitPane, BorderLayout.SOUTH);
        this.textUserId = new JFormattedTextField();
        textUserId.setToolTipText("User Id");
        splitPane.setLeftComponent(textUserId);
        textUserId.setColumns(20);
        textUserId.setHorizontalAlignment(SwingConstants.CENTER);
        this.butCheckinout = new JButton("Check in/out");
        splitPane.setRightComponent(butCheckinout);
        butCheckinout.setBackground(Color.GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JPanel getCtrlPane() {
		return ctrlPane;
	}
	public void setCtrlPane(JPanel ctrlPane) {
		this.ctrlPane = ctrlPane;
	}
	public JLabel getLabelDate() {
		return labelDate;
	}
	public void setLabelDate(JLabel labelDate) {
		this.labelDate = labelDate;
	}
	public JSplitPane getSplitPane() {
		return splitPane;
	}
	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}
	public JFormattedTextField getTextUserId() {
		return textUserId;
	}
	public void setTextUserId(JFormattedTextField textUserId) {
		this.textUserId = textUserId;
	}
	public JButton getButCheckinout() {
		return butCheckinout;
	}
	public void setButCheckinout(JButton butCheckinout) {
		this.butCheckinout = butCheckinout;
	}
	
	
}
