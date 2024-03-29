package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구공 {
	static int N, score[][], list[], MAX;
	static int maxpointbyout[] = { 0, 24, 14, 6, 5, 4, 3, 2, 1, 0 };
	static int maxpoint[];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		score = new int[N][9];
		maxpoint = new int[N];
		for (int i = 0, outcnt = 0; i < N; i++) {
			outcnt = 0;
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				switch (score[i][j] = Integer.parseInt(st.nextToken())) {
				case 0:
					outcnt++;
					break;
				}
			}
			maxpoint[i] = maxpointbyout[outcnt];
		}

		for (int i = N - 2; i >= 0; i--) {
			maxpoint[i] += maxpoint[i + 1];
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
//		System.out.println("======");
		int start = 0, point = 0;
		// 이닝
		for (int i = 0; i < N; i++) {
			if (point + maxpoint[i] <= MAX) {
//				System.out.println(i+ "이닝에서 미리아웃");
				return 0;
			}

			int out = 0;
			while (out < 3) {
				if (start == 9)
					start = 0;
//				start %= 9;
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
					} else
						break;
				}
				if (j == 0) {
					j = 9;
				}
			}

		}
		return point;
	}
}
