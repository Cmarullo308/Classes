package main;

import Tools.Print;
import Tools.Dice.DiceTray;
import Tools.Dice.Die;

public class Classes {
	public static void main(String[] args) {
		DiceTray dt = new DiceTray();

		dt.addDice(new Die[] { new Die(), new Die(), new Die(), new Die() });
		dt.rollDice();

		int count = 0;
		boolean done = false;
		while (!done) {
			Print.pl(dt.getDice() + " -- Attempt " + count);
			if(dt.allDiceMaxNumber()) {
				done = true;
			} else {
				count++;
				dt.rollDice();
			}
		}

	}
}