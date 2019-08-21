package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2298_이민경{
	static int N;
	static int map[][];
	static int min, max;
	static int ANS;
	static Queue<Integer> q;
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main2298.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());

		map = new int[N + 2][N + 2];

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = min < map[i][j] ? min : map[i][j];
				max = max < map[i][j] ? map[i][j] : max;
			}
		}
		print();

		System.out.println(min + " / " + max);
		ANS = 0;
		q = new LinkedList<Integer>();
//		for(int i=min; i<max; i++) {
//			ANS = Math.max(ANS, safeZone(i));
//			q.clear();
//		}
		safeZone(2);
		print();
	}

	private static int safeZone(int n) {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (n < map[i][j]) {
					System.out.println(map[i][j] + "�˻�");
					q.offer(i);
					q.offer(j);
					bfs(n);
					cnt++;
				}
			}
			System.out.println();
		}
		System.out.println(cnt);
		return cnt;
	}

	private static void bfs(int n) {
		int r, c, dr, dc;
		while (!q.isEmpty()) {
			for (int i = 0, size = q.size() / 2; i < size; i++) {
				r = q.poll();
				c = q.poll();
				map[r][c] = (-1) * map[r][c];
				for (int d = 0; d < 4; d++) {
					dr = r + dir[d][0];
					dc = c + dir[d][1];
					if (n < map[dr][dc]) {
						q.offer(dr);
						q.offer(dc);
					}
				}
				print();
			}
		}
	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.printf("%4d  ", map[i][j]);
			}
			System.out.println();
		}System.out.println();

	}
}
