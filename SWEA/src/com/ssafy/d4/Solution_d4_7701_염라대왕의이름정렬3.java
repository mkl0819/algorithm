package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution_d4_7701_염라대왕의이름정렬3 {
	static int T, N;
	static HashSet<String> nameSet;
	static String[] nameList;
	
	static String s;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7701.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
				
			nameSet = new HashSet<>();
			
			for(int i=0; i<N; i++) {
				nameSet.add(in.readLine());
			}
			
			nameList = Arrays.copyOf(nameSet.toArray(), nameSet.size(), String[].class);
			
			Arrays.sort(nameList, new Comparator<String>() {

				@Override
				public int compare(String s1, String s2) {
					if(s1.length() == s2.length()) {
						return s1.compareTo(s2);
					}
					return s1.length() - s2.length();
				}
			});
			
			System.out.println("#"+test_case);
			
			for(String s: nameList) {
				System.out.println(s);
			}
		}
	}
}
