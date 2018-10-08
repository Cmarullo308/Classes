package Tools.Dice;

import java.util.ArrayList;
import java.util.Arrays;

import Tools.Print;
import Tools.MyFuncs.Sort;

public class DiceTray {
	public enum Sort {
		Ascending, Descending;
	}

	private ArrayList<Die> dice;

	private int totalNumRolled;
	Sort sort;

	public DiceTray() {
		dice = new ArrayList<Die>();
		totalNumRolled = 0;
		sort = Sort.Ascending;
	}

	public DiceTray(DiceTray diceTray2) {
		this.dice = new ArrayList<Die>();
		for (int i = 0; i < diceTray2.dice.size(); i++) {
			this.dice.add(new Die(diceTray2.dice.get(i)));
		}
		this.totalNumRolled = diceTray2.totalNumRolled;
		this.sort = diceTray2.sort;
		this.sortDiceInTray();
	}

	public String toString() {
		if (dice.size() == 0) {
			return "No Dice";
		}

		String output = "";
		int type = dice.get(0).getNumberOfSides();
		int location = 0;
		boolean done = false;

		output += "**D" + type + "**" + '\n';
		while (!done) {
			output += "(" + dice.get(location).getLandedOn() + ")\n";
			location++;
			if (location < dice.size()) {
				if (type != dice.get(location).getNumberOfSides()) {
					type = dice.get(location).getNumberOfSides();
					output += "**D" + type + "**" + '\n';
				}
			} else {
				done = true;
			}
		}

		return output;
	}

	public int findDiceType(int sides) {
		for (int i = 0; i < dice.size(); i++) {
			if (dice.get(i).getNumberOfSides() == sides) {
				return i;
			}
		}

		return -1;
	}

	public int getNumberOfDice() {
		return dice.size();
	}

	/**
	 * Addes a die to the tray
	 * 
	 * @param sides
	 */
	private void addDie(int sides) {
		dice.add(new Die(sides));
	}

	private void addDie(Die die) {
		dice.add(new Die(die));
	}

	public void addDice(int numberOfSides, int numOfDice) {
		for (int i = 0; i < numOfDice; i++) {
			addDie(numberOfSides);
		}
		sortDiceInTray();
	}

	public void addDice(Die[] die) {
		for (int i = 0; i < die.length; i++) {
			dice.add(new Die(die[i]));
		}
		sortDiceInTray();
	}

	/**
	 * Removes the first Die with numOfSides number of sides
	 * 
	 * @param numOfSides
	 */
	public void removeDie(int numOfSides) {
		int location = findDiceType(numOfSides);
		if (location != -1) {
			dice.remove(location);
		}
	}

	public void removeDiceOfType(int numberOfSides) {
		int location = findDiceType(numberOfSides);
		if (location != -1) {
			boolean done = false;
			while (!done) {
				dice.remove(location);
				if (dice.get(location).getNumberOfSides() != numberOfSides) {
					done = true;
				}
			}
		}

	}

	public void rollDice() {
		for (Die die : dice) {
			die.roll();
		}
	}

	/**
	 * returns an int array of every number rolled on all the dice
	 * 
	 * @return int array
	 */
	public int[] getRollNumbers() {
		int[] nums = new int[dice.size()];

		for (int i = 0; i < dice.size(); i++) {
			nums[i] = dice.get(i).getLandedOn();
		}

		return nums;
	}

	/**
	 * returns a string representation of all the numbers rolled on the dice in
	 * the tray
	 * 
	 * @return
	 */
	public String getRollNumbersToString() {
		int[] nums = new int[dice.size()];

		for (int i = 0; i < dice.size(); i++) {
			nums[i] = dice.get(i).getLandedOn();
		}

		return Arrays.toString(nums);
	}
	
	public boolean allDiceMaxNumber() {
		for(Die die : dice) {
			if(die.getLandedOn() != die.getNumberOfSides()) {
				return false;
			}
		}
		
		return true;
	}

	public ArrayList<Die> getDice() {
		return dice;
	}

	public void sortDiceInTray() {
		if (sort == Sort.Ascending) {
			quickSortASCE(0, dice.size() - 1);
		} else if (sort == Sort.Descending) {
			quickSortDESC(0, dice.size() - 1);
		}
	}

	private void quickSortASCE(int low, int high) {
		int i = low;
		int j = high;
		int pivot = low + (high - low) / 2;
		while (i <= j) {
			while (dice.get(i).getNumberOfSides() < dice.get(pivot).getNumberOfSides()) {
				i++;
			}
			while (dice.get(j).getNumberOfSides() > dice.get(pivot).getNumberOfSides()) {
				j--;
			}
			if (i <= j) {
				exchangeDice(i, j);
				i++;
				j--;
			}
		}
		if (low < j)
			quickSortASCE(low, j);
		if (i < high)
			quickSortASCE(i, high);
	}

	private void quickSortDESC(int low, int high) {
		int i = low;
		int j = high;
		int pivot = low + (high - low) / 2;
		while (i < j) {
			while (dice.get(i).getNumberOfSides() > dice.get(pivot).getNumberOfSides()) {
				i++;
			}
			while (dice.get(j).getNumberOfSides() < dice.get(pivot).getNumberOfSides()) {
				j--;
			}
			// j >= i
			if (i <= j) {
				exchangeDice(i, j);
				i++;
				j--;
			}
		}
		if (low < j)
			quickSortDESC(low, j);
		if (i < high)
			quickSortDESC(i, high);
	}

	private void exchangeDice(int i, int j) {
		Die temp = dice.get(i);
		dice.set(i, dice.get(j));
		dice.set(j, temp);
	}

}
