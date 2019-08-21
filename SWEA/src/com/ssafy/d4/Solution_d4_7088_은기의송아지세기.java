package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_7088_은기의송아지세기 {
	static int T, N, Q, L, R;
	static int cows[][];
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7088.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());

			cows = new int[N + 1][3];

			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < 3; j++) {
					cows[i][j] += cows[i - 1][j];
				}
				cows[i][Integer.parseInt(in.readLine().trim()) - 1]++;
			}

			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(in.readLine());
				L = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				for (int j = 0; j < 3; j++) {
					sb.append(cows[R][j] - cows[L - 1][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
