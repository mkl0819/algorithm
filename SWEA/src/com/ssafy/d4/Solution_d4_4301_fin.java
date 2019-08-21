package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 콩 많이 심기
 */
public class Solution_d4_4301_fin {
	static int T, N, M, map[][], cnt;
	static int dir[][] = { { 0, 2 }, { 2, 0 }, { 0, -2 }, { -2, 0 } };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/Solution_d4_4301.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			cnt = N*M;
			int dr, dc;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							dr = i + dir[d][0];
							dc = j + dir[d][1];
							if (check(dr, dc) && map[dr][dc] == 0) {
								map[dr][dc] = 1;
								cnt--;
							}
						}
					}
				}
			}
			print();
			System.out.println("#"+test_case+" "+cnt);
		}
	}

	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

	private static boolean check(int r, int c) {
		if (r < 0 || c < 0)
			return false;
		if (r >= N || c >= M)
			return false;
		return true;
	}
}
