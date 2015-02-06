package model;

import java.awt.Color;
import java.io.Serializable;

public class ClientData implements Serializable{
	
	private static final long serialVersionUID = 4303857901581648648L;
	
	private boolean[][] item;
	private int row;
	private int col;
	private int speed;
	private Color itemColor;
	
	private boolean[][] statue;
	private Color[][] color;
	
	private boolean isContinue;
	
	public ClientData(boolean[][] item,int row, int col, int speed, boolean[][] statue, Color[][] color,boolean isContinue){
		this.item = item;
		this.row = row;
		this.col = col;
		this.speed = speed;
		this.statue = statue;
		this.color = color;
		this.isContinue = isContinue;
	}
	
	public boolean[][] getItem() {
		return item;
	}

	public void setItem(boolean[][] item) {
		this.item = item;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Color getItemColor() {
		return itemColor;
	}

	public void setItemColor(Color itemColor) {
		this.itemColor = itemColor;
	}

	public boolean[][] getStatue() {
		return statue;
	}

	public void setStatue(boolean[][] statue) {
		this.statue = statue;
	}

	public Color[][] getColor() {
		return color;
	}

	public void setColor(Color[][] color) {
		this.color = color;
	}

	public boolean isContinue() {
		return isContinue;
	}

	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}

	
}
