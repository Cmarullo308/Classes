package main;

import Tools.Die;
import Tools.Print;
import Tools.Timer;

public class Classes {
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		Die[] die = new Die[5];

		for (int i = 0; i < die.length; i++) {
			die[i] = new Die();
		}

		boolean done = false;
		int count = 1;

		
		timer.start();
		while (!done) {
			Print.pl("-----------" + "Attempt: " + count + "-------------");
			for (int i = 0; i < die.length; i++) {
				Print.pl(die[i].roll());
			}

			if (allMaxed(die)) {
				done = true;
				timer.stop();
			} else {
				count++;
			}
		}
		
		Print.pl(timer.getTime());
	}

	private static boolean allMaxed(Die[] die) {
		for (int i = 0; i < die.length; i++) {
			if (!die[i].isMaxNumber()) {
				return false;
			}
		}

		return true;
	}
}