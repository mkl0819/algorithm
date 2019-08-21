package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d4_7965_퀴즈 {
	static int T, N, P, RESULT, SIZE = 13;
	static int array[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7965.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		array = new int[SIZE];
		P = 1000000007;
		
		init();
		
		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			
			System.out.println("#"+test_case+" "+array[N]);
		}
	}

	private static void init() {
		int sum, tmp, mod; 
		
		for(int i=1; i<SIZE; i++) {
			
		}
	}
	
}
