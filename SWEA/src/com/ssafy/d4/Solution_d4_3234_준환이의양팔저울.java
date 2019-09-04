package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Solution_d4_3234_준환이의양팔저울 {
	static int T, N, chu[], chuSet[], listL[], listR[], sumR, sumL, COUNT;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_3234.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			chu = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
			}
			chuSet = new int[N];
			listL = new int[N];
			listR = new int[N];
			sumR = sumL = 0;
			COUNT = 0;
			permu(0, 0);
			System.out.println("#" + test_case + " " + COUNT);
		}
	}

	private static void permu(int count, int flag) {
		if (count == N) {
			COUNT++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (((flag & (1 << i)) == 0)) {
				printMing.print(listR);
				listR[count] = chu[i];
				sumR += chu[i];
				if (sumR <= sumL) {
					permu(count + 1, flag | 1 << i);
				}
				listR[count] = 0;
				sumR -= chu[i];

				listL[count] = chu[i];
				sumL += chu[i];
				if (sumR <= sumL) {
					permu(count + 1, flag | 1 << i);
				}
				listL[count] = 0;
				sumL -= chu[i];
			}
		}
	}

	private static boolean isRlight(int count) {
		int sumR = 0, sumL = 0;
		for (int i = 0; i <= count; i++) {
			sumR += listR[i];
			sumL += listL[i];
		}
		return sumR <= sumL ? true : false;
	}
}
