package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14891 {
	static int wheel[];
	static int K, N;
	static boolean visited[];
	static int LP = 1, RP = 5;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main14891.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		wheel = new int[5];

		for (int i = 1; i <= 4; i++) {
			wheel[i] = Integer.parseInt(in.readLine(), 2);
		}
		K = Integer.parseInt(in.readLine());

		visited = new boolean[5];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			Arrays.fill(visited, false);
			trun(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		System.out.println(gerScore());
	}

	private static int gerScore() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += ((wheel[i + 1] & (1 << 7)) >> 7) * (1 << i);
		}
		return sum;
	}

	private static void trun(int index, int dir) {
		visited[index] = true;

		if (1 < index && !visited[index - 1]) {
			if (((wheel[index - 1] & (1 << RP)) >> RP) != ((wheel[index] & (1 << LP)) >> LP)) {
				trun(index - 1, 0 - dir);
			}
		}
		if (index < 4 && !visited[index + 1]) {
			if (((wheel[index] & (1 << RP)) >> RP) != ((wheel[index + 1] & (1 << LP)) >> LP)) {
				trun(index + 1, 0 - dir);
			}
		}
		if (dir == 1) {
			right(index);
		} else {
			left(index);
		}
	}

	private static void right(int i) {
		int tmp = wheel[i] % 2;
		wheel[i] = wheel[i] >> 1;
		wheel[i] += tmp * 128;
	}

	private static void left(int i) {
		int tmp = wheel[i] / 128;
		wheel[i] %= 128;
		wheel[i] = wheel[i] << 1;
		wheel[i] += tmp;
	}
}