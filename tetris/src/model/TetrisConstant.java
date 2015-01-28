package model;

public class TetrisConstant {
	public static final String GAMEMODE_1P = "1P";
	public static final String GAMEMODE_2P = "2P";
	
	
	public static final int ROWS = 25;
	public static final int COLS = 12;
	
	public static final String START_BTN ="START";
	
	public static final int KEY_LEFT = 37;
	public static final int KEY_RIGHT = 39;
	public static final int KEY_DOWN = 40;
	public static final int KEY_UP = 38;
	public static final int KEY_SPACE = 32;
	public static final int KEY_HOLD = 67;
	
	
	public static final boolean[][][] TypeI = {
			{
				{true,	true,	true,	true},
			},
			{
				{true},
				{true},	
				{true},		
				{true},	
			},
			{
				{true,	true,	true,	true},
			},
			{
				
				{true},
				{true},	
				{true},		
				{true}
	
			}
		};
	
	
	public static final boolean[][][] TypeJ = {
				{
					{true,	false,	false},
					{true,	true,	true}
				},
				{
					{true,	true},
					{true,	false},
					{true,	false}
				},
				{
		
					{true,	true,	true},
					{false,	false,	true}
				},
				{
					{false,	true},
					{false,	true},
					{true,	true}
				}
		};
		
	public static final boolean[][][] TypeL = {
				{
					{false,	false,	true},
					{true,	true,	true}
				},
				{
					{true,	false},
					{true,	false},
					{true,	true},
				},
				{
					{true,	true,	true},
					{true,	false,	false}
				},
				{
					{true,	true},	
					{false,	true},	
					{false,	true}
				}
		};
		
	public static final boolean[][][] TypeO = {
				{
					{true,	true},
					{true,	true},
				},
				{
					{true,	true},
					{true,	true},
				},
				{	
					{true,	true},
					{true,	true},
				},
				{
					{true,	true},
					{true,	true},
				}
		};
		
	public static final boolean[][][] TypeS = {
				{
					{false,	true,	true},
					{true,	true,	false}
				},
				{
					{true,	false},
					{true,	true},
					{false,	true}
				},
				{
					{false,	true,	true},
					{true,	true,	false}
				},
				{
					{true,	false},	
					{true,	true},	
					{false,	true}
				}
		};
	public static final boolean[][][] TypeT = {
				{
					{false,	true,	false},
					{true,	true,	true}
				},
				{
					{true,	false},
					{true,	true},
					{true,	false}
				},
				{
					{true,	true,	true},
					{false,	true,	false}
				},
				{
					{false,	true},
					{true,	true},
					{false,	true}
				}
		};
	public static final boolean[][][] TypeZ = {
				{
					{true,	true,	false},
					{false,	true,	true}
				},
				{
					{false,	true},
					{true,	true},
					{true,	false}
				},
				{
					{true,	true,	false},
					{false,	true,	true}
				},
				{
					{false,	true},	
					{true,	true},	
					{true,	false}
				}
		};
}
