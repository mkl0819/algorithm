package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17391_무한부스터 {
	static int N, M, map[][], dp[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		dp = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp();
		System.out.println(dp[1][1]);

	}

	private static void dp() {
		int r = N, c = M, booster = 0, min;

		// 마지막 행 채우기
		for (int j = c - 1; j > 0; j--) {
			min = Integer.MAX_VALUE - 1;
			booster = map[N][j];
			for (int k = booster; k > 0; k--) {
				if (check(N, j + k))
					min = Math.min(dp[N][j + k], min);
			}
			dp[N][j] = min + 1;
		}

		// 마지막 열 채우기
		for (int i = r - 1; i > 0; i--) {
			min = Integer.MAX_VALUE - 1;
			booster = map[i][M];
			for (int k = booster; k > 0; k--) {
				if (check(i + k, M))
					min = Math.min(dp[i + k][M], min);
			}
			dp[i][M] = min + 1;
		}

		// 나머지 채우기
		for (int i = r - 1; i > 0; i--) {
			for (int j = c - 1; j > 0; j--) {
				min = Integer.MAX_VALUE - 1;
				booster = map[i][j];
				for (int k = booster; k > 0; k--) {
					if (check(i, j + k))
						min = Math.min(dp[i][j + k], min);
					if (check(i + k, j))
						min = Math.min(dp[i + k][j], min);
				}
				dp[i][j] = min + 1;
			}
		}

	}

	private static boolean check(int r, int c) {
		if (r <= 0 || c <= 0 || r >= N + 1 || c >= M + 1)
			return false;
		else
			return true;
	}
}
