package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d3_7227_사랑의카운슬러 {
	static int T, N;
	static int wormPoint[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7227.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			
			wormPoint = new int[N][2];
			
			
		}
	}
}
