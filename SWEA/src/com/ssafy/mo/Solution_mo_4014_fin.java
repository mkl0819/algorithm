package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 활주로 건설
 */
public class Solution_mo_4014_fin {
	static int T, N, X, garomap[][], seromap[][], ANS;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			// input
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			garomap = new int[N][N];
			seromap = new int[N][N];
			ANS = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					garomap[i][j] = seromap[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			// search
			for (int i = 0; i < N; i++) {
				ANS += count(garomap[i], i);
				ANS += count(seromap[i], i);
			}
			System.out.println("#" + test_case + " " + ANS);
		}
	}

	private static int count(int[] line, int index) {
		int right[] = new int[7];
		int left[] = new int[7];
		boolean visited[] = new boolean[N];
		int pre1 = line[0], pre2 = line[N - 1], cur1, cur2;
		for (int i = 0; i < N; i++) {
			// 오르막 검사
			right[cur1 = line[i]]++;
			if (cur1 - pre1 == 1) {
				if (right[pre1] < X) {
					return 0;
				} else {
					for (int k = 1; k <= X; k++) {
						visited[i - k] = true;
					}
				}
			} else if (cur1 - pre1 > 1) {
				return 0;
			}
			if (pre1 != cur1) {
				right[pre1] = 0;
				pre1 = cur1;
			}
		}
		for (int i = 0; i < N; i++) {
			// 내리막 검사
			left[cur2 = line[N - 1 - i]]++;
			if (cur2 - pre2 == 1) {
				if (left[pre2] < X) {
					return 0;
				} else {
					for (int k = 1; k <= X; k++) {
						if (visited[N - 1 - i + k]) {
							return 0;
						}
					}
				}
			} else if (cur2 - pre2 > 1) {
				return 0;
			}
			if (pre2 != cur2) {
				left[pre2] = 0;
				pre2 = cur2;
			}

		}
		return 1;
	}
}