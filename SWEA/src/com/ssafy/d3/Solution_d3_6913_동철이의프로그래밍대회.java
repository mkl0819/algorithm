package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_6913_동철이의프로그래밍대회 {
	static int T, N, M, MAX, cnt;
	static int score[];

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_6913.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			score = new int[N + 1];

			MAX = -1;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						score[i]++;
					}
				}
				MAX = Math.max(MAX, score[i]);
			}
			cnt = 0;
			for(int i=1; i<=N; i++) {
				if(score[i] == MAX) {
					cnt++;
				}
			}
			System.out.println("#"+test_case+" "+cnt+" "+MAX);
		}
	}
}
