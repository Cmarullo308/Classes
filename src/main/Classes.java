package Main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import Tools.Print;
import Tools.Time;
import Tools.Time.Format;
import Tools.Exceptions.InvalidTimeException;

public class Classes {
	public static void main(String[] args) {
		Time t = null;
		PrintWriter file = null;

		try {
			file = new PrintWriter("file.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		// --------------------------------------

		try {
			t = new Time(0, 0, 0, Format.CLOCK24);
		} catch (InvalidTimeException e) {
			e.printStackTrace();
		}
		file.println(t);
		
		for (int hour = 0; hour < 24; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				for (int second = 0; second < 60; second++) {
					t.addSecond(1);
					file.println(t);
				}
			}
		}

		// ---------------------------------------
		file.close();

	}
}