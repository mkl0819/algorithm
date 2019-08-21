package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17070_파이프{

	static int N;
	static int map[][];
	static int COUNT;
	static Queue<Integer> busQ;

	static StringTokenizer st;

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 1, 1 } }; // ���� ���� �밢��
	static int dir8[][] = {};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main17070.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());

		map = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				switch (Integer.parseInt(st.nextToken())) {
				case 0:
					map[i][j] = 1;
					break;
				case 1:
					map[i][j] = 0;
					break;
				}
			}
		}
		busQ = new LinkedList<Integer>();

		busQ.offer(1);
		busQ.offer(2);
		busQ.offer(0);

		COUNT = 0;
		bfs();
		System.out.println(COUNT);
	}

	private static void bfs() {
		int r, c, d;
		int dr, dc, dd;
		while (!busQ.isEmpty()) {
			for (int i = 0, size = busQ.size() / 3; i < size; i++) {
				r = busQ.poll();
				c = busQ.poll();
				d = busQ.poll();

				if (r == N && c == N) {
					COUNT++;
				}

				for (int j = 0; j < 3; j++) {
					if (d == 0 && j == 1) {
						continue;
					}
					if (d == 1 && j == 0) {
						continue;
					}
					dr = r + dir[j][0];
					dc = c + dir[j][1];
					dd = j;
					if (dd == 2 && !canGo(r, c)) {
						continue;
					}
					if (map[dr][dc] == 1) {
						busQ.offer(dr);
						busQ.offer(dc);
						busQ.offer(dd);
					}
				}
			}
		}
	}

	private static boolean canGo(int r, int c) {
		int dr, dc;
		for (int i = 0; i < 3; i++) {
			dr = r + dir[i][0];
			dc = c + dir[i][1];
			if (map[dr][dc] == 0) {
				return false;
			}
		}
		return true;
	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
