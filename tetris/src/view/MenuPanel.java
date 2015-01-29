package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.GameValue;
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
		JButton stopBtn = new JButton("STOP");
		stopBtn.setMaximumSize(new Dimension(200,50));
		startBtn.setMaximumSize(new Dimension(200,50));
		
		startBtn.addActionListener(new MenuButtonListener());
		
		
		add(startBtn);
		add(stopBtn);
		add(new JLabel("HOLD"));
		add(GameValue.getHold());
		add(new JLabel("QUEUE"));
		add(GameValue.getQueue());
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		
	}
}

