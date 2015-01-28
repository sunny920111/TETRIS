package controller;

import model.TetrisConstant;

public class ValidationController {
	public boolean checkLeftSide(boolean[][] item, boolean[][] statue,int row,int col){
		
		if(col==0){
			return true;
		}
		
		
		for(int i=row ; i< row+item.length ;i++){
			for(int j = col-1 ; j<col+item.length ; j++){
				if(statue[i][j]){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkRightSide(boolean[][] item, boolean[][] statue,int row,int col){
		
		if(col+item.length==TetrisConstant.COLS){
			return true;
		}
		
		
		for(int i=row ; i<= row+item.length ;i++){
			if(i != TetrisConstant.ROWS ){
				if(statue[i][col+item.length]){
					return true;
				}
			}
		}
		
		return false; 
	}
	
	public boolean checkBottomSide(boolean[][] item, boolean[][] statue,int row,int col){
		
		for(int i=item.length-1; i >=0 ;i--){
			for(int j=0; j<item[i].length;j++){
				if(row+item.length == TetrisConstant.ROWS ){ //하단에 내려왔을때
					return true; 
				}else{
					if(statue[row+i+1][col+j]){
						return true;
					}
				}
			}
		} 
		
		return false; 
	}
	
	public boolean checkTetrisItemHeight(boolean[][] statue){

		for(int i=0; i< TetrisConstant.COLS ;i++){
			if(statue[0][i]){
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
