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
			try {
				ClientData data = (ClientData)ois.readObject();
				GameValue.getServerToClient().setTetrisItem(data.getItem(), data.getRow(), data.getCol(), data.getSpeed(), data.getItemColor(), data.getStatue(), data.getColor(), data.isContinue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
