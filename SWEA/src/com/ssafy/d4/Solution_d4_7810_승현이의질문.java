package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_7810_승현이의질문 {
	static int T, N, H;
	static int array[];
	
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7810.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			
			array = new int[1000001];
			
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				array[Integer.parseInt(st.nextToken())]++;
			}
			
			H = findH();
			
			System.out.println("#"+test_case+" "+H);
		}
	}

	private static int findH() {
		for(int i=1; i<=1000000; i++) {
			if(N-array[i-1]<i) {
				return i-1;
			}
			array[i] += array[i-1];
		}
		return -1;
	}
}
