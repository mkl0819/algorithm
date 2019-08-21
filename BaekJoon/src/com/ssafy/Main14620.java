package com.ssafy;
/*
 * 꽃길
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14620 {
	static int N, map[][];
	static boolean visited[][];
	static int SUM, MIN;

	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());

		map = new int[N + 2][N + 2];
		visited = new boolean[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		SUM = 0;
		MIN = Integer.MAX_VALUE;
		printV();
		combi(2, 2, 0);
		System.out.println(MIN);
	}

	private static void combi(int r, int c, int cnt) {
		if (cnt == 3) {
			System.out.println();
			printV();
			MIN = Math.min(MIN, SUM);
			return;
		}
		for (int i = r; i < N; i++) {
			for (int j = c; j < N; j++) {
				System.out.println("("+i+", "+j+") 검사");
				if (!isVisited(i, j)) {
					System.out.println("방문가능");
					SUM += Visit(i, j, true);
					if (j + 1 < N) {
						System.out.println("->");
						combi(i, j + 1, cnt + 1);
					} 
					else {
						System.out.println("next line");
						combi(i + 1, 2, cnt + 1);
					}
					SUM -= Visit(i, j, false);
				}
			}
		}
	}
	private static void printV() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(visited[i][j]? 1:0);
			}System.out.println();
		}System.out.println();
	}
	private static boolean isVisited(int r, int c) {
		if (visited[r][c])
			return true;
		int dr, dc;
		for (int d = 0; d < 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if (visited[dr][dc]) {
				return true;
			}
		}
		return false;
	}

	private static int Visit(int r, int c, boolean tof) {
		visited[r][c] = tof;
		int dr, dc, sum = map[r][c];
		for (int d = 0; d < 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			visited[dr][dc] = tof;
			sum += map[dr][dc];
		}
		return sum;
	}
}
