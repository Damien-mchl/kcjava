package controller;

import view.*;
import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.*;

public class Controller{
	
	private Model model;
	private View view;
    public Controller(Model m, View v) {
    	this.model = m;
    	this.view = v;
    	initView();
    }
    
    public void initView() {
    	LocalDateTime date = LocalDateTime.now();
        String dispDate = date.getMonth().toString()+" "+date.getDayOfMonth()+", "+date.getYear()+" "+date.getHour()+":"+date.getMinute();
        view.getLabelDate().setText(dispDate);
    }
    
    public void initController() {
    	new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LocalDateTime date = LocalDateTime.now();
                String dispDate = date.getMonth().toString()+" "+date.getDayOfMonth()+", "+date.getYear()+" "+date.getHour()+":"+date.getMinute();
                view.getLabelDate().setText(dispDate);
            }
        }).start();
    }
}
