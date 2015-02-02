package controller;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.ClientData;
import model.GameValue;
import model.TetrisConstant;
import view.GamePanel;

public class OtherClientController implements Observer {
	Observable observable;  
	private boolean[][] item;
	private int row;
	private int col;
	private int speed;
	private Color itemColor;
	
	private boolean[][] statue;
	private Color[][] color;
	private boolean isContinue;

	ClientData otherUserData;
	GamePanel user = GameValue.getUsers(1);

	
	public OtherClientController( Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	@Override
	public void update(Observable obs, Object arg) {

		// TODO Auto-generated method stub
		if(obs instanceof ClientData){

			ClientData data =  (ClientData)obs;
			this.item = data.getItem();
			this.itemColor = data.getItemColor();
			this.row = data.getRow();
			this.col = data.getCol();
			this.speed = data.getSpeed();
			
			this.statue = data.getStatue();
			this.color = data.getColor();
			this.isContinue = data.isContinue();
		
			drawOtherUserPanel();
		}
	}
	
	public void drawOtherUserPanel(){		
		
		
	 	user.setStatue(statue);
	 	user.setColor(color);	
		user.clear();	
	 	user.drawBlock(row, col, item, itemColor);
		
	}
	
	

}
