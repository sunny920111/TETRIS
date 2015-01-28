package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.MenuButtonListener;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3478859524085262735L;

	public MenuPanel(){
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		JButton startBtn = new JButton("START");
		startBtn.addActionListener(new MenuButtonListener());
		
		add(startBtn);
	
	}
}
