package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.ssafy.library.printMing;

public class Solution_d4_8049_폭탄감식반 {
	static int T;
	static String str, subStr;
	static String keyword[][] = { { "FF", "MCM" }, { "FC", "MF" } };
	static int start, end;
	static int check;
	static boolean answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_8049.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			str = in.readLine();

			answer = true;
			while (answer && str.length() != 0) {
				if (isStartFF()) {
//					System.out.println("FF");
					bombCheck(0);
				} else if (isStartFC()) {
//					System.out.println("FC");
					bombCheck(1);
				} else {
//					System.out.println("??");
//					System.out.println(str);
					answer = false;
					break;
				}
			}
			System.out.println("#" + test_case + " " + (answer ? "DETECTED!" : "NOTHING!"));
		}
	}

	private static void bombCheck(int index) {
		start = 2;
		end = str.indexOf(keyword[index][1]);
		if (end == -1) {
			answer = false;
			return;
		}
//		System.out.printf("1 : %s   %d  %d\n", str, start, end);
		subStr = str.substring(start, end);
//		printMing.print("subStr", subStr);
		char key = index == 0 ? 'F' : 'C';
		for (char c : subStr.toCharArray()) {
			if (c != key) {
				answer = false;
				return;
			}
		}
		if (!answer)
			return;
		start = index == 0 ? end + 3 : end + 2;
		end = str.lastIndexOf(keyword[1 - index][0]);
		if (end == -1) {
			end = str.length();
		}
		subStr = str.substring(start, end);
//		System.out.printf("2 : %s   %d  %d\n", str, start, end);
//		printMing.print("subStr", subStr);
		key = index == 0 ? 'M' : 'F';
		for (char c : subStr.toCharArray()) {
			if (c != key) {
				answer = false;
				return;
			}
		}
//		if (start == str.length()) {
////			System.out.println("dd");
//			str = str.substring(start);
////			System.out.println(str);
//			return;
//		}
		str = str.substring(end);
	}

	private static boolean isStartFF() {
		return str.indexOf("FF") == 0;
	}

	private static boolean isStartFC() {
		return str.indexOf("FC") == 0;
	}

}
