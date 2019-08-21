package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3055 {
	static class data {
		int r, c;
		int cnt;

		public data(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "data [ r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

	}

	static int R, C, D, S;
	static char map[][];
	static boolean visited[][];
	static Queue<data> sq, wq;
	static StringTokenizer st;

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main3055.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		sq = new LinkedList<data>();
		wq = new LinkedList<data>();

		for (int i = 0, j = 0; i < R; i++, j = 0) {
			for (char c : in.readLine().toCharArray()) {
				switch (c) {
				case 'D':
					D = i * 100 + j;
					break;
				case 'S':
					S = i * 100 + j;
					sq.offer(new data(i, j, 0));
					c = '.';
					break;
				case '*':
					wq.offer(new data(i, j, 0));
					break;
				case 'X':
					break;
				case '.':
					break;
				}
				map[i][j++] = c;
			}
		}
//		print();
		bfs();
	}

	private static void bfs() {
		data cur;
		int dr, dc;
		char dt;
		while (!sq.isEmpty()) {
//			System.out.println(sq);
//			System.out.println(wq);

			for (int i = 0, size = wq.size(); i < size; i++) {
				cur = wq.poll();
				for (int d = 0; d < 4; d++) {
					dr = cur.r + dir[d][0];
					dc = cur.c + dir[d][1];
//					System.out.println(dr + ", " + dc);
					if (check(dr, dc) && map[dr][dc] == '.') {
						map[dr][dc] = '*';
						wq.offer(new data(dr, dc, cur.cnt + 1));
					}
				}
			}
			for (int i = 0, size = sq.size(); i < size; i++) {
				cur = sq.poll();
				for (int d = 0; d < 4; d++) {
					dr = cur.r + dir[d][0];
					dc = cur.c + dir[d][1];
					if (check(dr, dc) && !visited[dr][dc]) {
						visited[dr][dc] = true;
						if (map[dr][dc] == '.') {
							sq.offer(new data(dr, dc, cur.cnt + 1));
						} else if (map[dr][dc] == '*') {
							continue;
						} else if (map[dr][dc] == 'D') {
							System.out.println(cur.cnt + 1);
							return;
						}
					}
				}
			}
//			print();
		}
		System.out.println("KAKTUS");
		return;
	}

	private static boolean check(int r, int c) {
		if (r < 0 || c < 0)
			return false;
		if (r >= R || c >= C)
			return false;
		return true;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
