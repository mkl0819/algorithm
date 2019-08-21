package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * �ɺ� ����
 */
public class Main2665_dfs {
	static int N, map[][], MIN;
	static int visited[][];

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static char[] str;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_5650.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());

		map = new int[N + 1][N + 1];
		visited = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}

		for (int i = 1; i <= N; i++) {
			str = in.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str[j - 1] - '0';
			}
		}
		MIN = Integer.MAX_VALUE;
		visited[1][1] = 0;
		dfs(1, 1, 0);
		System.out.println(MIN);
	}

//	private static void print() {
//		for(int i=1; i<=N;i ++) {
//			for(int j=1; j<=N ;j++) {
//				System.out.print(map[i][j]+" ");
//			}System.out.println();
//		}System.out.println();
//	}

	private static void dfs(int r, int c, int cnt) {
		if (r == N && c == N) {
			MIN = Math.min(MIN, cnt);
			return;
		}
		if (MIN <= cnt) {
			return;
		}
		int dr, dc;
		for (int d = 0; d < 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if (check(dr, dc) && (cnt < visited[dr][dc])) {
				visited[dr][dc] = cnt;
				switch (map[dr][dc]) {
				case 0:
					dfs(dr, dc, cnt + 1);
					break;
				case 1:
					dfs(dr, dc, cnt);
					break;
				}
//				visited[dr][dc] = -1;
			}
		}
	}

	private static boolean check(int r, int c) {
		if (r == 0 || c == 0)
			return false;
		if (r == N + 1 || c == N + 1)
			return false;
		return true;
	}
}
