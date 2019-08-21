package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d3_7510_상원이의연속합 {
	static int T, N;
	static int array[];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_d3_7510.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		array = new int [1000001];
		
		gerArray();
		
		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			
			System.out.println("#"+test_case+" "+array[N]);
		}
	}

	private static void gerArray() {
		int tmp[] = new int[1415];
		
		tmp[0] = 0;
		for(int i=1; i<1415; i++) {
			tmp[i] = tmp[i-1] + i;
		}
//		System.out.println(Arrays.toString(tmp));
		for(int i=1; i<1415; i++) {
			for(int j=tmp[i]; j<1000001; j+=i) {
				array[j]++;
			}
		}
//		System.out.println(Arrays.toString(array));
	}
}
