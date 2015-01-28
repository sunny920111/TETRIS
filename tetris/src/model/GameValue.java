package model;

import view.GamePanel;
import controller.GameController;

public class GameValue {
	//game이 동작할데 필요한 value들의 모임
	
	public static GameValue gameValue = new GameValue();
	
	private static GamePanel[] users;
	private static Thread[] userThreads;

	private GameValue(){}
	
	public static GameValue getInstance(int userNum){	
		if(gameValue == null){
			gameValue = new GameValue();
		}
		
		users = new GamePanel[userNum];
		userThreads = new Thread[userNum];
		for(int i=0; i< userNum ; i++){
			users[i] = new GamePanel();	
			if(i==0){
				userThreads[i] = new Thread(new GameController());
			}else{
				userThreads[i] = new Thread();
			}
			
		}
		
		return gameValue;
	}

	public static GamePanel getUsers(int i) {
		return users[i];
	}

	public static void setUsers(GamePanel[] users) {
		GameValue.users = users;
	}

	public static Thread getUserThreads(int i) {
		return userThreads[i];
	}

	public static void setUserThreads(Thread userThreads,int i) {
		GameValue.userThreads[i] = userThreads;
	}

}
