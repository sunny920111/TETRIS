package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.GameController;
import controller.TetrisItemController;
import model.GameValue;
import model.TetrisConstant;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	
	private JLabel[][] pixels = new JLabel[TetrisConstant.ROWS][TetrisConstant.COLS];
	private boolean[][] statue = new boolean[TetrisConstant.ROWS][TetrisConstant.COLS];
	private Color[][] color = new Color[TetrisConstant.ROWS][TetrisConstant.COLS];

	private static final long serialVersionUID = 1860979716621182121L;

	public GamePanel(){
		setLayout(new GridLayout(TetrisConstant.ROWS,TetrisConstant.COLS));
		init();
	}
	
	public void init(){
		for(int i=0; i< TetrisConstant.ROWS; i++){
			for(int j=0; j<TetrisConstant.COLS; j++){
				pixels[i][j] = new JLabel();
				pixels[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
				pixels[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
				pixels[i][j].setOpaque(true);
				pixels[i][j].setBackground(Color.WHITE);
				statue[i][j] = false;
				color[i][j] = Color.WHITE;
				this.add(pixels[i][j]);
			}
		}
	}
	
	public void clear(){
		for(int i=0; i< TetrisConstant.ROWS; i++){
			for(int j=0; j<TetrisConstant.COLS; j++){
				if(statue[i][j]){
					pixels[i][j].setBackground(color[i][j]);
				}else{
					pixels[i][j].setBackground(Color.WHITE);
				}
			}
		}
	}
	
	public void drawBlock(int x,int y, boolean[][] item,Color color){
		for(int i=0 ;i <item.length ;i++){
			for(int j=0; j <item[0].length ;j++){
				if(x+i < TetrisConstant.ROWS && y+j < TetrisConstant.COLS ){
					if(item[i][j]){
						pixels[x+i][y+j].setBackground(color);
					}
				}
			}
		}
	}
	
	public JLabel getPixels(int i,int j) {
		return pixels[i][j];
	}

	public void setPixels(JLabel pixels,int i,int j) {
		this.pixels[i][j] = pixels;
	}

	public boolean[][] getStatue() {
		return statue;
	}

	public void setStatue(boolean[][] item,int row,int col,Color color) {
		for(int i=0; i< item.length; i++){
			for(int j=0; j< item[i].length ;j++){
				if(item[i][j]){
					this.statue[row+i][col+j] = true;
					this.color[row+i][col+j] = color;
				}
			}
		}
		
	}


}
