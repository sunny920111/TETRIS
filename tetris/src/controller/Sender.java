package controller;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import model.ClientData;
import model.TetrisConstant;

public class Sender implements Observer {
	
	Observable observable;  
	private boolean[][] item;
	private int row;
	private int col;
	private int speed;
	private Color itemColor;
	
	private boolean[][] statue;
	private Color[][] color;
	private boolean isContinue;

	ClientData dataToServer;
	
	ObjectOutputStream oos;
	Socket socket;  
	
	public Sender( Observable observable,Socket socket){
		this.observable = observable;
		observable.addObserver(this);
		
		this.socket = socket;
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
			sendToServer();
		}
	}

	public void sendToServer(){
		
		dataToServer = new ClientData(item,row,col,speed,itemColor,statue,color,isContinue);
	
		
		System.out.println("------------------------------------------------------");
		for(int i=0; i< 25;i++){
			for(int j=0; j<12;j++){
				System.out.print(dataToServer.getStatue()[i][j]+" ");
			}
			System.out.println("");
		}
		try {
			oos.writeObject(dataToServer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
