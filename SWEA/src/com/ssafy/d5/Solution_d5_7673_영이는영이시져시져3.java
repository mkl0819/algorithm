package com.ssafy.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Solution_d5_7673_영이는영이시져시져3 {
	static int T, N, result, number;
	static int map[][][];
	static int dir[][] = {{ 0, 1 }, { 1, 0 } };
	static boolean check[][], visited[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d5_7673.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N + 2][N + 2][3];
			check = new boolean[N + 2][N + 2];
			visited = new boolean[N + 2][N + 2];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= N; j++) {
					number = Integer.parseInt(st.nextToken());
					map[i][j][0] = number;
					if (number != 0) {
						map[i][j][1] = isMultipleOfTwo(number);
						map[i][j][2] = isMultipleOfFive(number);
					}
				}
			}

//			printMing.print("숫자", map, 0);
//			printMing.print("2의 배수", map, 1);
//			printMing.print("5의 배수", map, 2);
			check[1][1] = true;

			dfs(1, 1);

//			printMing.print("숫자", map, 0);
//			printMing.print("2의 배수", map, 1);
//			printMing.print("5의 배수", map, 2);

			System.out.println("#"+test_case+" "+Math.min(map[1][1][1], map[1][1][2]));
		}
	}

	private static int[] dfs(int r, int c) {
		if (r == N && c == N) {
			return map[r][c];
		}
		if(visited[r][c]) {
			return map[r][c];
		}
		int dr, dc;
		int value[];
		int count = 0;
		for (int d = 0; d < 2; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if (!check[dr][dc] && map[dr][dc][0] != 0) {
				check[dr][dc] = true;
				visited[r][c] = true;
				value = dfs(dr, dc);
				if (count >= 1) {
					map[r][c][1] = Math.min(map[r][c][1], map[r][c][1] + value[1]);
					map[r][c][2] = Math.min(map[r][c][2], map[r][c][2] + value[2]);
				} else {
					map[r][c][1] += value[1];
					map[r][c][2] += value[2];
				}
				count++;
				check[dr][dc] = false;
			}
		}
		return map[r][c];
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
}
