package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.*;
import model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {
	public View() {
        // Create views swing UI components
		JLabel date = new JLabel("Date et heure");
		date.setHorizontalAlignment(SwingConstants.CENTER);
 
        // Set the view layout
        JPanel ctrlPane = new JPanel();
        ctrlPane.setLayout(new BorderLayout(0, 0));
        ctrlPane.add(date, BorderLayout.CENTER);
        

 
        JFrame frame = new JFrame("Time tracker emulator - V1.4");
        frame.setPreferredSize(new Dimension(400, 250));
        frame.getContentPane().add(ctrlPane);
        
        JSplitPane splitPane = new JSplitPane();
        ctrlPane.add(splitPane, BorderLayout.SOUTH);
        JFormattedTextField userId = new JFormattedTextField();
        userId.setToolTipText("User Id");
        splitPane.setLeftComponent(userId);
        userId.setColumns(20);
        userId.setHorizontalAlignment(SwingConstants.CENTER);
        JButton checkinout = new JButton("Check in/out");
        splitPane.setRightComponent(checkinout);
        checkinout.setBackground(Color.GRAY);
        checkinout.addActionListener(new Controller());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
