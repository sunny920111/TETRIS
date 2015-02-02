package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameValue;
import model.TetrisConstant;
import controller.ClientController;
import controller.KeyBoardController;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2601588613080786213L;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 800;
	private static final int PADDING_WIDTH = 200;
	private static final int ADDTIODN_WIDTH = 100;
	private static final int ADDTIODN_HEIGHT = 70;

	public GameFrame(String gameMode){
		
		JPanel bgPanel = new JPanel(); 
		setTitle("TETRIS");
		setVisible(true);		
		setResizable(false);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		bgPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,25));
		bgPanel.setBackground(Color.WHITE);
		
		makeLayoutAsGameMode(gameMode,bgPanel);
		
		add(bgPanel);
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KeyBoardController());
	
	}
	
	public void makeLayoutAsGameMode(String gameMode,JPanel bgPanel){
		int userNum = 0;
		
		if(TetrisConstant.GAMEMODE_1P.equals(gameMode)){
			setSize(WIDTH+PADDING_WIDTH+ADDTIODN_WIDTH,HEIGHT+ADDTIODN_HEIGHT);
			userNum =1; 
		}else{
			setSize((WIDTH*2)+PADDING_WIDTH+ADDTIODN_WIDTH,HEIGHT+ADDTIODN_HEIGHT);
			userNum =2;
	
		}
		GameValue.getInstance(userNum);
		GameValue.setUserNum(userNum);

		
		for(int i=userNum-1; i >= 0 ; i--){
			GameValue.getUsers(i).setPreferredSize(new Dimension(WIDTH,HEIGHT));
			bgPanel.add(GameValue.getUsers(i));
		}
		
	
		GameValue.getMenu().setPreferredSize(new Dimension(PADDING_WIDTH-50,HEIGHT));
		bgPanel.add(GameValue.getMenu());
		
		
		if(userNum >=2){
			GameValue.setClientThread(new Thread(new ClientController(GameValue.getClientObj())));
			GameValue.getClientThread().start();
		}
		
		
	}
	
	
}
