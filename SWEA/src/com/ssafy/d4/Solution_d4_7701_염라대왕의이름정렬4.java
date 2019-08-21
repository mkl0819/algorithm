package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution_d4_7701_염라대왕의이름정렬4 {
	static int T, N;
	static TreeSet<String> nameSet;
	
	static String s;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7701.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
				
			nameSet = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					if(s1.length() == s2.length()) {
						return s1.compareTo(s2);
					}
					return s1.length() - s2.length();
				}
			});
			
			for(int i=0; i<N; i++) {
				nameSet.add(in.readLine());
			}
			
			bw.write("#"+test_case+"\n");
			for(String s:nameSet) {
				bw.write(s+"\n");
			}
		}
		
	}
}
