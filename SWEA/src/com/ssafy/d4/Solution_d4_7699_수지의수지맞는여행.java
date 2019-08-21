package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_7699_수지의수지맞는여행 {
	static int T, R, C, MAX, mm;
	static int map[][];
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean check[];

	static StringTokenizer st;
	static char[] c;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7699.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[R + 2][C + 2];
			check = new boolean[26];
			MAX = 1;
			mm = 0;
			
			for (int i = 1; i <= R; i++) {
				c = in.readLine().toCharArray();
				for (int j = 1; j <= C; j++) {
					map[i][j] = c[j - 1] - 'A' + 1;
					if(!check[map[i][j]]) {
						check[map[i][j]] = true;
						mm++;
					}
				}
			}
			
			Arrays.fill(check, false);
			
			check[map[1][1]] = true;
			dfs(1, 1, 1);

			System.out.println("#"+test_case+" "+MAX);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		int dr, dc;

		if(MAX < cnt) {
			MAX = cnt;
		}
		if(MAX == mm) {
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];

			if (map[dr][dc] != 0 && !check[map[dr][dc]]) {
				check[map[dr][dc]] = true;
				dfs(dr, dc, cnt + 1);
				check[map[dr][dc]] = false;
			}
		}
	}
}
