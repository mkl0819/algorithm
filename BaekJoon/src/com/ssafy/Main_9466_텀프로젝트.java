package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트 {
	static int T, N, numbers[][], cnt;
	static StringTokenizer st;

	public static void init() {
		for (int i = 0; i <= N; i++) {
			numbers[i][0] = i;
		}
	}

	public static int findSet(int n) {
		int p = numbers[n][0];
		if (p == n) {
			return n;
		}
		return findSet(p);
	}

	public static void unionSet(int s, int e) {
		int pe = findSet(e);

		numbers[s][0] = pe;
		numbers[s][1] = e;

		if (s == pe) {
			counting(s);
		}

	}

	private static void counting(int number) {
		int s = number, e = -1;
		while (true) {
			cnt--;
			e = numbers[s][1];
			if (e == number) {
				break;
			}
			s = e;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main_9466.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			numbers = new int[N + 1][2];
			init();
			cnt = N;
//			printMing.print(numbers);
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				unionSet(i, Integer.parseInt(st.nextToken()));
			}
//			printMing.print(numbers);
			System.out.println(cnt);
		}
	}
}
