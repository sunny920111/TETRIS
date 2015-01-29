package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PreviewPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ROWS = 7;
	private static final int COLS = 7;

	JLabel[][] pixel = new JLabel[ROWS][COLS];
	
	public PreviewPanel(){
		drawOptionPanel();
	}
	
	public void drawOptionPanel(){
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new GridLayout(ROWS,COLS));
		this.setMaximumSize(new Dimension(250, 100));
		for(int i=0; i<ROWS ; i++){
			for(int j=0; j<COLS ; j++){
				
				pixel[i][j] = new JLabel("");
				pixel[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));
				pixel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				pixel[i][j].setOpaque(true);
				
				if(i==0 || i== ROWS-1){
					pixel[i][j].setBackground(Color.LIGHT_GRAY);
				}else if(j==0 || j == COLS-1){
					pixel[i][j].setBackground(Color.LIGHT_GRAY);
				}else{
					pixel[i][j].setBackground(Color.white);
				}
			
				this.add(pixel[i][j]);
				
			}
		}
	}
	
	public void drawHold(boolean[][] item,Color color){
		
		
		for(int i=0; i<ROWS ; i++){
			for(int j=0; j<COLS ; j++){
				if(i==0 || i== ROWS-1){
					pixel[i][j].setBackground(Color.LIGHT_GRAY);
				}else if(j==0 || j == COLS-1){
					pixel[i][j].setBackground(Color.LIGHT_GRAY);
				}else{
					pixel[i][j].setBackground(Color.white);
				}
			}
		}
			
		for(int i=0; i< item.length;i++){
			for(int j=0; j< item[i].length;j++){
					int colIndex =0;
					if(item[i].length==4){
						colIndex =1;
					}else{
						colIndex =2;
					}
					if(item[i][j]){
						pixel[3+i][colIndex+j].setBackground(color);
					}
			}
		}
	}
	
	public void allClear(){
		for(int i=0; i<ROWS ; i++){
			for(int j=0; j<COLS ; j++){
				
				if(i==0 || i== ROWS-1){
					pixel[i][j].setBackground(Color.LIGHT_GRAY);
				}else if(j==0 || j == COLS-1){
					pixel[i][j].setBackground(Color.LIGHT_GRAY);
				}else{
					pixel[i][j].setBackground(Color.white);
				}
			

				
			}
		}
	}
}
