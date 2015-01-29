package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import model.GameValue;
import model.PanelToListenerValue;
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
		stopBtn.addActionListener(new MenuButtonListener());
		
		
		JLabel lineTag = new JLabel("LINE");
		JLabel lineNum = new JLabel(PanelToListenerValue.getLineNum()+"");
		JLabel holdTag = new JLabel("HOLD");
		JLabel queueTag = new JLabel("QUEUE");
		
		
		Font labelFont = new Font("Verdana",Font.PLAIN,15);
		Font lineNumFont = new Font("Verdana",Font.BOLD,25);
		
		
		startBtn.setFont(labelFont);
		stopBtn.setFont(labelFont);
		lineTag.setFont(labelFont);
		holdTag.setFont(labelFont);
		queueTag.setFont(labelFont);
		lineNum.setFont(lineNumFont);
		
		startBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		lineTag.setAlignmentX(Component.CENTER_ALIGNMENT);
		holdTag.setAlignmentX(Component.CENTER_ALIGNMENT);
		queueTag.setAlignmentX(Component.CENTER_ALIGNMENT);
		lineNum.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		startBtn.setBackground(Color.WHITE);
		stopBtn.setBackground(Color.WHITE);
		
		InputMap im = (InputMap)UIManager.get("Button.focusInputMap");
		im.put(KeyStroke.getKeyStroke("pressed SPACE"), "none");
		im.put(KeyStroke.getKeyStroke("released SPACE"), "none");
		
		
		add(startBtn);
		add(stopBtn);
		add(holdTag);
		add(GameValue.getHold());
		add(queueTag);
		add(GameValue.getQueue());
		add(lineTag);
		add(lineNum);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
	}
}

