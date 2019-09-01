package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_16236_아기상어 {
	static int N, map[][], TIME, sharksize, fishcnt, babysharkR, babysharkC;
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
		sharksize = 2;
		fishcnt = 0;

//		printMing.print(map);
		run(babysharkR, babysharkC);
		System.out.println(TIME);
	}

	private static void run(int fr, int fc) {
		fish = new LinkedList<Integer>();
		fish.offer(fr);
		fish.offer(fc);
//		System.out.printf("( %d, %d) [size = %d] [cnt = %d] --> %d 초\n", fr, fc, sharksize, fishcnt, TIME);
		int r, c, dr, dc, t = 0, targetR, targetC;

		targetR = targetC = -1;

		visited = new boolean[N + 2][N + 2];
		visited[fr][fc] = true;

		while (!fish.isEmpty()) {
			t++;
//			System.out.println(fish);
			for (int i = 0, size = fish.size() / 2; i < size; i++) {
				r = fish.poll();
				c = fish.poll();
				if (map[r][c] != 0 && map[r][c] < sharksize) {
					if (targetR == -1) {
						targetR = r;
						targetC = c;
					} else {
						if (r < targetR) {
							targetR = r;
							targetC = c;
						} else if (r == targetR && c < targetC) {
							targetR = r;
							targetC = c;
						}
					}
				}
				for (int d = 0; d < 4; d++) {
					dr = r + dir[d][0];
					dc = c + dir[d][1];
					if (check(dr, dc) && !visited[dr][dc]) {
						if (sharksize < map[dr][dc]) {
							continue;
						}
						if (map[dr][dc] <= sharksize) {
							fish.offer(dr);
							fish.offer(dc);
							visited[dr][dc] = true;
						}
					}
				}
			}
			if(targetR!=-1) {
				map[targetR][targetC] = 0;
				fishcnt++;
				if (sharksize == fishcnt) {
					sharksize++;
					fishcnt = 0;
				}
//				TIME += Math.abs(targetR-fr);
//				TIME += Math.abs(targetC-fc);
				TIME += t-1;
				run(targetR, targetC);		
			}
		}
//		\
		
		return;
	}

	private static boolean check(int r, int c) {
		if (r == 0 || c == 0 || r == N + 1 || c == N + 1)
			return false;
		return true;
	}
}
