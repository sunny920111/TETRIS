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
import java.util.Timer;

import model.ClientData;
import model.ServerValue;


public class ClientThread implements Runnable {

	Socket socket;
	
	OutputStream out;
    InputStream in;
    
    DataOutputStream dos;
    DataInputStream dis;
    
    ObjectInputStream ois; 
	ObjectOutputStream oos;
	
	Timer timer = new Timer();
	
	ClientDataContoller cdc = new ClientDataContoller(new ClientData());
	
	public ClientThread(Socket socket){
		this.socket = socket;
	
		try {
			out = socket.getOutputStream();
			in = socket.getInputStream();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		dos = new DataOutputStream(out);
		dis = new DataInputStream(in);
		
		try {
			dos.writeUTF("[Notice] Test Message from Server");
			System.out.println(getTime() + " 데이터를 전송하였습니다.");
		
			 timer.schedule(new TimerWork(), (long)10000);
			 boolean isStart = false;
			 
			 while(true){
            	 
            	 if(ServerValue.getClientNum() ==1){
            		 System.out.println("Client Full");
            		 dos.writeUTF("[START]");
            		 timer.cancel();
            		 isStart = true;
            		 ois = new ObjectInputStream(in);
            		 System.out.println("GameStart");
            		 break;
            	 }
            	 
            	
            	 if(!ServerValue.isWait()){
            		 System.out.println("Time Over");
            		 break;
            	 }
             }
			 
			 while(isStart){
            	 try { 
            		Object obj = (Object)ois.readObject();
            		ClientData temp = (ClientData) obj;
            		System.out.println("ROW : "+temp.getRow()+", COL :"+temp.getCol());
            	
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
			 
			 System.out.println("Server가 종료됩니다");
             dos.writeUTF("[END]");
             
             dos.close();
             dis.close();
             socket.close();
             System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + name;
    }

}
