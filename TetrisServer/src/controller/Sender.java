package controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;

import model.ServerValue;

public class Sender extends Thread {
	
	Socket socket;
	ObjectOutputStream oos;
	
	ServerValue value = ServerValue.getInstance();
	
	public Sender(Socket socket){
		this.socket = socket;
		
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(ServerValue.getClients().size()==2){
				sendToAll("[START]");
			}
		}
	}
	
	public void sendToAll(String msg){
		Iterator<String> it = ServerValue.getClients().keySet().iterator();

		int i=0;
		while(it.hasNext()){
			try {
				String index = it.next();
				if(!value.getUserName(i).equals(index)){
					ObjectOutputStream out = ServerValue.getClients().get(index);
					out.writeObject(msg);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
	}

}
