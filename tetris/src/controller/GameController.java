package controller;

import java.awt.Color;

import model.GameValue;
import model.PanelToListenerValue;
import model.TetrisConstant;
import view.GamePanel;

public class GameController implements Runnable {

	//자기 자신에 대한 GameController 
	PanelToListenerValue value = PanelToListenerValue.getInstance();
	GamePanel user = GameValue.getUsers(0);
	ValidationController valid = new ValidationController();
	
	public static final int DEFAULT_COL =5;
	public static final int DEFAULT_SPEED =100;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		
		boolean[][] item;
		Color color; 
		
		while(true){
			value.setCol(DEFAULT_COL);
			value.setRandnum(TetrisItemController.getRandNum());
			value.setSpeed(DEFAULT_SPEED);
			
			item = TetrisItemController.getRandomTetrisItem(value.getRandnum())[0];
			color= TetrisItemController.getColor(value.getRandnum());
			
			value.setItem(item);
			
			if(valid.checkTetrisItemHeight(user.getStatue())){
				GameValue.getUserThreads(0).stop();
			}
			
			for(int i=0; i<TetrisConstant.ROWS;i++){

				value.setRow(i);
				
				user.clear();			
				user.drawBlock(i, value.getCol(), item, color);
				
				if(valid.checkBottomSide(item, user.getStatue(), i, value.getCol())){
					//True이면 경계선에 닿았다는 의미임. 
					user.setStatue(item,i,value.getCol(),color);
					break;
				}
				
				try {
					Thread.sleep(value.getSpeed());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
