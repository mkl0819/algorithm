package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d4_7854_최약수 {
	static int T, X, idx, RESULT;
	static int measureArray[] = { 
			1, 2, 5, 10, 20, 25, 50, 100, 125, 200, 
			250, 500, 1000, 1250, 2000, 
			2500, 5000, 10000, 12500, 20000, 
			25000, 50000, 100000, 125000, 200000, 
			250000, 500000, 1000000, 1250000, 2000000, 
			2500000, 5000000, 10000000, 12500000, 20000000, 
			25000000, 50000000, 100000000, 125000000, 200000000, 
			250000000, 500000000, 1000000000};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7854.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//		getMeasureArray();
		
		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			X = Integer.parseInt(in.readLine().trim());
			RESULT = -1;
			
			for(int i=0; i<43; i++) {
				if(X < measureArray[i]) {
					RESULT = i;
					break;
				}
			}

			System.out.println("#"+test_case+" "+ (RESULT==-1? 43: RESULT));
		}
	}

	private static void getMeasureArray() {
		int prenum, num = 1, idx = 0;
		
		measureArray = new int[50];
		
		for(int i=1; i<10; i++) {
			prenum = num;
			num *= 10;
			for(int j=prenum; j<num; j++) {
				if(num % j == 0) {
					measureArray[idx++] = j;
					System.out.println(j);
				}
			}
		}
	}
}
