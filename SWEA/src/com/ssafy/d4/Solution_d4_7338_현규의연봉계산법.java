package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_7338_현규의연봉계산법 {
	static int T, M;
	static long Y, month;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7338.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			Y = Long.parseLong(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			month = (Y - 2016) * 12 + M;

			Y = 2016 + (month / 13);
			M = (int) (month % 13);
			if (M == 0) {
				M = 13;
				Y--;
			}

			System.out.println("#" + test_case + " " + Y + " " + M);

		}
	}
}
