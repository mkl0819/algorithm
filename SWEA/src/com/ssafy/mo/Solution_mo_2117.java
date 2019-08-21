package com.ssafy.mo;
/* 
 * 홈 방범 서비스
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_mo_2117 {
	static int T, N, M, K, map[][], homecnt;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_2117.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			homecnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					switch (map[i][j] = Integer.parseInt(st.nextToken())) {
					case 1:
						homecnt++;
						break;
					}
				}
			}
//			K = 0;
			for (int i = 1;; i++) {
				if ((i * i) + (i - 1) * (i - 1) > homecnt * M) {
					K = i - 1;
					break;
				}
			}
			System.out.println(K);
		}
	}
}
