package com.ssafy.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Solution_d5_7673_영이는영이시져시져2 {
	static int T, N, result, number;
	static int twoMap[][], fiveMap[][];
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean check[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d5_7673.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T=1;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			twoMap = new int[N + 2][N + 2];
			fiveMap = new int[N + 2][N + 2];
			check = new boolean[N + 2][N + 2];
			Arrays.fill(twoMap[0], -1);
			Arrays.fill(twoMap[N+1], -1);
			for (int i = 1; i <= N; i++) {
				twoMap[i][0] = -1;
				twoMap[i][N+1] = -1;
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= N; j++) {
					number = Integer.parseInt(st.nextToken());
					if (number == 0) {
						twoMap[i][j] = -1;
					} else {
						twoMap[i][j] = isMultipleOfTwo(number);
						fiveMap[i][j] = isMultipleOfFive(number);
					}
				}
			}

			printMing.print(twoMap);
			printMing.print(fiveMap);
			check[1][1] = true;
			dfs(1, 1);
			printMing.print(twoMap);
			printMing.print(fiveMap);

			System.out.println(Math.min(twoMap[1][1], fiveMap[1][1]));
		}
	}

	private static int isMultipleOfTwo(int number) {
		if (number % 2 == 0 && number > 0) {
			return 1 + isMultipleOfTwo(number >> 1);
		} else {
			return 0;
		}
	}

	private static int isMultipleOfFive(int number) {
		if (number % 5 == 0 && number > 0) {
			return (1 + isMultipleOfFive(number / 5));
		} else {
			return 0;
		}
	}

	private static void dfs(int row, int col) {
		if (row == N && col == N) {
			return;
		}
		int dr, dc;
		for (int d = 0; d < 4; d++) {
			dr = row + dir[d][0];
			dc = col + dir[d][1];
			if (!check[dr][dc] && twoMap[dr][dc] != -1) {
				check[dr][dc] = true;
				dfs(dr, dc);
//				System.out.println(row+", "+col+" 에서  "+d+"방향 : ");
				twoMap[row][col] 	= Math.min(twoMap[row][col], twoMap[dr][dc]) ;
				fiveMap[row][col]	= Math.min(fiveMap[row][col], fiveMap[dr][dc]);
//				printMing.print(twoMap);
//				printMing.print(fiveMap);
				check[dr][dc] = false;
			}
		}
	}
}
