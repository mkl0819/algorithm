package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Solution_d4_3234_준환이의양팔저울2 {
	static int T, N, chu[], sum, right, left, chuSet[];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_3234.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T = 2;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			chu = new int[N];
			st = new StringTokenizer(in.readLine());
			sum = 0;
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
				sum += chu[i];
			}
			chuSet = new int[N];
			System.out.println(sum);
			left = sum;
			right = 0;
			combi(0, 0);
		}
	}

	private static void combi(int count, int start) {
		if (count == N) {
//			System.out.println("성공");
//			printMing.print(chuSet);
			return;
		}
		for (int i = start; i < N; i++) {
			chuSet[count] = chu[i];
			left -= chu[i];
			right += chu[i];
//			printMing.print(left, right);
			if (left < right) {
//				printMing.print(chuSet);
//				System.out.println("실패");
//				continue;
			} else {
				System.out.println("성공");
				printMing.print(chuSet);

			}
			combi(count + 1, i + 1);
			left += chu[i];
			right -= chu[i];
			chuSet[count] = 0;
		}
	}
}
