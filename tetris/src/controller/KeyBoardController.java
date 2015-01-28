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
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getID() == KeyEvent.KEY_PRESSED){ //Key¸¦ ´­·¶À»¶§ event 
			
			if(e.getKeyCode() == TetrisConstant.KEY_LEFT){
				
				/*if(!valid.checkLeftSide(value.getItem(), user.getStatue(), value.getRow(), value.getCol())){
					value.setCol(value.getCol()-1);
				}*/
				
				value.setCol(value.getCol()-1);

			}else if(e.getKeyCode() == TetrisConstant.KEY_RIGHT){
				
				/*if(!valid.checkRightSide(value.getItem(), user.getStatue(), value.getRow(), value.getCol()+1)){
					value.setCol(value.getCol()+1);
				}*/
				
				value.setCol(value.getCol()+1);
			}
			
			
		}else{
			
		}
		return false;
	}

}
