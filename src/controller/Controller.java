package controller;

import view.*;
import model.*;
import kcjava.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Controller{
	
	private Model model;
	private View view;
	public static int id;
    public Controller(Model m, View v) {
    	this.model = m;
    	this.view = v;
    	initView();
    }
    
    public void initView() {
    	LocalDateTime date = LocalDateTime.now();
        String dispDate = date.getMonth().toString()+" "+date.getDayOfMonth()+", "+date.getYear()+" "+date.getHour()+":"+date.getMinute();
        view.getLabelDate().setText(dispDate);
        LocalTime roundedTime = CheckTime.roundTime(LocalTime.of(date.getHour(), date.getMinute()));
        String dispRounded = "Let's say "+roundedTime.getHour()+":"+roundedTime.getMinute();
        view.getRoundedTime().setText(dispRounded);
    }
    
    public void initController() {
    	
    	new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LocalDateTime date = LocalDateTime.now();
                String dispDate = date.getMonth().toString()+" "+date.getDayOfMonth()+", "+date.getYear()+" "+date.getHour()+":"+date.getMinute();
                view.getLabelDate().setText(dispDate);
                LocalTime roundedTime = CheckTime.roundTime(LocalTime.of(date.getHour(), date.getMinute()));
                String dispRounded = "Let's say "+roundedTime.getHour()+":"+roundedTime.getMinute();
                view.getRoundedTime().setText(dispRounded);
            }
        }).start();
    	this.view.getButCheckinout().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TCPClient client;
				String ip = view.getIp_textfield().getText();
				int port = Integer.parseInt(view.getPort_textfield().getText());
				CheckTime check = new CheckTime(LocalTime.now(),LocalDate.now(),Integer.parseInt(view.getTextUserId().getText()));
				try {
					client = new TCPClient(check,ip,port);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
    	});
    }
}
