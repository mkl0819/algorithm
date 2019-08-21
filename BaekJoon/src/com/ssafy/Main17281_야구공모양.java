package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 17281. 야구공모양
 * 
 * 입력 #1 2 4 0 0 0 0 0 0 0 0 4 0 0 0 0 0 0 0 0 #2 2 4 0 0 0 1 1 1 0 0 0 0 0 0 0
 * 0 0 0 0 #3 2 0 4 4 4 4 4 4 4 4 0 4 4 4 4 4 4 4 4 #4 2 4 3 2 1 0 4 3 2 1 1 2 3
 * 4 1 2 3 4 0 #5 9 4 4 4 4 4 4 4 4 0 4 4 4 4 4 4 4 4 0 4 4 4 4 4 4 4 4 0 4 4 4
 * 4 4 4 4 4 0 4 4 4 4 4 4 4 4 0 4 4 4 4 4 4 4 4 0 4 4 4 4 4 4 4 4 0 4 4 4 4 4 4
 * 4 4 0 4 4 4 4 4 4 4 4 0 #6 9 1 2 4 3 0 2 1 0 3 1 2 1 2 0 0 0 0 1 3 4 2 3 1 2
 * 3 4 0 0 1 2 3 4 2 1 0 0 0 0 0 0 0 0 1 4 4 0 4 0 4 0 4 0 4 0 0 4 2 2 2 2 2 2 2
 * 1 1 1 1 1 1 1 1 0 0 2 0 3 0 1 0 2 0
 * 
 * 출력 #1 1 #2 2 #3 43 #4 46 #5 216 #6 89
 *
 */
public class Main17281_야구공모양 {
	static int N;
	static int scoreMap[][];
	static StringTokenizer st;

	static boolean status[];
	static int outCnt;
	static int score;
	static int player;

	static int playerTable[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main17281.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());

		scoreMap = new int[N][9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				scoreMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		playerTable = new int[9];
		playerTable[0] = 0;
		permu(1, 0);
	}

	private static void permu(int cnt, int flag) {
		if (cnt == 9) {
			System.out.println(Arrays.toString(playerTable));
			return;
		}
		for (int i = 1; i < 9; i++) {
			if ((flag & (1 << i)) == 0) {
				playerTable[cnt] = i;
				permu(cnt + 1, flag | 1 << i);
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%d ", scoreMap[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
