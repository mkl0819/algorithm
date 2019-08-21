package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1194 {
	static int N, M;
	static char map[][];
	static boolean visited[][][];
	static StringTokenizer st;

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static Queue<minsik> MSQ;

	static class minsik {
		int r, c, keys;

		public minsik(int r, int c, int keys) {
			super();
			this.r = r;
			this.c = c;
			this.keys = keys;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// input and init
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[1<<6][N][M];

		MSQ = new LinkedList<minsik>();

		for (int i = 0, j = 0; i < N; i++, j = 0) {
			for (char cur : map[i] = in.readLine().toCharArray()) {
				switch (cur) {
				case '0':
					map[i][j] = '.';
					visited[0][i][j] = true;
					MSQ.add(new minsik(i, j, 0));
					break;
				}
				j++;
			}
		}
		System.out.println(bfs());

	}

	private static int bfs() {
		int cnt = 0;

		minsik MS;
		int dr, dc, nkey, dkey, door;

		while (!MSQ.isEmpty()) {

			for (int i = 0, size = MSQ.size(); i < size; i++) {
				MS = MSQ.poll();
				dkey = MS.keys;
				for (int d = 0; d < 4; d++) {
					dr = MS.r + dir[d][0];
					dc = MS.c + dir[d][1];
					if (check(dr, dc) && !visited[dkey][dr][dc]) {
						switch (map[dr][dc]) {
						case '#':
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							door = (1 << map[dr][dc] - 'A');
							if ((door & dkey) == 0) {
								break;
							}
							visited[dkey][dr][dc] = true;
							MSQ.offer(new minsik(dr, dc, dkey));
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							nkey = dkey | (1 << (map[dr][dc] - 'a'));
							visited[nkey][dr][dc] = true;
							MSQ.offer(new minsik(dr, dc, nkey));
							break;
						case '.':
							visited[dkey][dr][dc] = true;
							MSQ.offer(new minsik(dr, dc, dkey));
							break;
						case '1':
							return cnt + 1;
						}
					}
				}
			}
			cnt++;
		}

		return -1;
	}

	private static boolean check(int r, int c) {
		if (r <= -1 || c <= -1)
			return false;
		if (r >= N || c >= M)
			return false;
		return true;
	}
}
