package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 7675. 통역사 성경이
 * 
 * 입력 2 2 Annyung Hasae Yo! LoL! 3 my name is Hye Soo. my id is Rhs0266. what
 * your id Bro?
 * 
 * 출력
 * 
 * #1 3 0 #2 2 0 1
 *
 */
public class Solution_d3_7675 {
	static int T, N, index, size;
	static int cnt[];
	static boolean check;
	static String[] str;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception, NumberFormatException {
		System.setIn(new FileInputStream("res/Solution_d3_7675.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());

			cnt = new int[N];

			str = in.readLine().split(" ");

			index = 0;

			for (String s : str) {
				getCnt(s.toCharArray());
			}

			sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			for (int c : cnt) {
				sb.append(c).append(" ");
			}
			System.out.println(sb.toString());
		}
	}

	private static void getCnt(char[] s) {
		size = s.length;
		check = false;
		if (!Character.isUpperCase(s[0])) {
			isEnd(s[size - 1]);
			return;
		}

		check = true;

		if (size == 1) {
			cnt[index]++;
			return;
		}

		for (int i = 1; i < size - 1; i++) {
			if (!Character.isLowerCase(s[i])) {
				check = false;
			}
		}

		if(isEnd(s[size - 1])) {
			return;
		}
		
		if (check & Character.isLowerCase(s[size - 1])) {
			System.out.println(Arrays.toString(s));
			cnt[index]++;
		}
		return;
	}

	private static boolean isEnd(char c) {
		switch (c) {
		case '.':
		case '?':
		case '!':
			if (check) {
				cnt[index]++;
			}
			index++;
			return true;
		}
		return false;
	}

}
