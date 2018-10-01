package Tools;

public class MyFuncs {
	public enum Sort {
		ASCE, DESC;
	}

	// ----------Char Class----------

	public static class Chars {
		public static char switchCase(char c) {
			if (c >= 65 && c <= 90) { // if Uppercase
				return c += 32;
			} else if (c >= 97 && c <= 122) { // if Lowercase
				return c -= 32;
			}

			return c;
		}

		public static char toLower(char c) {
			if (c >= 65 && c <= 90) {
				return c += 32;
			}
			return c;
		}

		public static char toUpper(char c) {
			if (c >= 97 && c <= 122) {
				return c -= 32;
			}
			return c;
		}

		public static void reverseCharArray(char[] c) {
			char temp;

			for (int i = 0; i < c.length / 2; i++) {
				temp = c[i];
				c[i] = c[c.length - 1 - i];
				c[c.length - 1 - i] = temp;
			}
		}

	}

	// ----------Random Class----------

	public static class Random {
		public static int randomIntBetween(int min, int max) {
			return new java.util.Random().nextInt(max - min + 1) + min;
		}

		public static double randomDoubleBetween(double min, double max) {
			return min + (max - min) * new java.util.Random().nextDouble();
		}

		public static double randomDoubleBetween(double min, double max, int decimalPoints) {
			return Double.parseDouble(
					String.format("%." + decimalPoints + "f", min + (max - min) * new java.util.Random().nextDouble()));
		}
	}

	// ----------Strings Class----------

	public static class Strings {
		private static String[] tempStrArr;

		public static String reverseChars(String str) {
			char[] charArr = new char[str.length()];

			for (int i = 0; i < str.length(); i++) {
				charArr[str.length() - 1 - i] = str.charAt(i);
			}

			return String.valueOf(charArr);
		}

		public static String addLeadingZeros(String num, int size) {
			String zeros = "";
			int zerosNeeded = size - num.length();

			while (zeros.length() < zerosNeeded) {
				zeros += "0";
			}

			return zeros + num;
		}

		/**
		 * Sorts the array by length
		 * 
		 * @param strArr
		 */
		public static void sortArrayByLength(String[] strArr, Sort sort) {
			tempStrArr = strArr;
			if (sort == Sort.ASCE) {
				quickSortASEC(0, tempStrArr.length - 1);
			} else if (sort == Sort.DESC) {
				quickSortDESC(0, tempStrArr.length - 1);
			}
		}

		private static void quickSortASEC(int low, int high) {
			int i = low;
			int j = high;
			String pivot = tempStrArr[low + (high - low) / 2];
			while (i <= j) {
				while (tempStrArr[i].length() < pivot.length()) {
					i++;
				}
				while (tempStrArr[j].length() > pivot.length()) {
					j--;
				}
				if (i <= j) {
					exchangeNumbers(i, j);
					i++;
					j--;
				}
			}
			if (low < j)
				quickSortASEC(low, j);
			if (i < high)
				quickSortASEC(i, high);
		}

		private static void quickSortDESC(int low, int high) {
			int i = low;
			int j = high;
			String pivot = tempStrArr[(low + high) / 2];

			while (i < j) {
				while (tempStrArr[i].length() > pivot.length()) {
					i++;
				}
				while (tempStrArr[j].length() < pivot.length()) {
					j--;
				}
				if (j >= i) {
					exchangeNumbers(i, j);
					i++;
					j--;
				}
			}

			if (low < j) {
				quickSortDESC(low, j);
			}
			if (i < high) {
				quickSortDESC(i, high);
			}
		}
		// private static void quickSortDESC(int low, int high) {
		// int i = low;
		// int j = high;
		// String pivot = tempStrArr[low + (high - low) / 2];
		// while (i <= j) {
		// while (tempStrArr[i].length() > pivot.length()) {
		// i++;
		// }
		// while (tempStrArr[j].length() < pivot.length()) {
		// j--;
		// }
		// if (i <= j) {
		// exchangeNumbers(i, j);
		// i++;
		// j--;
		// }
		// }
		// if (low < j)
		// quickSortASEC(low, j);
		// if (i < high)
		// quickSortASEC(i, high);
		// }

		private static void exchangeNumbers(int i, int j) {
			String temp = tempStrArr[i];
			tempStrArr[i] = tempStrArr[j];
			tempStrArr[j] = temp;
		}
	}

	// ----------Arrays Class----------

	public static class Arrays {
		public static <T> void reverseArray(T[] arr) {
			T temp;
			for (int i = 0; i < arr.length / 2; i++) {
				temp = arr[i];
				arr[i] = arr[arr.length - 1 - i];
				arr[arr.length - 1 - i] = temp;
			}
		}
	}
}
