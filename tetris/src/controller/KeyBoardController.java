package controller;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import view.GamePanel;
import model.GameValue;
import model.PanelToListenerValue;
import model.TetrisConstant;

public class KeyBoardController implements KeyEventDispatcher {

	ValidationController valid = new ValidationController();
	PanelToListenerValue value = PanelToListenerValue.getInstance();
	GamePanel user = GameValue.getUsers(0);
	
	private static final int DOWN_SPEED =50;
	private static final int DEFAULT_SPEED =100;
	private static final int SPACE_SPEED =5;
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getID() == KeyEvent.KEY_PRESSED){ //Key¸¦ ´­·¶À»¶§ event 
			
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
