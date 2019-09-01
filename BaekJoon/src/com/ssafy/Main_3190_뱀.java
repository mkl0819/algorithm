package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_3190_뱀 {
	static int N, K, L, map[][], sec;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static ArrayList<Integer> snake;
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

//		printMing.print(map);

		L = Integer.parseInt(in.readLine().trim());
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(in.readLine());
			timelist[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}

		sec = 1;
		map[1][1] = 2;
		snake = new ArrayList<>();
		snake.add(1);
		snake.add(1);
		run(1, 1, 1);
		System.out.println(sec);
	}

	private static void run(int r, int c, int d) {
//		System.out.printf("(%d, %d) 방향은  %d 값은 %d\n", r, c, d, map[r][c]);
		int dr, dc, dd;
		
		if (timelist[sec] != 0) {
			dd = changeD(d, timelist[sec]);
		} else
			dd = d;

		dr = dir[d][0] + r;
		dc = dir[d][1] + c;

		if (!check(dr, dc)) {
//			System.out.println("벽이라 죽음");
			return;
		}

		if (map[dr][dc] == 1) {
			map[dr][dc] = 2;
			snake.add(dr);
			snake.add(dc);
			sec++;
			run(dr, dc, dd);
		} else if (map[dr][dc] == 0) {
			map[dr][dc] = 2;
			snake.add(dr);
			snake.add(dc);
			int er = snake.remove(0);
			int ec = snake.remove(0);
			map[er][ec] = 0;
			sec++;
			run(dr, dc, dd);
		} else if (map[dr][dc]==2) {
//			System.out.println("자기 몸에 부딪혀서 죽음");
			return;
		}
	}

	private static boolean check(int r, int c) {
		if (r == 0 || c == 0 || r == N + 1 || c == N + 1)
			return false;
		return true;
	}

	private static int changeD(int pre, char C) {
		return C == 'D' ? ((pre + 1) % 4) : ((pre + 3) % 4);
	}
}
