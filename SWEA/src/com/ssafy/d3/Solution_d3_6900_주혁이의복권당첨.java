package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_6900_주혁이의복권당첨 {
	static int T, N, M;
	static int WinningNum[][];
	static int Prize[][];
	static boolean check;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_6900.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			WinningNum = new int[N][8];
			Prize = new int[N][2];

			for (int i = 0, j = 0; i < N; i++, j = 0) {
				Arrays.fill(WinningNum[i], -1);
				st = new StringTokenizer(in.readLine());

				for (char c : st.nextToken().toCharArray()) {
					if (Character.isDigit(c)) {
						WinningNum[i][j] = c - '0';
					}
					j++;
				}
				Prize[i][0] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < M; i++) {
				CheckNum(in.readLine().toCharArray());
			}

			System.out.println("#" + test_case + " " + getSum());

		}
	}

	private static void CheckNum(char[] num) {
		for (int i = 0, j = 0; i < N; i++, j = 0) {
			check = true;
			for (char c : num) {
				if (WinningNum[i][j] != -1 && WinningNum[i][j] != c - '0') {
					check = false;
					break;
				}
				j++;
			}
			if(check) {
				Prize[i][1]++;
				return;
			}
		}
	}

	private static int getSum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Prize[i][1] * Prize[i][0];
		}
		return sum;
	}

	private static void print(int map[][]) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j <map[i].length; j++) {
				System.out.printf("%d  ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
