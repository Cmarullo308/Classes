package Tools.Dice;

import java.util.Random;

public class Die {
	private int numberOfSides;
	private int landedOn;

	public Die() {
		this.numberOfSides = 6;
	}

	public Die(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public int roll() {
		return landedOn = new Random().nextInt(numberOfSides) + 1;
	}

	public boolean isMaxNumber() {
		return landedOn == numberOfSides;
	}

	public boolean isMinNumber() {
		return landedOn == 1;
	}

	public int getNumberOfSides() {
		return numberOfSides;
	}

	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public int getLandedOn() {
		return landedOn;
	}

	public void setLandedOn(int landedOn) {
		this.landedOn = landedOn;
	}
}
