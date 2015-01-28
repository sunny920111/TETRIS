package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.GameValue;
import model.TetrisConstant;

public class MenuButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = ((JButton)e.getSource()).getText();
		
		if(TetrisConstant.START_BTN.equals(id)){
			
			if(GameValue.getUserThreads(0) == null || !GameValue.getUserThreads(0).isAlive()){
				GameValue.setUserThreads(new Thread(new GameController()),0);
				GameValue.getUserThreads(0).start();
			}
		}
		
		
	}

}
