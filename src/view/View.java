package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.*;
import model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;

public class View {
	private JFrame frame;
	private JPanel ctrlPane;
	private JSplitPane splitPane;
	private JFormattedTextField textUserId;
	private JButton butCheckinout;
	private JPanel timePanel;
	private JLabel labelDate;
	private JLabel roundedTime;
	public View(String title) {
 
        // Set the view layout
        this.ctrlPane = new JPanel();
        ctrlPane.setLayout(new BorderLayout(10, 10));
        

 
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
        
        this.timePanel = new JPanel();
        ctrlPane.add(timePanel, BorderLayout.CENTER);
        
        this.labelDate = new JLabel();
        labelDate.setHorizontalAlignment(SwingConstants.CENTER);
        labelDate.setFont(new Font("Arial",Font.BOLD,20));
        
        this.roundedTime = new JLabel("");
        timePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));
        timePanel.add(labelDate);
        timePanel.add(roundedTime);
		// Create views swing UI components
		
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
	public JPanel getTimePanel() {
		return timePanel;
	}
	public void setTimePanel(JPanel timePanel) {
		this.timePanel = timePanel;
	}
	public JLabel getRoundedTime() {
		return roundedTime;
	}
	public void setRoundedTime(JLabel roundedTime) {
		this.roundedTime = roundedTime;
	}
	
	
}
