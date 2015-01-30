package model;

public class ServerValue {
	public static ServerValue severValue = new ServerValue();
	
	private static boolean wait = true;
	private static int clientNum;

	private ServerValue(){}
	
	public static ServerValue getInstance(){
		if(severValue == null){
			severValue = new ServerValue();
		}
		clientNum =0;
		return severValue;
	}

	public static boolean isWait() {
		return wait;
	}

	public static void setWait(boolean wait) {
		ServerValue.wait = wait;
	}

	public static int getClientNum() {
		return clientNum;
	}

	public static void setClientNum(int clientNum) {
		ServerValue.clientNum = clientNum;
	}


	
}
