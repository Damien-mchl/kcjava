package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import kcjava.CheckTime;
import kcjava.Employee;
import kcjava.ExceptionSauvegarde;
import kcjava.Planning;
import kcjava.Sauvegarde;
import kcjava.TCPServer;
import model.ServerModel;
import view.ServerView;

public class ServerController {
	
	private ServerModel model;
	private ServerView view;
    public ServerController(ServerModel m, ServerView v){
    	this.model = m;
    	this.view = v;
    	initView();
    }
    
    public void refreshCheckTables() {
    	view.getPanel().removeAll();
    	ArrayList<CheckTime> checks = this.model.getCompany().getChecks();
    	Object[][] checksTab = new Object[checks.size()][3];
    	for(int i=0; i<checks.size(); i++) {
    		checksTab[i][0] = checks.get(i).getId();
    		checksTab[i][1] = checks.get(i).dateToString();
    		checksTab[i][2] = checks.get(i).hourToString();
    	}
    	String[] header = {"ID","Date","Time"};
    	JTable checkTable = new JTable(checksTab,header);
    	view.getPanel().add(checkTable.getTableHeader(),BorderLayout.NORTH);
    	view.getPanel().add(checkTable, BorderLayout.CENTER);
    	
    	
    	view.getPanel_1().removeAll();
    	ArrayList<CheckTime> checksOfDay = this.model.getCompany().getDailyChecks();
    	Object[][] checksOfDayTab = new Object[checksOfDay.size()][3];
    	for(int i=0; i<checksOfDay.size(); i++) {
    		checksOfDayTab[i][0] = checksOfDay.get(i).getId();
    		checksOfDayTab[i][1] = checksOfDay.get(i).dateToString();
    		checksOfDayTab[i][2] = checksOfDay.get(i).hourToString();
    	}
    	String[] header3 = {"ID","Date","Time"};
    	JTable checkOfDayTable = new JTable(checksOfDayTab,header3);
    	view.getPanel_1().add(checkOfDayTable.getTableHeader(),BorderLayout.NORTH);
    	view.getPanel_1().add(checkOfDayTable, BorderLayout.CENTER);
    }
    
    public void refreshEmployeesTable() {
    	view.getPanel_2().removeAll();
    	ArrayList<Employee> employees = this.model.getCompany().getAllEmployees();
    	Object[][] employeesTab = new Object[employees.size()][4];
    	for(int i=0; i<employees.size(); i++) {
    		employeesTab[i][0] = employees.get(i).getId();
    		employeesTab[i][1] = employees.get(i).getLastName();
    		employeesTab[i][2] = employees.get(i).getFirstName();
    		employeesTab[i][3] = employees.get(i).getStockH();
    	}
    	
    	
    	String[] header2 = {"ID","Last Name","First Name","Extra hours"};
    	
    	JTable checkTable2 = new JTable(employeesTab,header2);
    	view.getPanel_2().add(checkTable2.getTableHeader(),BorderLayout.NORTH);
    	view.getPanel_2().add(checkTable2, BorderLayout.CENTER);
    }
    
    public void initView() {
    	refreshCheckTables();
    	refreshEmployeesTable();
    }
    
    public void initController() {
    	this.view.getFrame().addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	try {
					Sauvegarde.sauvegarderCompany(model.getCompany(), TCPServer.savePath);
				} catch (ExceptionSauvegarde e1) {
					
				}
                System.exit(0);
            }
        });
    	this.view.getSubmitNew().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!view.getFieldNewId().getText().isEmpty() && !view.getFieldDepartment().getText().isEmpty() && !view.getFieldNewFirstName().getText().isEmpty() && !view.getFieldNewLastName().getText().isEmpty()) {
					int id = Integer.parseInt(view.getFieldNewId().getText());
					
					LocalTime[] arrivals = new LocalTime[5];
					String[] splittedTime = view.getSpinner().getValue().toString().substring(11,19).split(":");
					arrivals[0]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_2().getValue().toString().substring(11,19).split(":");
					arrivals[1]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_4().getValue().toString().substring(11,19).split(":");
					arrivals[2]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_6().getValue().toString().substring(11,19).split(":");
					arrivals[3]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_8().getValue().toString().substring(11,19).split(":");
					arrivals[4]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					
					LocalTime[] departures = new LocalTime[5];
					splittedTime = view.getSpinner_1().getValue().toString().substring(11,19).split(":");
					departures[0]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_3().getValue().toString().substring(11,19).split(":");
					departures[1]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_5().getValue().toString().substring(11,19).split(":");
					departures[2]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_7().getValue().toString().substring(11,19).split(":");
					departures[3]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_9().getValue().toString().substring(11,19).split(":");
					departures[4]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					
					String lastName = view.getFieldNewLastName().getText();
					String firstName = view.getFieldNewFirstName().getText();
					String department = view.getFieldDepartment().getText();
					model.getCompany().addEmployee(new Employee(id,lastName,firstName,new Planning(arrivals, departures),0), department);
					refreshEmployeesTable();
				}
			}
    		
    	});
    	this.view.getSubmitModif().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!view.getFieldModifId().getText().isEmpty()) {
					int id = Integer.parseInt(view.getFieldModifId().getText());
					
					
					LocalTime[] arrivals = new LocalTime[5];
					String[] splittedTime = view.getSpinner_10().getValue().toString().substring(11,19).split(":");
					arrivals[0]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_12().getValue().toString().substring(11,19).split(":");
					arrivals[1]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_14().getValue().toString().substring(11,19).split(":");
					arrivals[2]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_16().getValue().toString().substring(11,19).split(":");
					arrivals[3]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_18().getValue().toString().substring(11,19).split(":");
					arrivals[4]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					
					LocalTime[] departures = new LocalTime[5];
					splittedTime = view.getSpinner_11().getValue().toString().substring(11,19).split(":");
					departures[0]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_13().getValue().toString().substring(11,19).split(":");
					departures[1]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_15().getValue().toString().substring(11,19).split(":");
					departures[2]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_17().getValue().toString().substring(11,19).split(":");
					departures[3]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					splittedTime = view.getSpinner_19().getValue().toString().substring(11,19).split(":");
					departures[4]=CheckTime.roundTime(LocalTime.of(Integer.parseInt(splittedTime[0]),Integer.parseInt(splittedTime[1])));
					
					model.getCompany().modifyEmployee(id, new Planning(arrivals, departures));
					refreshEmployeesTable();
				}
				
			}
    		
    	});
    	
    }
	
}
