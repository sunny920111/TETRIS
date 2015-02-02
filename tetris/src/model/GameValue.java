package model;

import view.GamePanel;
import view.MenuPanel;
import view.PreviewPanel;
import controller.GameController;
import controller.OtherClientController;
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
	private static ClientData clientObj;
	private static Thread clientThread; 
	private static int userNum;
	private static ClientData serverToClient;
	private GameValue(){}
	
	public static GameValue getInstance(int userNum){	
		if(gameValue == null){
			gameValue = new GameValue();
		}
		
		setSound(new Thread(new SoundContoller()));
		
		setClientObj(new ClientData());
		setServerToClient(new ClientData());
		setClientThread(new Thread());
		users = new GamePanel[userNum];
		userThreads = new Thread[userNum];
		for(int i=0; i< userNum ; i++){
			users[i] = new GamePanel();	
			if(i==0){
				userThreads[i] = new Thread(new GameController());
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

	/**
	 * @return the clientObj
	 */
	public static ClientData getClientObj() {
		return clientObj;
	}

	/**
	 * @param clientObj the clientObj to set
	 */
	public static void setClientObj(ClientData clientObj) {
		GameValue.clientObj = clientObj;
	}

	/**
	 * @return the clientThread
	 */
	public static Thread getClientThread() {
		return clientThread;
	}

	/**
	 * @param clientThread the clientThread to set
	 */
	public static void setClientThread(Thread clientThread) {
		GameValue.clientThread = clientThread;
	}

	/**
	 * @return the userNum
	 */
	public static int getUserNum() {
		return userNum;
	}

	/**
	 * @param userNum the userNum to set
	 */
	public static void setUserNum(int userNum) {
		GameValue.userNum = userNum;
	}

	/**
	 * @return the serverToClient
	 */
	public static ClientData getServerToClient() {
		return serverToClient;
	}

	/**
	 * @param serverToClient the serverToClient to set
	 */
	public static void setServerToClient(ClientData serverToClient) {
		GameValue.serverToClient = serverToClient;
	}

	

}
