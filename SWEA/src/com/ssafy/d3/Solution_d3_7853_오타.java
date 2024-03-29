package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution_d3_7853_오타 {
	static int T, N;
	static char[] alpha;
	static StringBuilder typo;
	static HashSet<String> words;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7853.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			alpha = in.readLine().toCharArray();
			words = new HashSet<>();
			N = alpha.length;
			typo = new StringBuilder();
			combi(0, 0);
			System.out.println("#"+test_case+" "+words.size());
		}
	}

	private static void combi(int count, int start) {
		if (count == N) {
			words.add(typo.toString());
			return;
		}
		for (int i = -1; i < 2; i++) {
			if ((count == 0 && i == -1) || (count == N - 1 && i == 1)) {
				continue;
			}
			typo.append(alpha[count+i]);
			combi(count + 1, start);
			typo.deleteCharAt(count);
		}

	}
}
