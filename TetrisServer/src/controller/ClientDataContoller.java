package controller;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.ClientData;


public class ClientDataContoller implements Observer {

	Observable observable;  
	private boolean[][] item;
	private int row;
	private int col;
	private int speed;
	private Color itemColor;
	
	private boolean[][] statue;
	private Color[][] color;
	private boolean isContinue;
	
	public ClientDataContoller(Observable observable){
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
			
			sendData();
		}
	}
	
	public void sendData(){
		
	}

}
