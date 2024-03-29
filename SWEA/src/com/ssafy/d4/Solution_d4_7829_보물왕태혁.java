package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_7829_보물왕태혁 {
	static int T, P, measures[];
	
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7829.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			P = Integer.parseInt(in.readLine().trim());
			
			if(P==1) {
				P = Integer.parseInt(in.readLine().trim());
				System.out.println("#"+test_case+" "+P*P);
				
				continue;
			}
			
			st = new StringTokenizer(in.readLine());
			
			measures = new int[P];
			
			for(int i=0; i<P; i++) {
				measures[i] = Integer.parseInt(st.nextToken());
			}

			
			Arrays.sort(measures);
			
			System.out.println("#"+test_case+" "+measures[0]*measures[P-1]);
			
		}
	}
}
