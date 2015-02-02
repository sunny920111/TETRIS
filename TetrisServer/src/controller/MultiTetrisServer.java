package controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

import model.ServerValue;

public class MultiTetrisServer {
	
	private ServerSocket serverSocket;
	
	public static void main(String[] args){
		new MultiTetrisServer().start();
	}
	
	public MultiTetrisServer(){
		
		ServerValue.setClients(new HashMap<String, ObjectOutputStream>());
		ServerValue.setTempClienets(new HashMap<String, DataOutputStream>());
		Collections.synchronizedMap(ServerValue.getClients());
		Collections.synchronizedMap(ServerValue.getTempClienets());
	}
	
	public void start(){
		
		
		try {
			Socket socket;
			serverSocket = new ServerSocket(7777);
			System.out.println("Server is ready to connect with clients");
		
			
			while(true){
				socket = serverSocket.accept();
				
				Receiver receiver = new Receiver(socket);
				receiver.start();
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
