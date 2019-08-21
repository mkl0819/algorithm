package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*
 * 올해의 조련사
 */
public class Solution_d4_5672_fin {
	static int T, N;
	static char name[];

	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_5672.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			name = new char[N];
			for (int i = 0; i < N; i++) {
				name[i] = in.readLine().charAt(0);
			}
			System.out.println(name);
			Line();
			System.out.println(sb.toString());
		}
	}

	private static void Line() {
		int start = 0, end = N - 1;
		sb = new StringBuilder();
		while (start <= end) {
			if (name[start] < name[end]) {
				sb.append(name[start]);
				start++;
			} else if (name[start] > name[end]) {
				sb.append(name[end]);
				end--;
			} else {
				boolean check = false;
				for (int i = 0, size = (end - start) / 2; i < size; i++) {
					System.out.println(i);
					if (name[start + i] < name[end - i]) {
						sb.append(name[start]);
						start++;
						check = true;
						break;
					} else if (name[start + i] > name[end - i]) {
						sb.append(name[end]);
						end--;
						check = true;
						break;
					}
				}
				if (!check) {
					sb.append(name[start]);
					start++;
				}
			}
		}
	}
}