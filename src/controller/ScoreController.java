package controller;

public class ScoreController {

	private int score = 0;
	public static String scoreString = "0";
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
		scoreString = "" + this.score;
	}
	
}
