package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int N, M, X, Y, K, map[][], dice[];
	static int dir[][] = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int move[][] = { {}, 
			{ 0, 4, 2, 1, 6, 5, 3 }, 
			{ 0, 3, 2, 6, 1, 5, 4 }, 
			{ 0, 5, 1, 3, 4, 6, 2 },
			{ 0, 2, 6, 3, 4, 1, 5 } };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dice = new int[7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			moveDice(Integer.parseInt(st.nextToken()));
		}
	}

	private static void moveDice(int d) {
		int dr = X + dir[d][0];
		int dc = Y + dir[d][1];
		if (check(dr, dc)) {
			rollDice(d);
			if (map[dr][dc] == 0) {
				map[dr][dc] = dice[6];
			} else {
				dice[6] = map[dr][dc];
			}
			System.out.println(dice[1]);

			X = dr;
			Y = dc;
		}
	}

	private static boolean check(int r, int c) {
		if (r == -1 || c == -1 || r == N || c == M)
			return false;
		return true;
	}

	private static void rollDice(int d) {
		int tmp[] = new int[7];

		for (int i = 1; i <= 6; i++) {
			tmp[i] = dice[i];
		}
		for (int i = 1; i <= 6; i++) {
			dice[i] = tmp[move[d][i]];
		}

	}
}
