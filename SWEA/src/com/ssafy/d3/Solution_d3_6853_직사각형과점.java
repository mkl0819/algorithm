package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_6853_직사각형과점 {
	static int T, x1, x2, y1, y2, tmp, N, x, y;
	static int inner, line, outer;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_6853.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			if (x2 < x1) {
				tmp = x1;
				x1 = x2;
				x2 = tmp;
			}
			if (y2 < y1) {
				tmp = y1;
				y1 = y2;
				y2 = tmp;
			}

			N = Integer.parseInt(in.readLine());
			inner = line = outer = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if (x < x1 || x2 < x || y < y1 || y2 < y) {
					outer++;
				} else if (x == x1 || x == x2 || y == y1 || y == y2) {
					line++;
				} else {
					inner++;
				}
			}

			System.out.println("#" + test_case + " " + inner + " " + line + " " + outer);

		}
	}
}
