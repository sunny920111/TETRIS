package controller;
import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import model.ClientData;
import model.ServerValue;


public class ServerController {
	ServerSocket serverSocket;
	Socket socket;
 
	
	
    public static void main(String[] args) {
    	new ServerController().start();
    }
 
    public ServerController() {
        try {
            // 서버 소켓을 생성하여 7777번 포트와 바인딩.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " 서버가 준비되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void start(){
    	while(true){
    		try {
				socket = serverSocket.accept();
				 System.out.println(getTime() + " " + socket.getInetAddress()
			                + "로부터 연결요청이 들어왔습니다.");
				new Thread(new ClientThread(socket)).start();
				
				ServerValue.setClientNum(ServerValue.getClientNum()+1);
				
				if(ServerValue.getClientNum() ==1){
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
 
   /* public void start() {
        for (int i = 0; i < threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }
 
    @Override
    public void run() {
    	
    	System.out.println(getTime() + " 가 연결 요청을 기다립니다.");
    	
		try {
			socket = serverSocket.accept();
			 System.out.println(getTime() + " " + socket.getInetAddress()
		                + "로부터 연결요청이 들어왔습니다.");
			 
			 out = socket.getOutputStream();
			 in = socket.getInputStream();
			 dos = new DataOutputStream(out);
			 dis = new DataInputStream(in);
			 
			 
             dos.writeUTF("[Notice] Test Message from Server");
             System.out.println(getTime() + " 데이터를 전송하였습니다.");

             
             clientNum +=dis.readInt();
             System.out.println("클라이언트 수는 "+clientNum+" 명 입니다.");
        
             timer.schedule(new TimerWork(), (long)10000);
             boolean isStart = false;
             while(true){
            	 
            	 if(clientNum ==2){
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
       
    	
   
    }*/
 
    static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + name;
    }

}
