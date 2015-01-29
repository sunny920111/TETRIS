package controller;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import model.GameValue;
import model.PanelToListenerValue;
import model.TetrisConstant;
import view.GamePanel;
import view.MenuPanel;

public class KeyBoardController implements KeyEventDispatcher {

	ValidationController valid = new ValidationController();
	PanelToListenerValue value = PanelToListenerValue.getInstance();
	GamePanel user = GameValue.getUsers(0);
	MenuPanel menu = GameValue.getMenu();
	
	private static final int DOWN_SPEED =50;
	private static final int DEFAULT_SPEED =180;
	private static final int SPACE_SPEED =5;
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getID() == KeyEvent.KEY_PRESSED){ //Key를 눌렀을때 event 
			
			if(e.getKeyCode() == TetrisConstant.KEY_LEFT){
				
				if(!valid.checkLeftSide(value.getItem()[value.getRotateNum()], user.getStatue(), value.getRow(), value.getCol())){
					if(!valid.checkBottomSide(value.getItem()[value.getRotateNum()], user.getStatue(), value.getRow(), value.getCol())){
						value.setCol(value.getCol()-1);
					}
				}
	
			}else if(e.getKeyCode() == TetrisConstant.KEY_RIGHT){
				if(!valid.checkRightSide(value.getItem()[value.getRotateNum()], user.getStatue(), value.getRow(), value.getCol())){
					if(!valid.checkBottomSide(value.getItem()[value.getRotateNum()], user.getStatue(), value.getRow(), value.getCol())){
						value.setCol(value.getCol()+1);
					}
				}

			}else if(e.getKeyCode() == TetrisConstant.KEY_DOWN){
				value.setSpeed(DOWN_SPEED);
			}else if(e.getKeyCode() == TetrisConstant.KEY_HOLD){
				
				
				if(value.getHoldItem() == null){ // 이미 홀드한적이 있다
					value.setHoldItem(value.getItem());
					value.setHoldColor(value.getColor());
					value.setHold(true);
					GameValue.getHold().drawHold(value.getHoldItem()[0], value.getHoldColor());
				}else{
					if(!value.isAlreadyHold()){
						
						if(!valid.checkLeftSide(value.getHoldItem()[(value.getRotateNum()+1)%4], user.getStatue(), value.getRow(), value.getCol())){
							if(!valid.checkRightSide(value.getHoldItem()[(value.getRotateNum()+1)%4], user.getStatue(), value.getRow(), value.getCol())){
								if(!valid.checkBottomSide(value.getHoldItem()[(value.getRotateNum()+1)%4], user.getStatue(), value.getRow(), value.getCol())){
									boolean[][][] temp = value.getItem();
									Color tempColor = value.getColor();
									value.setItem(value.getHoldItem());
									value.setColor(value.getHoldColor());
									value.setHoldItem(temp);
									value.setHoldColor(tempColor);
									GameValue.getHold().drawHold(value.getHoldItem()[0], value.getHoldColor());
									value.setAlreadyHold(true);
								}
							}
						}
						
					}
				}
				
			
				
			}else if(e.getKeyCode() == TetrisConstant.KEY_UP){
				if(!valid.checkLeftSide(value.getItem()[(value.getRotateNum()+1)%4], user.getStatue(), value.getRow(), value.getCol())){
					if(!valid.checkRightSide(value.getItem()[(value.getRotateNum()+1)%4], user.getStatue(), value.getRow(), value.getCol())){
						if(!valid.checkBottomSide(value.getItem()[(value.getRotateNum()+1)%4], user.getStatue(), value.getRow(), value.getCol())){
							value.setRotateNum((value.getRotateNum()+1)%4);
					 	}
					}				
				}
				
				
			}else if(e.getKeyCode() == TetrisConstant.KEY_SPACE){
				value.setSpeed(SPACE_SPEED);
			}
			
			
		}else if(e.getID() == KeyEvent.KEY_RELEASED){
			 if(e.getKeyCode() == TetrisConstant.KEY_DOWN){
				 value.setSpeed(DEFAULT_SPEED);
			 }
		}
		return false;
	}

}
