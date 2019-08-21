package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 등산로
 */
public class Solution_mo_1949_fin {
	static int T, N, K, map[][], max, ANS;
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean visited[][];
	static ArrayList<Integer> maxpoint;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_1949.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N + 2][N + 2];
			visited = new boolean[N + 2][N + 2];

			Arrays.fill(map[0], 30);
			Arrays.fill(map[N + 1], 30);
			max = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				map[i][0] = 30;
				map[i][N + 1] = 30;
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			getMaxPoint();
			goDFS();
			System.out.println("#" + test_case + " " + ANS);
		}
	}

	private static void goDFS() {
		int r, c;
		ANS = 0;
		for (int point : maxpoint) {
			r = point / 100;
			c = point % 100;
			visited[r][c] = true;
			dfs(r, c, map[r][c], 1, false);
			visited[r][c] = false;
		}
	}
	private static void dfs(int r, int c, int val, int cnt, boolean down) {
		if (ANS < cnt) {
			ANS = cnt;
		}
		int dr, dc;
		for (int d = 0; d < 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if (!visited[dr][dc]) {
				if (val > map[dr][dc]) {
					visited[dr][dc] = true;
					dfs(dr, dc, map[dr][dc], cnt + 1, down);
					visited[dr][dc] = false;
				}
				if (!down) {
					for (int i = 1; i <= K; i++) {
						if (val <= map[dr][dc] && val > (map[dr][dc] - i)) {
							visited[dr][dc] = true;
							dfs(dr, dc, map[dr][dc] - i, cnt + 1, true);
							visited[dr][dc] = false;
						}
					}
				}
			}
		}
		return;
	}
	private static void getMaxPoint() {
		maxpoint = new ArrayList<Integer>();
		for (int i = 0; i <= N + 1; i++) {
			for (int j = 0; j <= N + 1; j++) {
				if (map[i][j] == max) {
					maxpoint.add(i * 100 + j);
				}
			}
		}
	}
	private static void print() {
		for (int i = 0; i <= N + 1; i++) {
			for (int j = 0; j <= N + 1; j++) {
				System.out.printf("%3d ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
