package controller;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.TetrisConstant;
import view.GameFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDialog.setDefaultLookAndFeelDecorated(true);
	    Object[] selectionValues = { TetrisConstant.GAMEMODE_1P, TetrisConstant.GAMEMODE_2P };
	    String initialSelection = TetrisConstant.GAMEMODE_1P;
	    Object selection = JOptionPane.showInputDialog(null, "Please choose game mode.",
	        "TERIS", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
	   
	    if(selection != null){
	    	new ClientController();
	    	new GameFrame(selection.toString());
	    }
	  
	}

}
