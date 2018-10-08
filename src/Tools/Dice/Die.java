package Tools.Dice;

import java.util.Comparator;
import java.util.Random;

public class Die {
	private int numberOfSides;
	private int landedOn;

	public Die() {
		this.numberOfSides = 6;
		this.landedOn = -1;
	}

	public Die(int numberOfSides) {
		this.numberOfSides = numberOfSides;
		this.landedOn = -1;
	}

	public Die(Die die) {
		this.numberOfSides = die.numberOfSides;
		this.landedOn = die.landedOn;
	}

	public int roll() {
		return landedOn = new Random().nextInt(numberOfSides) + 1;
	}

	public String toString() {
		String output = "D" + numberOfSides + " : ";
		if (landedOn != -1) {
			return output += landedOn;
		} else {
			return output + "Null";
		}
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
