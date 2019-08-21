package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 7728. 다양성 측정
 * 
 * 입력 2 1512 20170310
 * 
 * 출력 #1 3 #2 5
 */
public class Solution_d3_7728 {
	static int T, cnt;
	static char[] X;
	static boolean num[];

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_d3_7728.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine().trim());
		
		for(int test_case=1; test_case <= T; test_case ++) {
			X = in.readLine().toCharArray();
			
			num = new boolean [10];
			
			for(int index : X) {
				num[index-'0'] = true;
			}
			
			cnt = 0;
			
			for(boolean tof : num) {
				if(tof) cnt++;
			}
			
			System.out.println("#"+test_case+" "+cnt);
		}
		
		
	}
}
