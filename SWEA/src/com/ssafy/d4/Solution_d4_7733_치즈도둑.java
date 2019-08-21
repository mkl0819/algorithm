package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_7733_치즈도둑 {
	static int T, N, X, MIN, MAX, PIECE, pieceCnt;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int cheese[][];
	static boolean visited[][];

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/Solution_d4_7733.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());

			MIN = 101;
			MAX = 0;
			PIECE = 1;

			cheese = new int[N + 2][N + 2];
			visited = new boolean[N + 2][N + 2];
//			printMing.print(visited);
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					MIN = Math.min(MIN, cheese[i][j]);
					MAX = Math.max(MAX, cheese[i][j]);
				}
			}
//			printMing.print(cheese);


			for (X = MIN; X < MAX; X++) {
				for (int i = 0; i < PIECE; i++) {
					pieceCnt = 0;
					visitedInit();
					eat(X);
//					printMing.print(cheese);
					findStartPoint();
					PIECE = Math.max(PIECE, pieceCnt);
//					System.out.print(X+"번째");
//					printMing.print("섬 개수", pieceCnt);
				}
			}
			System.out.println("#"+test_case+" "+PIECE);
//			printMing.print("DAY", X);
//			printMing.print("MIN", MIN);
//			printMing.print("MAX", MAX);

		}
	}

	private static void visitedInit() {
		for(int i=1; i<=N; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	private static void findStartPoint() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(!visited[i][j] && cheese[i][j]!=0) {
					pieceCnt++;
					visited[i][j] = true;
//					printMing.print(i, j);
					dfs(i, j);
//					System.out.println("visited");
//					printMing.print(visited);
				}
			}
		}
	}

	private static void eat(int day) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cheese[i][j] == day) {
					cheese[i][j] = 0;
				}
			}
		}
	}

	private static void dfs(int r, int c) {
		int dr, dc;

		for (int d = 0; d < 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if(!visited[dr][dc] && cheese[dr][dc]!=0) {
				visited[dr][dc] = true;
				dfs(dr, dc);
			}
		}
	}

}
