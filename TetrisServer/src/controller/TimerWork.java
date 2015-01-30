package controller;
import java.util.TimerTask;

import model.ServerValue;




public class TimerWork extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerValue.setWait(false);
	}
	
}
