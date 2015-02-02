package controller;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import model.GameValue;
import model.PanelToListenerValue;
import model.TetrisConstant;
import view.GamePanel;

public class GameController implements Runnable {

	//자기 자신에 대한 GameController 
	PanelToListenerValue value = PanelToListenerValue.getInstance();
	GamePanel user = GameValue.getUsers(0);
	ValidationController valid = new ValidationController();
	SoundContoller sound = new SoundContoller();
	
	
	private static final int DEFAULT_COL =5;
	private static final int DEFAULT_SPEED =200;
	private static final int DEFAULT_ROTATE_NUM =0;
	private static final int QUEUE_SIZE =2;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean init= false ;
		int[] queueItem = new int[QUEUE_SIZE];
	
	
		boolean[][][] item;
		Color color; 
		
		while(true){
			value.setCol(DEFAULT_COL);
			value.setRandnum(TetrisItemController.getRandNum());
			value.setSpeed(DEFAULT_SPEED);
			value.setRotateNum(DEFAULT_ROTATE_NUM);
			value.setHold(false);
			value.setAlreadyHold(false);
			PanelToListenerValue.setEnd(false);
			
			if(init){
				for(int i=0; i < QUEUE_SIZE; i++){
					queueItem[i] =value.getRandnum();
				}
				init = false;
			}else{
				for(int i=0; i < QUEUE_SIZE-1; i++){
					queueItem[i] = queueItem[i+1];
				}
				queueItem[QUEUE_SIZE-1] =value.getRandnum();
				
			}
			
			GameValue.getQueue().drawHold(TetrisItemController.getRandomTetrisItem(queueItem[1])[value.getRotateNum()], TetrisItemController.getColor(queueItem[1]));
			
			item = TetrisItemController.getRandomTetrisItem(queueItem[0]);
			color= TetrisItemController.getColor(queueItem[0]);
			
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
					
					if(GameValue.getUserNum() >=2){

						GameValue.getClientObj().setTetrisItem(
								value.getItem()[value.getRotateNum()], value.getRow(), value.getCol(), value.getSpeed(),
								value.getColor(),user.getStatue() , user.getColor(),
								PanelToListenerValue.isEnd()
						);
					}
		
					
					break;
				}
				
				
				while(value.isPause()){
					System.out.println("PAUSE");
				}
				
				if(PanelToListenerValue.isEnd()){
					init = true;
					break;
				}
		
				user.removeFullLine();
		
				
				if(GameValue.getUserNum() >=2){

					GameValue.getClientObj().setTetrisItem(
							value.getItem()[value.getRotateNum()], value.getRow(), value.getCol(), value.getSpeed(),
							value.getColor(),user.getStatue() , user.getColor(),
							PanelToListenerValue.isEnd()
					);
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
