package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_3190_뱀2 {
	static int N, K, L, map[][], sec;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static char timelist[];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		K = Integer.parseInt(in.readLine().trim());
		map = new int[N + 1][N + 1];
		timelist = new char[10001];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(in.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		map[1][1] = 2;
		printMing.print(map);
		L = Integer.parseInt(in.readLine().trim());
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(in.readLine());
//			System.out.println(st.nextToken()+" / "+st.nextToken());
			timelist[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
//			move(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}

		for (char t : timelist) {
			if (t != 0) {
				System.out.println(t + " ");
			}
		}
		sec = 0;
		run(1, 1, 1, 1, 1);
		System.out.println(sec);
	}

	private static void run(int sr, int sc, int er, int ec, int d) {
		int dr, dc, dd;
		if (timelist[sec] != 0) {
			dd = changeD(d, timelist[sec]);
		} else
			dd = d;

		dr = dir[d][0] + sr;
		dc = dir[d][1] + sc;

		if (!check(dr, dc)) {
			return;
		}

		if (map[dr][dc] == 1) {
			map[dr][dc] = 2;
			run(dr, dc, er, ec, dd);
		} else if (map[dr][dc] == 0) {

		}
	}

	private static boolean check(int r, int c) {
		if (r == 0 || c == 0 || r == N + 1 || c == N + 1)
			return false;
		return true;
	}

	private static void move(int count, char dir) {
		System.out.println(count + " / " + dir);

	}

	private static int changeD(int pre, char C) {
		return C == 'D' ? ((pre + 1) % 4) : ((pre + 3) % 4);
	}
}
