package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구슬 탈출 2
 *
 */
public class Main13460_bit {
	static int N, M, BLUE, RED, HOLE, garo[], sero[];
	static char map[][];

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		garo = new int[N];
		sero = new int[M];
		for (int i = 0, j = 0; i < N; i++, j = 0) {
			for (char c : map[i] = in.readLine().toCharArray()) {
				if (c == '#') {
					garo[i] = (garo[i] << 1) + 1;
					sero[j] = (sero[j] << 1) + 1;
				} else {
					garo[i] <<= 1;
					sero[j] <<= 1;
					if (c == 'B') {
						BLUE = i * 100 + j;
					} else if (c == 'R') {
						RED = i * 100 + j;
					} else if (c == 'O') {
						HOLE = i * 100 + j;
					}
				}
				j++;
			}
		}
		print();
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Integer.toBinaryString(garo[i]));
//			System.out.println(map[i]);
		}
		System.out.println();
		for (int i = 0; i < M; i++) {
			System.out.println(Integer.toBinaryString(sero[i]));
//			System.out.println(map[i]);
		}
		System.out.println("B : " + BLUE / 100 + ", " + BLUE % 100);
		System.out.println("R : " + RED / 100 + ", " + RED % 100);
		System.out.println("H : " + HOLE / 100 + ", " + HOLE % 100);
	}

}
