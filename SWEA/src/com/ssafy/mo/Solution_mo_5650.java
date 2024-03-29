package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

/*
 * 핀볼게임
 * -> 블랙홀 : -1
 * -> 빈공간 : 0
 * -> 벽 : 1~5
 * -> 웜홀 : 6~10
 */
public class Solution_mo_5650 {
	static final int R = 0, C = 1;
	static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

	static int T, N, map[][], blackHole[][], wormHole[][][], bsize, wsize, wormCheck[], curDir;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int dirmap[][] = { {}, { 2, 3, 1, 0 }, { 1, 3, 0, 2 }, { 3, 2, 0, 1 }, { 2, 0, 3, 1 }, { 2, 3, 0, 1 } };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_5650.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());

			map = new int[N][N];
			blackHole = new int[5][2];
			wormHole = new int[5][2][2];
			bsize = wsize = 0;
			wormCheck = new int[5];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					switch (map[i][j] = Integer.parseInt(st.nextToken())) {
					case -1:
						blackHole[bsize][R] = i;
						blackHole[bsize][C] = j;
						bsize++;
						break;
					case 0:
						break;
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
						break;
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
						int idx = map[i][j]-6;
						wormHole[idx][wormCheck[idx]][R] = i;
						wormHole[idx][wormCheck[idx]][C] = j;
						wormCheck[idx]++; wsize++;
						break;
					}
				}
			}
			printMing.print(map);
			printMing.print(blackHole);
			for(int i=0; i<5; i++) {
				System.out.println(i+6);
				printMing.print(wormHole[i]);
			}
		}
	}

}
