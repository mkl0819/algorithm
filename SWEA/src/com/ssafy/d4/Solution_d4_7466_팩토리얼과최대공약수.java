package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_7466_팩토리얼과최대공약수 {
	static int T, N, K, tmp, RESULT;
	
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7466.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			RESULT = 1;
			
			getGcd(K);

			System.out.println("#"+test_case+" "+RESULT);
		}
	}

	private static void getGcd(int num) {
		if(num==1) {
			return;
		}
		for(int i=N; i>1; i--) {
			if(num % i == 0) {
				RESULT *= i;
				N = num < i-1 ? num : i-1;
				getGcd(num/i);
				break;
			}
		}
	}
}
