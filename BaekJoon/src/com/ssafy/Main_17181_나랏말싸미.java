package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

/*
 * 자음 : Consonant
 * 모음 : Collection
 */
public class Main_17181_나랏말싸미 {
	static final int CONSONANT = 0, COLLECTION = 1, BOTH = 2;
	static int N, M, map[][], MIN;
	static int dir[][] = { {}, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean visited[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		MIN = Integer.MAX_VALUE - 1;
		if (type(map[0][0]) == COLLECTION) {
			System.out.println("BAD");
			return;
		}
		visited[0][0] = true;

		dfs(0, 0, 0, COLLECTION);
		System.out.println(MIN == Integer.MAX_VALUE - 1 ? "BAD" : MIN);
		return;
	}

	private static void dfs(int r, int c, int collection, int wanted) {
		System.out.printf(" ( %d, %d ) , length : %3d, wanted : %d\n", r, c, collection, wanted);
		if (collection > 820) {
		}
		if (MIN < collection) {
			return;
		}
		if (r == N - 1 && c == M - 1 && wanted != COLLECTION) {
			MIN = Math.min(MIN, collection);
			return;
		}
		int dr, dc, dtype;
		for (int d = 1; d <= 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if (check(dr, dc) && !visited[dr][dc]) {
				dtype = type(map[dr][dc]);
				if (wanted == 1 - dtype) {
					continue;
				}
				switch (dtype) {
				case CONSONANT:
					if (wanted == 2) {
						visited[dr][dc] = true;
						dfs(dr, dc, collection, COLLECTION);
						visited[dr][dc] = false;
					} else {
						visited[dr][dc] = true;
						dfs(dr, dc, collection, BOTH);
						visited[dr][dc] = false;
					}
					break;
				case COLLECTION:
					visited[dr][dc] = true;
					dfs(dr, dc, collection + 1, CONSONANT);
					visited[dr][dc] = false;
					break;
				}

			}
		}
	}

	private static int type(int num) {
		return num < 14 ? CONSONANT : COLLECTION;
	}

	private static boolean check(int dr, int dc) {
		if (dr == -1 || dr == N || dc == -1 || dc == M) {
			return false;
		}
		return true;
	}

}
