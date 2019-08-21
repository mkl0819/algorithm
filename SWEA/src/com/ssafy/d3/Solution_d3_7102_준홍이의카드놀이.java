package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_7102_준홍이의카드놀이 {
	static int T, N, M, tmp;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7102.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (M < N) {
				tmp = N;
				N = M;
				M = tmp;
			}

			System.out.print("#" + test_case + " ");
			for (int i = N; i <= M; i++) {
				System.out.print(i + 1+" ");
			}System.out.println();

		}
	}
}
