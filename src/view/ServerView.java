package view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ServerView {
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public ServerView(String title) {
		
        this.frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(400, 250));
        
        this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Checks", null, tabbedPane_1, null);
        
        JPanel panel = new JPanel();
        tabbedPane_1.addTab("All checks", null, panel, null);
        
        table = new JTable();
        panel.add(table);
        
        JPanel panel_1 = new JPanel();
        tabbedPane_1.addTab("Checks of the day", null, panel_1, null);
        
        table_1 = new JTable();
        panel_1.add(table_1);
        
        JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Employees", null, tabbedPane_2, null);
        
        JPanel panel_2 = new JPanel();
        tabbedPane_2.addTab("List", null, panel_2, null);
        
        table_2 = new JTable();
        panel_2.add(table_2);
        
        JPanel panel_3 = new JPanel();
        tabbedPane_2.addTab("New", null, panel_3, null);
        
        JLabel lblNewLabel = new JLabel("ID");
        panel_3.add(lblNewLabel);
        
        textField_2 = new JTextField();
        panel_3.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("First name");
        panel_3.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        panel_3.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Last name");
        panel_3.add(lblNewLabel_2);
        
        textField = new JTextField();
        panel_3.add(textField);
        textField.setColumns(10);
        
        JPanel panel_4 = new JPanel();
        tabbedPane_2.addTab("Modify", null, panel_4, null);
        
        JLabel lblId = new JLabel("ID");
        panel_4.add(lblId);
        
        textField_3 = new JTextField();
        panel_4.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblFirstName = new JLabel("First name");
        panel_4.add(lblFirstName);
        
        textField_4 = new JTextField();
        panel_4.add(textField_4);
        textField_4.setColumns(10);
        
        JLabel lblLastName = new JLabel("Last name");
        panel_4.add(lblLastName);
        
        textField_5 = new JTextField();
        panel_4.add(textField_5);
        textField_5.setColumns(10);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
