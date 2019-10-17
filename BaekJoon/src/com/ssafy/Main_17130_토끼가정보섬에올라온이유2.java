package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * . -> 0 : 빈 공간
 * # -> 9 : 벽
 * C -> 1 : 당근
 * O -> 5 : 문
 */

public class Main_17130_토끼가정보섬에올라온이유2 {
	static int N, M, map[][], R, C, maxCarrot;
	static int dir[][] = { { 1, 1 }, { 0, 1 }, { -1, 1 } };

	static boolean visited[][];

	static StringTokenizer st;
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		maxCarrot = -1;
		visited = new boolean[N][M];

		for (int i = 0, j = 0; i < N; i++) {
			j = 0;
			str = in.readLine();
			for (char ch : str.toCharArray()) {
				switch (ch) {
				case '.':
					break;
				case '#':
					map[i][j] = 9;
					break;
				case 'R':
					R = i;
					C = j;
					visited[R][C] = true;
					break;
				case 'C':
					map[i][j] = 1;
					break;
				case 'O':
					map[i][j] = 5;
					break;
				default:
					break;
				}
				j++;
			}
		}
		bfs();

		System.out.println(maxCarrot);
	}

	private static void bfs() {
		Queue<Integer> rabbit = new LinkedList<Integer>();

		int r, c, count, dr, dc, dcount;

		rabbit.offer(R);
		rabbit.offer(C);
		rabbit.offer(0);

		while (!rabbit.isEmpty()) {
			for (int i = 0, size = rabbit.size() / 3; i < size; i++) {
				r = rabbit.poll();
				c = rabbit.poll();
				count = rabbit.poll();
				for (int d = 0; d < 3; d++) {
					dr = r + dir[d][0];
					dc = c + dir[d][1];
					dcount = count;
					if (check(dr, dc) && !visited[dr][dc] && map[dr][dc] != 9) {
						switch (map[dr][dc]) {
						case 0:
							break;
						case 1:
							dcount++;
							break;
						case 5:
							if (maxCarrot < dcount) {
								maxCarrot = dcount;
							}
							break;
						}
						rabbit.offer(dr);
						rabbit.offer(dc);
						rabbit.offer(dcount);
						visited[dr][dc] = true;
					}
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		if (r == -1 || c == -1 || r == N || c == M)
			return false;
		return true;
	}
}
