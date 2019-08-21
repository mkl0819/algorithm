package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_3314_fin {
	static int T;
	static int ans, tmp;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine().trim());
		
		for(int test_case=1; test_case<=T; test_case++	) {
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<5; i++) {
				tmp = Integer.parseInt(st.nextToken());
				ans += tmp > 40 ? tmp: 40;
			}
			System.out.println("#"+test_case+" "+(ans/5));
		}
	}
}
