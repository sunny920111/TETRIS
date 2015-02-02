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
			dos.writeUTF("[Notice] Test Message from Server");	
			System.out.println(getTime() + " 데이터를 전송하였습니다.");

			
			name =dis.readUTF();
			System.out.println("User Name : "+name);
			
			
			oos = new ObjectOutputStream(out);
			ServerValue.getClients().put(name, oos);
			/*dos = new DataOutputStream(out);
			ServerValue.getTempClienets().put(name, dos);
			
			while(true){
				System.out.println(ServerValue.getClients().size()+"명이 접속하였습니다.");
				if(ServerValue.getClients().size() ==2){
					sendToAll("[START]");
					break;
				}
			}
			String msg = dis.readUTF();
		
			while(true){
				if("[START]".equals(msg)){
					break;
				}
			}
		*/
			ois = new ObjectInputStream(in);
			
			while(ois != null){
				sendToAll((ClientData)ois.readObject());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}finally{
	
		}
		
	}
	
	public void sendToAll(ClientData data){
		
		System.out.println("------------------------------------------------------");
		for(int i=0; i< 25;i++){
			for(int j=0; j<12;j++){
				System.out.print(data.getStatue()[i][j]+" ");
			}
			System.out.println("");
		}
		Iterator<String> it = ServerValue.getClients().keySet().iterator();
	
		while(it.hasNext()){
			try {
			
				String index = it.next();
				if(!name.equals((String)index)){
					ObjectOutputStream out = ServerValue.getClients().get(index);
					out.writeObject(data);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void sendToAll(String msg){
		Iterator<String> it = ServerValue.getTempClienets().keySet().iterator();

		while(it.hasNext()){
			try {
			
				String index = it.next();
				System.out.println(msg);
				DataOutputStream out = ServerValue.getTempClienets().get(index);
				out.writeUTF(msg);
				
				
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
