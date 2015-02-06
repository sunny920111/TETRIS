package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import model.ClientData;
import model.GameValue;

public class Receiver extends Thread {
	Socket socket;
	ObjectInputStream ois;
	 
	public Receiver(Socket socket){
	
		this.socket = socket;
		
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new OtherClientController(GameValue.getServerToClient());
	}
	
	public void run(){

		while(ois != null){
			
			Object input = null;
			try {
				input = ois.readObject();
				if(input instanceof String ){
					/*System.out.println((String)input);
					if("[START]".equals((String)input)){
						if(GameValue.getUserThreads(0) == null || !GameValue.getUserThreads(0).isAlive()){
							GameValue.setUserThreads(new Thread(new GameController()),0);
							GameValue.getUserThreads(0).start();
						}else{
							GameValue.getUserThreads(0).start();
						}
						
					}*/
	
				}else if(input instanceof ClientData){
					ClientData data = (ClientData)input;
					GameValue.getServerToClient().setTetrisItem(data.getItem(), data.getRow(), data.getCol(), data.getSpeed(), data.getItemColor(), data.getStatue(), data.getColor(), data.isContinue());
					System.out.println("[Receiver] row :"+data.getRow()+","+" col :"+data.getCol());
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}
}
