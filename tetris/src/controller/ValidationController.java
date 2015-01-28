package controller;

import model.TetrisConstant;

public class ValidationController {
	public boolean checkLeftSide(boolean[][] item, boolean[][] statue,int row,int col){
		
		if(col==0){
			return true;
		}
			
		for(int i=item.length-1; i >=0 ;i--){
			for(int j=0; j<item[i].length;j++){
				if(col+j-1 >=0){ //하단에 내려왔을때
					if(statue[row+i][col+j-1] && item[i][j]){
						return true;
					}	
					if(row+item.length != TetrisConstant.ROWS){
						if(statue[row+i+1][col+j-1] && item[i][j]){
							return true;
						}
					}
				}
			}
		} 
		
		
		return false;
	}
	
	public boolean checkRightSide(boolean[][] item, boolean[][] statue,int row,int col){

		if(col+item[0].length >= TetrisConstant.COLS){
			return true;
		}
		
		for(int i=item.length-1; i >=0 ;i--){
			for(int j=0; j<item[i].length;j++){
				if(col+j+1 < TetrisConstant.COLS ){ //하단에 내려왔을때
					if(statue[row+i][col+j+1] && item[i][j]){
						return true;
					}
					if(row+item.length != TetrisConstant.ROWS){ 
						if(statue[row+i+1][col+j+1] && item[i][j]){
							return true;
						}
					}
				}
			}
		} 
		
		return false; 
	}
	
	public boolean checkBottomSide(boolean[][] item, boolean[][] statue,int row,int col){
		
		for(int i=item.length-1; i >=0 ;i--){
			for(int j=0; j<item[i].length;j++){
				if(row+item.length == TetrisConstant.ROWS){ //하단에 내려왔을때
					return true; 
				}else{
					if(col+j <TetrisConstant.COLS){
						if(statue[row+i+1][col+j] && item[i][j]){
							return true;
						}
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
