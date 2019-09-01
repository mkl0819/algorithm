package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_16236_아기상어2 {
	static int N, map[][], TIME, size, fishcnt, babysharkR, babysharkC;
	static int dir[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static boolean visited[][];
	static Queue<Integer> fish;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		map = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					babysharkR = i;
					babysharkC = j;
					map[i][j] = 0;
				}
			}
		}

		TIME = 0;
		size = 2;
		fishcnt = 0;
		fish = new LinkedList<Integer>();
		fish.offer(babysharkR);
		fish.offer(babysharkC);
		printMing.print(map);
		run();
		System.out.println(TIME+"초");
	}

	private static void run() {
		int r, c, dr, dc, t=0;
		boolean flag = true;
		visited = new boolean[N + 2][N + 2];
		while (!fish.isEmpty()) {
			System.out.println(fish);
			t++;
			for (int i = 0, size = fish.size() / 2; i < size; i++) {
				r = fish.poll();
				c = fish.poll();
				if (map[r][c] != 0 && map[r][c] < size) {
					System.out.println(map[r][c]);
					TIME += t -1;
					return;
				}
				for (int d = 0; d < 4; d++) {
					dr = r + dir[d][0];
					dc = c + dir[d][1];
					if (check(dr, dc) && !visited[dr][dc]) {
						if (size < map[dr][dc]) {
							continue;
						}
						if (map[dr][dc] <= size) {
							fish.offer(dr);
							fish.offer(dc);
							visited[dr][dc] = true;
						}
					}
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		if (r == 0 || c == 0 || r == N + 1 || c == N + 1)
			return false;
		return true;
	}
}
