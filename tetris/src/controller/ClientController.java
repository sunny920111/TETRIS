package controller;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import model.ClientData;
import model.GameValue;

public class ClientController implements Observer,Runnable{
	
	Observable observable;  
	 
	
	private boolean[][] item;
	private int row;
	private int col;
	private int speed;
	private Color itemColor;
	
	private boolean[][] statue;
	private Color[][] color;
	private boolean isContinue;
	
	private Socket socket;
	
	
	private int userNum;
	 // ������ �Է½�Ʈ���� ��´�.
    InputStream in;
    OutputStream out;
    
    DataOutputStream dos;
    DataInputStream dis;
    
    ObjectOutputStream oos;
    ClientData dataToServer;
    
	public ClientController( Observable observable,int userNum){
		this.observable = observable;
		observable.addObserver(this);
		this.userNum = userNum;
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
            dos.writeInt(1);
          
            String msg = dis.readUTF();
            System.out.println(msg);
            
            if("[END]".equals(msg)){
            	System.out.println("Client ����");
            }else{
            	
            	oos = new ObjectOutputStream(out);
            	if(GameValue.getSound() == null || !GameValue.getSound().isAlive()){
        			GameValue.setSound(new Thread(new SoundContoller()));
        			GameValue.getSound().start();
        		}else{
        			GameValue.getSound().start();
        		}
        		
            	//Panel Thread ���� 
    			for(int i=0 ; i< GameValue.getUserNum() ;i++){
    				if(GameValue.getUserThreads(i) == null || !GameValue.getUserThreads(i).isAlive()){
    					GameValue.setUserThreads(new Thread(new GameController()),i);
    					GameValue.getUserThreads(i).start();
    				}
    			}
    	

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		if(obs instanceof ClientData){

			ClientData data =  (ClientData)obs;
			this.item = data.getItem();
			this.itemColor = data.getItemColor();
			this.row = data.getRow();
			this.col = data.getCol();
			this.speed = data.getSpeed();
			
			this.statue = data.getStatue();
			this.color = data.getColor();
			this.isContinue = data.isContinue();
			
			if(!isContinue){
				sendToServer();
			}else{
				  
	            try {
					dos.close();
					oos.close();
		            dis.close();    
		            socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            System.exit(0);
	            System.out.println("Client ����");
			}
		
			
		}
	}

	public void sendToServer(){
		
		dataToServer = new ClientData(item,row,col,speed,itemColor,statue,color,isContinue);
		
		System.out.println("ROW : "+dataToServer.getRow()+", COL :"+dataToServer.getCol());
		try {
			oos.writeObject(dataToServer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
