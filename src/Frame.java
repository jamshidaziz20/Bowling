
public class Frame {
	
	private static int totalCount;
	private int roundOnePoints;
	private int roundTwoPoints;
	private boolean strike;
	private boolean spare;
	private int spareBonus;
	private int frameTotal;
	
	public Frame() {
		roundOnePoints = 0;
		roundTwoPoints = 0;
		strike = false;
		spare = false;
		frameTotal = 0;
	}
	public Frame(int roundOnePoints, int roundTwoPoints) {
		setRoundOnePoints(roundOnePoints);
		setRoundsTwoPoints(roundTwoPoints);
	}
	
	//GETTERS //////////////////////
	
	public int getRoundOnePoints() {
		return roundOnePoints;
	}
	
	public int getRoundTwoPoints() {
		return roundTwoPoints;
			
		
	}
	public boolean getStrike() {
		return strike;
	}
	public boolean getSpare() {
		return spare;
	}
	public int getFrameTotal() {
		return frameTotal;
	}
	public int getTotalCount() {
		return totalCount;
	}
	////////////////////////////////
	
	//SETTERS/////////////////////////////
	public void setRoundOnePoints(int x) {
		if(x == 10) strike = true;
		roundOnePoints = x;
		frameTotal+=roundOnePoints;
	}
	public void setRoundsTwoPoints(int x) {
		roundTwoPoints = x;
		if(roundOnePoints + roundTwoPoints == 10 && roundTwoPoints !=0) {
			spare = true;
		}
		frameTotal+=roundTwoPoints;
		totalCount+=frameTotal;
		
	}
	/////////////////////////////////////	
	
	public boolean isStrike() {
		return strike;
	}
	public boolean isSpare() {
		
		return spare;
	}
	public void updateTheTotals(int x) {
		frameTotal+= x;
		totalCount += x;
	}
	
	
	
}
