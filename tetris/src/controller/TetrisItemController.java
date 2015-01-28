package controller;

import java.awt.Color;
import java.util.Random;

import model.TetrisConstant;

public class TetrisItemController {

	private static boolean[][][][] tetrisItem ={
			TetrisConstant.TypeI,
			TetrisConstant.TypeJ,
			TetrisConstant.TypeL,
			TetrisConstant.TypeO,
			TetrisConstant.TypeS,
			TetrisConstant.TypeT,
			TetrisConstant.TypeZ
	};
	
	public static int getRandNum(){
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		int randomNum = random.nextInt(7);
		
		return randomNum;
	}
	
	
	public static Color getColor(int randNum){
		Color color = Color.LIGHT_GRAY;
		
		switch(randNum){
		case 0:
			color = Color.red;
			break;
		case 1:
			color = Color.orange;
			break;
		case 2:
			color = Color.yellow;
			break;
		case 3:
			color = Color.green;
			break;
		case 4:
			color = Color.blue;
			break;
		case 5:
			color = Color.magenta;
			break;
		case 6:
			color = Color.cyan;
			break;
		default:
		    color = Color.white;
		}
		
		return color;
	}
	
	public static boolean[][][] getRandomTetrisItem(int randNum){
		
		return tetrisItem[randNum];
	}
}
