package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import model.ClientData;
import model.ServerValue;

public class Receiver extends Thread {
	Socket socket;
	
	OutputStream out;
    InputStream in;
    
	DataInputStream dis;
	DataOutputStream dos;

	
	ObjectInputStream ois;
	ObjectOutputStream oos; 
	
	String name; 
	public Receiver(Socket socket){
		this.socket = socket;
		
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run(){
	
		
		try {
			dos.writeUTF("Join in Tetris Game");	
			System.out.println(getTime() + " Send Data To Client From Server");

			
			name =dis.readUTF();
			System.out.println("User Name : "+name);
			
			
			oos = new ObjectOutputStream(out);
			ServerValue.getClients().put(name, oos);
	
			
			/*while(true){
				if(ServerValue.getClients().size() ==2){
					sendToAll("[START]");
					break;
				}
			}*/
			
			ois = new ObjectInputStream(in);
			
			while(ois != null){
				sendToOtherClient((ClientData)ois.readObject());
			}
			
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
	}
	
	public void sendToOtherClient(ClientData data){

		System.out.println("[Receiver] row :"+data.getRow()+","+" col :"+data.getCol());
		Iterator<String> it = ServerValue.getClients().keySet().iterator();
	
		while(it.hasNext()){
			try {
			
				String index = it.next();
				if(!name.equals((String)index)){
					System.out.println((String)index);
					ObjectOutputStream out = ServerValue.getClients().get(index);
					out.writeObject(data);
					out.reset();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void sendToAll(String msg){
		Iterator<String> it = ServerValue.getClients().keySet().iterator();

		while(it.hasNext()){
			try {
				String index = it.next();
				if(!name.equals(index)){
					ObjectOutputStream out = ServerValue.getClients().get(index);
					out.writeObject(msg);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + name;
    }
}
