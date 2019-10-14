package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {
	static int N, M, map[], ladders[][], snakes[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		map = new int[101];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ladders = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			ladders[i][0] = Integer.parseInt(st.nextToken());
			ladders[i][1] = Integer.parseInt(st.nextToken());
		}
		snakes = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			snakes[i][0] = Integer.parseInt(st.nextToken());
			snakes[i][1] = Integer.parseInt(st.nextToken());
			map[snakes[i][0]] = -1;
		}
		dp();
		dp();
		System.out.println(map[1]);
	}

	private static void dp() {
		for (int i = 100; i > 0; i--) {
			if (map[i] == -1)
				continue;
			for (int j = 1; j <= 6; j++) {
				if (0 < (i - j)) {
					switch (map[i - j]) {
					case -1:
						break;
					case 0:
						map[i - j] = map[i] + 1;
						break;
					default:
						map[i - j] = Math.min(map[i - j], map[i] + 1);
						break;
					}
				}
			}
			for (int j = 0; j < N; j++) {
				if (ladders[j][1] == i) {
					map[ladders[j][0]] = map[i];
				}
			}
			for (int j = 0; j < M; j++) {
				if (snakes[j][1] == i) {
					map[snakes[j][0]] = map[i];
				}
			}
		}
	}
}
