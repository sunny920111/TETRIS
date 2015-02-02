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
	
	 // ������ �Է½�Ʈ���� ��´�.
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
 
            // ������ �����Ͽ� ������ ��û�Ѵ�.
            System.out.println("������ �������Դϴ�. ����IP : " + serverIp);
            socket = new Socket(serverIp, 7777);
           
            in = socket.getInputStream();
            out = socket.getOutputStream();

            // ������ �Է½�Ʈ���� ��´�.
            dis = new DataInputStream(in);
 
            // �������κ��� ���� �����͸� ����Ѵ�.
            System.out.println("�����κ��� ���� �޼��� : " + dis.readUTF());
  
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
