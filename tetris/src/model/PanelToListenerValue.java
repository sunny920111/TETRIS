package model;

public class PanelToListenerValue {
	
	
	public static PanelToListenerValue panelToListenerValue = new PanelToListenerValue();
	
	private int row =0;
	private int col =0;
	private int speed =0;
	private int randnum =0;
	private boolean[][] item;
	
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

	public boolean[][] getItem() {
		return item;
	}

	public void setItem(boolean[][] item) {
		this.item = item;
	}
	
	
}
