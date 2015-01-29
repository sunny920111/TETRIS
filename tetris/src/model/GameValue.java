package model;

import view.GamePanel;
import view.MenuPanel;
import view.PreviewPanel;
import controller.GameController;
import controller.SoundContoller;

public class GameValue {
	//game이 동작할데 필요한 value들의 모임
	
	public static GameValue gameValue = new GameValue();
	
	private static GamePanel[] users;
	private static MenuPanel menu;
	private static Thread[] userThreads;
	private static PreviewPanel hold;
	private static PreviewPanel queue;
	private static Thread sound; 
	private GameValue(){}
	
	public static GameValue getInstance(int userNum){	
		if(gameValue == null){
			gameValue = new GameValue();
		}
		setSound(new Thread(new SoundContoller()));
		
		
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
		
		hold = new PreviewPanel();
		queue = new PreviewPanel();
		menu = new MenuPanel();
		
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

	/**
	 * @return the menu
	 */
	public static MenuPanel getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public static void setMenu(MenuPanel menu) {
		GameValue.menu = menu;
	}

	/**
	 * @return the queue
	 */
	public static PreviewPanel getQueue() {
		return queue;
	}

	/**
	 * @param queue the queue to set
	 */
	public static void setQueue(PreviewPanel queue) {
		GameValue.queue = queue;
	}

	/**
	 * @return the hold
	 */
	public static PreviewPanel getHold() {
		return hold;
	}

	/**
	 * @param hold the hold to set
	 */
	public static void setHold(PreviewPanel hold) {
		GameValue.hold = hold;
	}

	/**
	 * @return the sound
	 */
	public static Thread getSound() {
		return sound;
	}

	/**
	 * @param sound the sound to set
	 */
	public static void setSound(Thread sound) {
		GameValue.sound = sound;
	}

}
