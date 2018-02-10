package main;

import Tools.MyFuncs;
import Tools.Print;

public class Classes {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Print.pl(MyFuncs.Random.randomDoubleBetween(1, 10, 3));
		}
	}
}