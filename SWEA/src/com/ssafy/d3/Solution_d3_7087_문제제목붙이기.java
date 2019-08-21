package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d3_7087_문제제목붙이기 {
	static int T, N;
	static int title[];
	static int ANSWER;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7087.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			
			title = new int[26];
			
			for(int i=0; i<N; i++) {
				title[in.readLine().toCharArray()[0]-'A']++;
			}
			ANSWER = -1;
			for(int i=0; i<26; i++) {
				if(title[i]==0) {
					ANSWER = i;
					break;
				}
			}
			if(ANSWER == -1) {
				ANSWER = 26;
			}
			System.out.println("#"+test_case+" "+ANSWER);
		}
	}
}
