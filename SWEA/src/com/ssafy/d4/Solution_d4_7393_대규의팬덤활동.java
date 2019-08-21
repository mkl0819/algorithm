package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d4_7393_대규의팬덤활동 {
	static int T, N, map[][], count;
	static boolean check[];
	static int dir[][] = { { -1, 1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7393.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][100];

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			System.out.println(N);

			count = 0;

			check = new boolean[10];

			for (int i = 1; i < 10; i++) {
				check[i] = true;
				dfs(i, 0, 1);
				check[i] = false;
			}

			System.out.println("#" + test_case + " " + count);
		}
	}

	private static void dfs(int r, int c, int numcount) {
		if (c == N) {
			if (numcount == 10) {
				count++;
			}
			return;
		}
		int dr, dc;
		for (int d = 0; d < 2; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if (dr == -1 || dr == 10 || dc == -1 || dc == 100) {
				continue;
			}
			if (!check[dr]) {
				check[dr] = true;
				dfs(dr, dc, numcount + 1);
				check[dr] = false;
			} else {
				dfs(dr, dc, numcount);
			}
		}
	}
}
