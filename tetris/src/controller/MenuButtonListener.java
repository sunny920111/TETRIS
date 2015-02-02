package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.GameValue;
import model.PanelToListenerValue;
import model.TetrisConstant;

public class MenuButtonListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = ((JButton)e.getSource()).getText();
		
		if(TetrisConstant.START_BTN.equals(id)){
			if(GameValue.getSound() == null || !GameValue.getSound().isAlive()){
				GameValue.setSound(new Thread(new SoundContoller()));
				GameValue.getSound().start();
			}else{
				GameValue.getSound().start();
			}
			
			
			if(GameValue.getUserThreads(0) == null || !GameValue.getUserThreads(0).isAlive()){
				GameValue.setUserThreads(new Thread(new GameController()),0);
				GameValue.getUserThreads(0).start();
			}
			
			
			PanelToListenerValue.setPause(false);
			PanelToListenerValue.setEnd(false);
			((JButton)e.getSource()).setText(TetrisConstant.PAUSE_BTN);
			
		}else if(TetrisConstant.STOP_BTN.equals(id)){
			GameValue.getUserThreads(0).stop();
			GameValue.getUsers(0).allClear();
			GameValue.getHold().allClear();
			GameValue.getQueue().allClear();
			GameValue.getSound().stop();
			PanelToListenerValue.setEnd(true);
			((JButton)GameValue.getMenu().getComponent(0)).setText(TetrisConstant.START_BTN);
		}else if(TetrisConstant.PAUSE_BTN.equals(id)){
			PanelToListenerValue.setPause(true);
			GameValue.getSound().suspend();
			((JButton)e.getSource()).setText(TetrisConstant.RESUME_BTN);
		}else if(TetrisConstant.RESUME_BTN.equals(id)){
			PanelToListenerValue.setPause(false);
			GameValue.getSound().resume();
			((JButton)e.getSource()).setText(TetrisConstant.PAUSE_BTN);
		}
		
		
	}
	
	

}
