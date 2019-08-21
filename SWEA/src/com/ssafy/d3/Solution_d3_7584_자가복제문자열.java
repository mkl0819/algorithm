package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_d3_7584_자가복제문자열 {
	static int T;
	static long K;
	static boolean flag;
	static long zeroPoint[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7584.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());

		zeroPoint = new long[70];

		zeroPoint[0] = 1;

		for (int i = 1; i < 70; i++) {
			zeroPoint[i] = 2 * zeroPoint[i - 1];
		}
		
		for (int test_case = 1; test_case <= T; test_case++) {
			K = Long.parseLong(in.readLine().trim());

			flag = true;
//			System.out.println(Arrays.toString(zeroPoint));
			getIndex(K);
//			getIndex(10);
//			getIndex(6);
//			getIndex(2);

			System.out.println("#"+test_case+" "+(flag ? "0":"1"));
		}
	}

	
	
	private static void getIndex(long index) {
		long pivot;
		if(index == 1) {
			return;
		}
		
		for (int i = 0; i < 70; i++) {
			if(index == zeroPoint[i]) {
				return;
			}
			if (index < zeroPoint[i]) {
				flag = !flag;
				pivot = zeroPoint[i - 1];
				getIndex(2 * pivot - index);
				break;
			}
		}
		
	}
}

