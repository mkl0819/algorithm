package com.ssafy.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d5_7673_영이는영이시져시져 {
	static int T, N, result, number;
	static int map[][], twoMap[][], fiveMap[][];
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean check[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d5_7673.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N + 2][N + 2];
			twoMap = new int[N + 2][N + 2];
			fiveMap = new int[N + 2][N + 2];
			check = new boolean[N + 2][N + 2];
			for (int rowindex = 1; rowindex <= N; rowindex++) {
				st = new StringTokenizer(in.readLine());
				for (int columnindex = 1; columnindex <= N; columnindex++) {
					number = Integer.parseInt(st.nextToken());
					map[rowindex][columnindex] = number;
					twoMap[rowindex][columnindex] = isMultipleOfTwo(number);
					fiveMap[rowindex][columnindex] = isMultipleOfFive(number);
				}
			}

			result = Integer.MAX_VALUE;
			
			dfs(1, 1, twoMap[1][1], fiveMap[1][1]);

			System.out.println(result);
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
			return ( 1 + isMultipleOfFive(number/5) );
		} else {
			return 0;
		}
	}

	private static void dfs(int row, int col, int numberOfTwo, int numberOfFive) {
		int numberOfZero = Math.min(numberOfTwo, numberOfFive);
		if(result < numberOfZero) {
			return;
		}
		if (row == N && col == N) {
			result = Math.min(result, numberOfZero);
		}
		int directionRow, directionCol;
		for (int direction = 0; direction < 4; direction++) {
			directionRow = row + dir[direction][0];
			directionCol = col + dir[direction][1];
			if (!check[directionRow][directionCol] && map[directionRow][directionCol] != 0) {
				check[directionRow][directionCol] = true;
				dfs(directionRow, directionCol, 
						numberOfTwo + twoMap[directionRow][directionCol], 
						numberOfFive + fiveMap[directionRow][directionCol]);
				check[directionRow][directionCol] = false;
			}
		}
	}
}
