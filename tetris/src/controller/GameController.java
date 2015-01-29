package controller;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.GameValue;
import model.PanelToListenerValue;
import model.TetrisConstant;
import view.GamePanel;

public class GameController implements Runnable {

	//자기 자신에 대한 GameController 
	PanelToListenerValue value = PanelToListenerValue.getInstance();
	GamePanel user = GameValue.getUsers(0);
	ValidationController valid = new ValidationController();
	
	private static final int DEFAULT_COL =5;
	private static final int DEFAULT_SPEED =200;
	private static final int DEFAULT_ROTATE_NUM =0;
	@Override
	public void run() {
		// TODO Auto-generated method stub

		
		boolean[][][] item;
		Color color; 
		
		while(true){
			value.setCol(DEFAULT_COL);
			value.setRandnum(TetrisItemController.getRandNum());
			value.setSpeed(DEFAULT_SPEED);
			value.setRotateNum(DEFAULT_ROTATE_NUM);
			value.setHold(false);
			value.setAlreadyHold(false);
			
			item = TetrisItemController.getRandomTetrisItem(value.getRandnum());
			color= TetrisItemController.getColor(value.getRandnum());
			
			value.setItem(item);
			value.setColor(color);
			
			valid.checkTetrisItemHeight(user.getStatue());
		

			
			for(int i=0; i<TetrisConstant.ROWS;i++){
			
				value.setRow(i);
				
				user.clear();			
				user.drawBlock(i, value.getCol(), value.getItem()[value.getRotateNum()], value.getColor());
		
				
				if(value.isHold()){
					break;
				}

				if(valid.checkBottomSide(value.getItem()[value.getRotateNum()], user.getStatue(), i, value.getCol())){
					//True이면 경계선에 닿았다는 의미임. 
					user.setStatue(value.getItem()[value.getRotateNum()],i,value.getCol(),value.getColor());
					break;
				}
				
				
				while(value.isPause()){
					System.out.println("PAUSE");
				}
		
				user.removeFullLine();
				
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
