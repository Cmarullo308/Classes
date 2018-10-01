package main;

import java.util.Arrays;

import Tools.BaseConverter;
import Tools.MyFuncs;
import Tools.Print;

public class Classes {
	public static void main(String[] args) {
		String[] strArr = {"DerpAss", "Ass", "Shit", "a", "ddddddddddd"};
		
		MyFuncs.Strings.sortArrayByLength(strArr, MyFuncs.Sort.ASCE);
		
		for(String s : strArr) {
			Print.pl(s);
		}
	}
}