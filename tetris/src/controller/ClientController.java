package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ClientData;
import model.GameValue;

public class ClientController implements Runnable{
	
	
	private Socket socket;
	
	 // 소켓의 입력스트림을 얻는다.
    InputStream in;
    OutputStream out;
    
    DataOutputStream dos;
    DataInputStream dis;

    ClientData data;
    public ClientController(ClientData data){
    	this.data = data;
    }
	public void run(){
		try{
            String serverIp = "127.0.0.1";
 
            // 소켓을 생성하여 연결을 요청한다.
            System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);
            socket = new Socket(serverIp, 7777);
           
            in = socket.getInputStream();
            out = socket.getOutputStream();

            // 소켓의 입력스트림을 얻는다.
            dis = new DataInputStream(in);
 
            // 소켓으로부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
  
            dos = new DataOutputStream(out);
            dos.writeUTF("USER "+getTime());
            
          
            String msg = dis.readUTF();
            System.out.println(msg);
       
            if("[START]".equals(msg)){
            	
            	dos.writeUTF("[START]");
            	if(GameValue.getUserThreads(0) == null || !GameValue.getUserThreads(0).isAlive()){
        			GameValue.setUserThreads(new Thread(new GameController()),0);
        			GameValue.getUserThreads(0).start();
        		}
            }

           Receiver reciever = new Receiver(socket);
           new Sender(data,socket);
            
           reciever.start();
           

        }catch (Exception e) {
            e.printStackTrace();
        }
	}
	static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + name;
    }
	
}
