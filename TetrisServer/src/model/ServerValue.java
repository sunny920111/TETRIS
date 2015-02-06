package model;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ServerValue {
	public static ServerValue serverValue = new ServerValue();
	
	private static HashMap<String,ObjectOutputStream> clients;
	private static HashMap<String,DataOutputStream> tempClienets;
	private static boolean isWait = true;
	private String userName[] = new String[2];
	

	private ServerValue(){}
	
	public static ServerValue getInstance(){
		if(serverValue == null){
			serverValue = new ServerValue();
		}
		
		return serverValue; 
	}

	public static HashMap<String,ObjectOutputStream> getClients() {
		return clients;
	}

	public static void setClients(HashMap<String,ObjectOutputStream> clients) {
		ServerValue.clients = clients;
	}

	public static boolean isWait() {
		return isWait;
	}

	public static void setWait(boolean isWait) {
		ServerValue.isWait = isWait;
	}

	public static HashMap<String,DataOutputStream> getTempClienets() {
		return tempClienets;
	}

	public static void setTempClienets(HashMap<String,DataOutputStream> tempClienets) {
		ServerValue.tempClienets = tempClienets;
	}

	public String getUserName(int index) {
		return userName[index];
	}

	public void setUserName(String userName,int index) {
		this.userName[index] = userName;
	}

	
}
