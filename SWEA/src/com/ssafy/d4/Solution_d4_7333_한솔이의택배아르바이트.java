package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.ssafy.library.printMing;

public class Solution_d4_7333_한솔이의택배아르바이트 {
	static int T, N; 
	static int boxs[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7333.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			
			boxs = new int[N];
			
			for(int i=0; i<N; i++) {
				boxs[i] = (int) Math.ceil((double)50 / Integer.parseInt(in.readLine().trim()));
			}
			
			Arrays.sort(boxs);
			
			printMing.print(boxs);
			
			
			
		}
	}
}
