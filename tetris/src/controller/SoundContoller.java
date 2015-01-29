package controller;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class SoundContoller implements Runnable{
	public void run(){
		try {
			FileInputStream fis = new FileInputStream("C:\\03._stage_2todays117.mp3");
			Player playMp3 = new Player(fis);
			playMp3.play();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

