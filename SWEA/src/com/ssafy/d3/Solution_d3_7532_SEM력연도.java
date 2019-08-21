package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 7532. 세영이의 SEM력 연도
 * 
 * S는 365 E는 24 M 29 보다 커지면 1
 *
 */
public class Solution_d3_7532_SEM력연도 {
	static int T, S, E, M, s, e, m;
	static int tmp;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7532.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			tmp = S;
			while (true) {
				e = tmp % 24;
				m = tmp % 29;

				e = e == 0 ? 24 : e;
				m = m == 0 ? 29 : m;
				
				if(E==e && M==m) {
					break;
				}
				
				tmp += 365;
			}

			System.out.println("#" + test_case + " " + tmp);

		}
	}
}
