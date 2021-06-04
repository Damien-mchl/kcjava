package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import kcjava.CheckTime;
import kcjava.Employee;
import kcjava.Planning;
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
    
    public void initView() {
    	//ArrayList<CheckTime> checks = this.model.getCompany().getChecks();
    	//this.view.getTable().setModel((TableModel)checks.get(0));
    }
    
    public void initController() {
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
				}
				
			}
    		
    	});
    	
    }
	
}
