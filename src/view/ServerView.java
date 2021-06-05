package view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpinnerModel;

import kcjava.Sauvegarde;

public class ServerView {
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTextField fieldNewLastName;
	private JTextField fieldNewFirstName;
	private JTextField fieldNewId;
	private JTextField fieldModifId;
	private JSpinner spinner,spinner_1,spinner_2,spinner_3
	,spinner_4,spinner_5,spinner_6,spinner_7,spinner_8,spinner_9
	,spinner_10,spinner_11,spinner_12,spinner_13,spinner_14,spinner_15,
	spinner_16,spinner_17,spinner_18,spinner_19;
	private JButton submitNew,submitModif;
	private JTextField fieldDepartment;
	private JPanel panel,panel_1,panel_2;
	public ServerView(String title) {
		
        this.frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(500, 500));
        
        this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Checks", null, tabbedPane_1, null);
        
        panel = new JPanel();
        tabbedPane_1.addTab("All checks", null, panel, null);
        panel.setLayout(new BorderLayout(0, 0));
        
        panel_1 = new JPanel();
        tabbedPane_1.addTab("Checks of the day", null, panel_1, null);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Employees", null, tabbedPane_2, null);
        
        panel_2 = new JPanel();
        tabbedPane_2.addTab("List", null, panel_2, null);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_3 = new JPanel();
        tabbedPane_2.addTab("New", null, panel_3, null);
        
        JLabel lblidNew = new JLabel("ID");
        panel_3.add(lblidNew);
        
        fieldNewId = new JTextField();
        panel_3.add(fieldNewId);
        fieldNewId.setColumns(10);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_1);
        
        JLabel lblFirstNameNew = new JLabel("First name");
        panel_3.add(lblFirstNameNew);
        
        fieldNewFirstName = new JTextField();
        panel_3.add(fieldNewFirstName);
        fieldNewFirstName.setColumns(10);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_2);
        
        JLabel lblLastNameNew = new JLabel("Last name");
        panel_3.add(lblLastNameNew);
        
        fieldNewLastName = new JTextField();
        panel_3.add(fieldNewLastName);
        fieldNewLastName.setColumns(10);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_3);
        
        JLabel lblDepartment = new JLabel("Department");
        panel_3.add(lblDepartment);
        
        fieldDepartment = new JTextField();
        panel_3.add(fieldDepartment);
        fieldDepartment.setColumns(10);
        
        JSeparator separator_16 = new JSeparator();
        separator_16.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_16);
        
        JLabel lblPlanning = new JLabel("Planning");
        panel_3.add(lblPlanning);
        
        JSeparator separator_4 = new JSeparator();
        separator_4.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_4);
        
        JLabel lblMonday = new JLabel("Monday");
        panel_3.add(lblMonday);
        
        spinner = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, "HH:mm");
        spinner.setEditor(timeEditor);
        spinner.setValue(new Date(2021,6,5,8,0));
        
        JLabel lblTo = new JLabel("to");
        panel_3.add(lblTo);
        
        spinner_1 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_1);
        JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(spinner_1, "HH:mm");
        spinner_1.setEditor(timeEditor1);
        spinner_1.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator);
        
        JLabel lblTuesday = new JLabel("Tuesday");
        panel_3.add(lblTuesday);
        
        spinner_2 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_2);
        JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(spinner_2, "HH:mm");
        spinner_2.setEditor(timeEditor2);
        spinner_2.setValue(new Date(2021,6,5,8,0));
        
        JLabel lblTo_1 = new JLabel("to");
        panel_3.add(lblTo_1);
        
        spinner_3 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_3);
        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(spinner_3, "HH:mm");
        spinner_3.setEditor(timeEditor3);
        spinner_3.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_5 = new JSeparator();
        separator_5.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_5);
        
        JLabel lblWednesday = new JLabel("Wednesday");
        panel_3.add(lblWednesday);
        
        spinner_4 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_4);
        JSpinner.DateEditor timeEditor4 = new JSpinner.DateEditor(spinner_4, "HH:mm");
        spinner_4.setEditor(timeEditor4);
        spinner_4.setValue(new Date(2021,6,5,8,0));
        
        JLabel lblTo_2 = new JLabel("to");
        panel_3.add(lblTo_2);
        
        spinner_5 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_5);
        JSpinner.DateEditor timeEditor5 = new JSpinner.DateEditor(spinner_5, "HH:mm");
        spinner_5.setEditor(timeEditor5);
        spinner_5.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_6 = new JSeparator();
        separator_6.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_6);
        
        JLabel lblThursday = new JLabel("Thursday");
        panel_3.add(lblThursday);
        
        spinner_6 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_6);
        JSpinner.DateEditor timeEditor6 = new JSpinner.DateEditor(spinner_6, "HH:mm");
        spinner_6.setEditor(timeEditor6);
        spinner_6.setValue(new Date(2021,6,5,8,0));
        
        JLabel lblTo_3 = new JLabel("to");
        panel_3.add(lblTo_3);
        
        spinner_7 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_7);
        JSpinner.DateEditor timeEditor7 = new JSpinner.DateEditor(spinner_7, "HH:mm");
        spinner_7.setEditor(timeEditor7);
        spinner_7.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_7 = new JSeparator();
        separator_7.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_7);
        
        JLabel lblFriday = new JLabel("Friday");
        panel_3.add(lblFriday);
        
        spinner_8 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_8);
        JSpinner.DateEditor timeEditor8 = new JSpinner.DateEditor(spinner_8, "HH:mm");
        spinner_8.setEditor(timeEditor8);
        spinner_8.setValue(new Date(2021,6,5,8,0));
        
        JLabel lblTo_4 = new JLabel("to");
        panel_3.add(lblTo_4);
        
        spinner_9 = new JSpinner(new SpinnerDateModel());
        panel_3.add(spinner_9);
        JSpinner.DateEditor timeEditor9 = new JSpinner.DateEditor(spinner_9, "HH:mm");
        spinner_9.setEditor(timeEditor9);
        spinner_9.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_8 = new JSeparator();
        separator_8.setPreferredSize(new Dimension(9000, 0));
        panel_3.add(separator_8);
        
        submitNew = new JButton("Submit");
        panel_3.add(submitNew);
        
        JPanel panel_4 = new JPanel();
        tabbedPane_2.addTab("Modify", null, panel_4, null);
        
        JLabel lblidModif = new JLabel("ID");
        panel_4.add(lblidModif);
        
        fieldModifId = new JTextField();
        panel_4.add(fieldModifId);
        fieldModifId.setColumns(10);
        
        JSeparator separator_9 = new JSeparator();
        separator_9.setPreferredSize(new Dimension(9000, 0));
        panel_4.add(separator_9);
        
        JLabel label = new JLabel("Planning");
        panel_4.add(label);
        
        JSeparator separator_10 = new JSeparator();
        separator_10.setPreferredSize(new Dimension(9000, 0));
        panel_4.add(separator_10);
        
        JLabel label_1 = new JLabel("Monday");
        panel_4.add(label_1);
        
        spinner_10 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_10);
        JSpinner.DateEditor timeEditor10 = new JSpinner.DateEditor(spinner_10, "HH:mm");
        spinner_10.setEditor(timeEditor10);
        spinner_10.setValue(new Date(2021,6,5,8,0));
        
        JLabel label_2 = new JLabel("to");
        panel_4.add(label_2);
        
        spinner_11 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_11);
        JSpinner.DateEditor timeEditor11 = new JSpinner.DateEditor(spinner_11, "HH:mm");
        spinner_11.setEditor(timeEditor11);
        spinner_11.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_11 = new JSeparator();
        separator_11.setPreferredSize(new Dimension(9000, 0));
        panel_4.add(separator_11);
        
        JLabel label_3 = new JLabel("Tuesday");
        panel_4.add(label_3);
        
        spinner_12 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_12);
        JSpinner.DateEditor timeEditor12 = new JSpinner.DateEditor(spinner_12, "HH:mm");
        spinner_12.setEditor(timeEditor12);
        spinner_12.setValue(new Date(2021,6,5,8,0));
        
        JLabel label_4 = new JLabel("to");
        panel_4.add(label_4);
        
        spinner_13 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_13);
        JSpinner.DateEditor timeEditor13 = new JSpinner.DateEditor(spinner_13, "HH:mm");
        spinner_13.setEditor(timeEditor13);
        spinner_13.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_12 = new JSeparator();
        separator_12.setPreferredSize(new Dimension(9000, 0));
        panel_4.add(separator_12);
        
        
        JLabel label_5 = new JLabel("Wednesday");
        panel_4.add(label_5);
        
        spinner_14 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_14);
        JSpinner.DateEditor timeEditor14 = new JSpinner.DateEditor(spinner_14, "HH:mm");
        spinner_14.setEditor(timeEditor14);
        spinner_14.setValue(new Date(2021,6,5,8,0));
        
        JLabel label_6 = new JLabel("to");
        panel_4.add(label_6);
        
        spinner_15 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_15);
        JSpinner.DateEditor timeEditor15 = new JSpinner.DateEditor(spinner_15, "HH:mm");
        spinner_15.setEditor(timeEditor15);
        spinner_15.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_13 = new JSeparator();
        separator_13.setPreferredSize(new Dimension(9000, 0));
        panel_4.add(separator_13);
        
        JLabel label_7 = new JLabel("Thursday");
        panel_4.add(label_7);
        
        spinner_16 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_16);
        JSpinner.DateEditor timeEditor16 = new JSpinner.DateEditor(spinner_16, "HH:mm");
        spinner_16.setEditor(timeEditor16);
        spinner_16.setValue(new Date(2021,6,5,8,0));
        
        JLabel label_8 = new JLabel("to");
        panel_4.add(label_8);
        
        spinner_17 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_17);
        JSpinner.DateEditor timeEditor17 = new JSpinner.DateEditor(spinner_17, "HH:mm");
        spinner_17.setEditor(timeEditor17);
        spinner_17.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_14 = new JSeparator();
        separator_14.setPreferredSize(new Dimension(9000, 0));
        panel_4.add(separator_14);
        
        JLabel label_9 = new JLabel("Friday");
        panel_4.add(label_9);
        
        spinner_18 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_18);
        JSpinner.DateEditor timeEditor18 = new JSpinner.DateEditor(spinner_18, "HH:mm");
        spinner_18.setEditor(timeEditor18);
        spinner_18.setValue(new Date(2021,6,5,8,0));
        
        JLabel label_10 = new JLabel("to");
        panel_4.add(label_10);
        
        spinner_19 = new JSpinner(new SpinnerDateModel());
        panel_4.add(spinner_19);
        JSpinner.DateEditor timeEditor19 = new JSpinner.DateEditor(spinner_19, "HH:mm");
        spinner_19.setEditor(timeEditor19);
        spinner_19.setValue(new Date(2021,6,5,17,0));
        
        JSeparator separator_15 = new JSeparator();
        separator_15.setPreferredSize(new Dimension(9000, 0));
        panel_4.add(separator_15);
        
        submitModif = new JButton("Submit");
        panel_4.add(submitModif);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	public JPanel getPanel() {
		return panel;
	}
	public JPanel getPanel_1() {
		return panel_1;
	}
	public JPanel getPanel_2() {
		return panel_2;
	}
	public JTextField getFieldDepartment() {
		return fieldDepartment;
	}
	public JButton getSubmitNew() {
		return submitNew;
	}
	public JButton getSubmitModif() {
		return submitModif;
	}
	public JSpinner getSpinner() {
		return spinner;
	}
	public JSpinner getSpinner_1() {
		return spinner_1;
	}
	public JSpinner getSpinner_2() {
		return spinner_2;
	}
	public JSpinner getSpinner_3() {
		return spinner_3;
	}
	public JSpinner getSpinner_4() {
		return spinner_4;
	}
	public JSpinner getSpinner_5() {
		return spinner_5;
	}
	public JSpinner getSpinner_6() {
		return spinner_6;
	}
	public JSpinner getSpinner_7() {
		return spinner_7;
	}
	public JSpinner getSpinner_8() {
		return spinner_8;
	}
	public JSpinner getSpinner_9() {
		return spinner_9;
	}
	public JSpinner getSpinner_10() {
		return spinner_10;
	}
	public JSpinner getSpinner_11() {
		return spinner_11;
	}
	public JSpinner getSpinner_12() {
		return spinner_12;
	}
	public JSpinner getSpinner_13() {
		return spinner_13;
	}
	public JSpinner getSpinner_14() {
		return spinner_14;
	}
	public JSpinner getSpinner_15() {
		return spinner_15;
	}
	public JSpinner getSpinner_16() {
		return spinner_16;
	}
	public JSpinner getSpinner_17() {
		return spinner_17;
	}
	public JSpinner getSpinner_18() {
		return spinner_18;
	}
	public JSpinner getSpinner_19() {
		return spinner_19;
	}
	public JTextField getFieldNewLastName() {
		return fieldNewLastName;
	}
	public JTextField getFieldNewFirstName() {
		return fieldNewFirstName;
	}
	public JTextField getFieldNewId() {
		return fieldNewId;
	}
	public JTextField getFieldModifId() {
		return fieldModifId;
	}
	public JFrame getFrame() {
		return frame;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public JTextField getTextField() {
		return fieldNewLastName;
	}
	public JTextField getTextField_1() {
		return fieldNewFirstName;
	}
	public JTextField getTextField_2() {
		return fieldNewId;
	}
	public JTextField getTextField_3() {
		return fieldModifId;
	}
	
}
