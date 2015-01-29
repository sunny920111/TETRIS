package model;

import java.awt.Color;

public class PanelToListenerValue {
	
	
	public static PanelToListenerValue panelToListenerValue = new PanelToListenerValue();
	
	private int row =0;
	private int col =0;
	private int speed =0;
	private int randnum =0;
	private boolean[][][] item;
	private int rotateNum =0;
	private boolean hold = false;
	private boolean alreadyHold =false;
	private boolean[][][] holdItem;
	private Color color;
	private Color holdColor; 
	
	public static PanelToListenerValue getInstance(){	
		if(panelToListenerValue == null){
			panelToListenerValue = new PanelToListenerValue();
		}
		return panelToListenerValue;
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
	public int getRandnum() {
		return randnum;
	}
	public void setRandnum(int randnum) {
		this.randnum = randnum;
	}

	public boolean[][][] getItem() {
		return item;
	}

	public void setItem(boolean[][][] item) {
		this.item = item;
	}

	/**
	 * @return the rotateNum
	 */
	public int getRotateNum() {
		return rotateNum;
	}

	/**
	 * @param rotateNum the rotateNum to set
	 */
	public void setRotateNum(int rotateNum) {
		this.rotateNum = rotateNum;
	}

	/**
	 * @return the hold
	 */
	public boolean isHold() {
		return hold;
	}

	/**
	 * @param hold the hold to set
	 */
	public void setHold(boolean hold) {
		this.hold = hold;
	}

	/**
	 * @return the holdItem
	 */
	public boolean[][][] getHoldItem() {
		return holdItem;
	}

	/**
	 * @param holdItem the holdItem to set
	 */
	public void setHoldItem(boolean[][][] holdItem) {
		this.holdItem = holdItem;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the holdColor
	 */
	public Color getHoldColor() {
		return holdColor;
	}

	/**
	 * @param holdColor the holdColor to set
	 */
	public void setHoldColor(Color holdColor) {
		this.holdColor = holdColor;
	}

	/**
	 * @return the alreadyHold
	 */
	public boolean isAlreadyHold() {
		return alreadyHold;
	}

	/**
	 * @param alreadyHold the alreadyHold to set
	 */
	public void setAlreadyHold(boolean alreadyHold) {
		this.alreadyHold = alreadyHold;
	}
	
	
}
