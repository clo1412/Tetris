package controller;

public class PositionController {

	
	public static final int BLOCKSIZE = 25;
	public static final int GRIDHEIGHT = 24, GRIDWIDTH = 10;
	private final int indentY = 25 * 2;
	private final int indentX = 25;
	private final int borderY = 25 * 24 + indentY;
	private final int borderX = 25 * 10 + indentX;
	
	public static int curIDX;
	public static int holdIDX = 7;
	public static int nextIDX;
	
	public int getIndentY() {
		return indentY;
	}

	public int getIndentX() {
		return indentX;
	}

	public int getBorderY() {
		return borderY;
	}
	
	public int getBorderX() {
		return borderX;
	}
	
}
