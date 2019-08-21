package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 홍익이의 오델로 게임
 */
public class Solution_d4_6731 {
	static int T, N, CNT;
	static boolean map[][], garo[], sero[];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/Solution_d4_6731.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new boolean[N][N];
			garo = new boolean[N];
			sero = new boolean[N];
			for (int i = 0, j = 0; i < N; i++, j = 0) {
				for (char c : in.readLine().toCharArray()) {
					switch (c) {
					case 'W':
						break;
					case 'B':
						map[i][j] = true;
						garo[j] = !garo[j];
						sero[i] = !sero[i];
						break;
					}
					j++;
				}
			}
			CNT = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] && !garo[j] && !sero[i]) {
						CNT++;
					}
				}
			}
			System.out.println("#"+test_case+" "+CNT);
		}
	}
}
