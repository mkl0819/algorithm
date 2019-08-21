package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * visited를 안쓰려고 3차원 배열을 사용했더니
 * 메모리뿐만 아니라 시간도 늘었다
 * 좋은 방법이 아닌가보다 ㅠ_ㅠ
 *
 */
public class Solution_d4_7733_치즈도둑2 {
	static int T, N, X, MIN, MAX, PIECE, pieceCnt;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int cheese[][][];

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7733.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());

			MIN = 101;
			MAX = 0;
			PIECE = 1;

			cheese = new int[N + 2][N + 2][101];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= N; j++) {
					X = Integer.parseInt(st.nextToken());
					Arrays.fill(cheese[i][j], 1, X+1, 1);
					MIN = Math.min(MIN, X);
					MAX = Math.max(MAX, X);
				}
			}

			for (X = MIN; X <= MAX; X++) {
				pieceCnt = 0;
				findStartPoint();
				PIECE = Math.max(PIECE, pieceCnt);
			}
			System.out.println("#" + test_case + " " + PIECE);
		}
	}

	private static void findStartPoint() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cheese[i][j][X] == 1) {
					pieceCnt++;
					cheese[i][j][X] = 0;
					dfs(i, j);
				}
			}
		}
	}

	private static void dfs(int r, int c) {
		int dr, dc;

		for (int d = 0; d < 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if (cheese[dr][dc][X] == 1) {
				cheese[dr][dc][X] = 0;
				dfs(dr, dc);
			}
		}
	}

}
