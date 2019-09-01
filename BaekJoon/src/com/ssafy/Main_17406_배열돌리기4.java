package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_17406_배열돌리기4 {
	static int N, M, K, map[][], order[], r, c, s, copymap[][][], MIN;
	static HashMap<Integer, Integer[]> rotation;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		copymap = new int[K][N + 1][M + 1];
		MIN = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotation = new HashMap<>();

		for (Integer i = 0, array[]; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			array = new Integer[3];
			for (int j = 0; j < 3; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}
			rotation.put(i, array);
		}

//		printMing.print(map);

//		for (Integer i : rotation.keySet()) {
//			printMing.print(rotation.get(i));
//		}

		order = new int[K];
		permu(0, 0);

		System.out.println(MIN);

	}

	private static void changeMap(int[][] premap, int[][] curmap, Integer[] array) {
		r = array[0];
		c = array[1];
		s = array[2];
		int sr = r - s, sc = c - s, er = r + s, ec = c + s;
//		printMing.print(array);
//		System.out.printf("(%d, %d) 부터 (%d, %d)\n", sr, sc, er, ec);

		curmap[r][c] = premap[r][c];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (i < sr || er < i || j < sc || ec < j)
					curmap[i][j] = premap[i][j];

			}
		}

//		printMing.print(curmap);

//		System.out.println("밑에거를 배낄거야");
//		printMing.print(premap);

		while (sr < er && sc < ec) {
			for (int j = sc; j < ec; j++) {
				curmap[sr][j + 1] = premap[sr][j];
			}
			for (int i = sr; i < er; i++) {
				curmap[i + 1][ec] = premap[i][ec];
			}
			for (int j = ec; j > sc; j--) {
				curmap[er][j - 1] = premap[er][j];
			}
			for (int i = er; i > sr; i--) {
				curmap[i - 1][sc] = premap[i][sc];
			}
			sr++;
			sc++;
			er--;
			ec--;
		}
//		printMing.print(curmap);

	}

	private static void permu(int count, int flag) {
		if (count == K) {
//			printMing.print(order);
//			printMing.print(copymap[K-1]);
			MIN = Math.min(MIN, getMin(copymap[K - 1]));
//			System.out.println("=========완성");
			return;
		}
		for (int i = 0; i < K; i++) {
			if ((flag & (1 << i)) == 0) {
				order[count] = i;
//				System.out.println("쌓이는 과정 : " + count);
//				printMing.print(order, count);
				if (count == 0)
					changeMap(map, copymap[0], rotation.get(i));
				else
					changeMap(copymap[count - 1], copymap[count], rotation.get(i));
				permu(count + 1, flag | 1 << i);
			}
		}
	}

	private static int getMin(int rotationed[][]) {
		int min = Integer.MAX_VALUE;

		for (int i = 1, sum; i <= N; i++) {
			sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += rotationed[i][j];
			}
			min = Math.min(min, sum);
		}

		return min;
	}
}
