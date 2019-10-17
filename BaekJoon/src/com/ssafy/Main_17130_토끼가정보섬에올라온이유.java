package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * . -> 0 : 빈 공간
 * # -> 9 : 벽
 * C -> 1 : 당근
 * O -> 5 : 문
 */

public class Main_17130_토끼가정보섬에올라온이유 {
	static int N, M, map[][], R, C, maxCarrot, dp[][];
	static int dir[][] = { { 1, 1 }, { 0, 1 }, { -1, 1 } };

	static boolean visited[][];

	static StringTokenizer st;
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];
		maxCarrot = -1;
		visited = new boolean[N][M];

		for (int i = 0, j = 0; i < N; i++) {
			j = 0;
			str = in.readLine();
			for (char ch : str.toCharArray()) {
				switch (ch) {
				case '.':
					break;
				case '#':
					map[i][j] = 9;
					break;
				case 'R':
					R = i;
					C = j;
					visited[R][C] = true;
					break;
				case 'C':
					map[i][j] = 1;
					break;
				case 'O':
					map[i][j] = 5;
					break;
				default:
					break;
				}
				j++;
			}
		}
		dp();

		System.out.println(maxCarrot);
	}

	private static void dp() {
		int max = 0, dr, dc;

		visited[R][C] = true;

		for (int j = C; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (visited[i][j]) {
					max = dp[i][j];
					for (int d = 0; d < 3; d++) {
						dr = i + dir[d][0];
						dc = j + dir[d][1];
						if (check(dr, dc) && map[dr][dc] != 9) {
							if (map[dr][dc] == 1) {
								dp[dr][dc] = Math.max(max + 1, dp[dr][dc]);
							} else {
								dp[dr][dc] = Math.max(max, dp[dr][dc]);
							}
							visited[dr][dc] = true;
						}
					}
					if (map[i][j] == 5) {
						maxCarrot = Math.max(maxCarrot, max);
					}
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		if (r == -1 || c == -1 || r == N || c == M)
			return false;
		return true;
	}
}
