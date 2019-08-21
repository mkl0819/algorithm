package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_d4_8275_햄스터 {
	static int T, N, X, M, l, r, s;
	static int max, info[][], hamzzi[], ans[];
	static int currentIdx;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_8275.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			hamzzi = new int[N];
			info = new int[M][3];
			ans = new int[N];
			max = -1;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				info[i][0] = Integer.parseInt(st.nextToken()) - 1;
				info[i][1] = Integer.parseInt(st.nextToken()) - 1;
				info[i][2] = Integer.parseInt(st.nextToken());
			}

			// info배열을 마지막 케이지를 기준으로 정렬
			Arrays.sort(info, new lastCageComparator());

			// 조합
			combi(0, 0);

			if (max == -1) {
				System.out.println("#" + test_case + " -1");
			} else {
				System.out.print("#" + test_case);
				for (int i = 0; i < N; i++) {
					System.out.print(" " + ans[i]);
				}
				System.out.println();
			}
		}
	}

	/*
	 * count : hamzzi 배열의 인덱스 
	 * index : info 배열의 인덱스
	 */
	private static void combi(int count, int index) {
		// 현재 만족시켜야 할 조건의 마지막 케이지 까지 햄스터를 채웠으면
		for (; index < M && count == info[index][1] + 1; index++) {
			// 해당 조건을 만족하는지 체크
			if (!check(index)) {
				return;
			}
		}
		// 모든 조건을 만족하는 hamzzi 배열을 완성했다면
		if (count == N) {
			int hamzziSum = 0;
			for (int i = 0; i < N; i++) {
				hamzziSum += hamzzi[i];
			}
			if (max < hamzziSum) {
				max = hamzziSum;
				copy();
			} else if (max == hamzziSum) {
				// 사전순으로 우선순위를 정함
				for (int j = 0; j < N; j++) {
					if (hamzzi[j] < ans[j]) {
						copy();
					} else if (hamzzi[j] == ans[j]) {
						continue;
					} else {
						break;
					}
				}
			}
			return;
		}
		// hamzzi의 count 번째 케이지에 0부터 X마리까지 넣어봄
		for (int i = 0; i <= X; i++) {
			hamzzi[count] = i;
			combi(count + 1, index);
		}
	}

	private static boolean check(int index) {
		int sum = 0;
		for (int i = info[index][0], size = info[index][1]; i <= size; i++) {
			sum += hamzzi[i];
		}
		if (sum != info[index][2]) {
			return false;
		}

		return true;

	}

	private static void copy() {
		for (int j = 0; j < N; j++) {
			ans[j] = hamzzi[j];
		}
	}

}

class lastCageComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] o1, int[] o2) {
		return o1[1] - o2[1];
	}
}
