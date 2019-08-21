package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 동철이의 일 분배
 */
public class Solution_d4_1865 {
	static int T, N;
	static int map[][];
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_d4_1865.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(in.readLine());
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
		}
	}
}
