package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구공3 {
	static int N, score[][], list[], MAX;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		score = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new int[9];
		list[3] = 0;
		MAX = -1;
		permu(0, 1);
		System.out.println(MAX);
	}

	private static void permu(int count, int flag) {
		if (count == 9) {
			MAX = Math.max(MAX, game(list));
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (count == 3) {
				permu(count + 1, flag);
			} else {
				if ((flag & (1 << i)) == 0) {
					list[count] = i;
					permu(count + 1, flag | (1 << i));
				}
			}
		}
	}

	private static int game(int[] tmplist) {
		int start = 0, point = 0;
		// 이닝
		for (int i = 0; i < N; i++) {
			int out = 0;
			while (out < 3) {
				if (start == 9)
					start = 0;
				switch (score[i][tmplist[start]]) {
				case 0:
					out++;
					break;
				default:
					point++;
					break;
				}
				start++;
			}
			for (int j = start - 1, sum = 0, cnt = 0, p = 0; cnt <= 3 && j >= 0; j--, cnt++) {
				p = score[i][tmplist[j]];
				if (p != 0) {
					sum += p;
					if (sum < 4) {
						point--;
					}
				}
				if (j == 0) {
					j = 9;
				}
			}

		}
		return point;
	}
}
