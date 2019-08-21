package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_7193_승현이의수학공부 {
	static int T, N;
	static long num;
	static char X[];

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7193.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			X = st.nextToken().toCharArray();
			num = 0;
			for (char c : X) {
				num += c - '0';
			}
			System.out.println("#" + test_case + " " + num % (N - 1));
		}
	}
}
