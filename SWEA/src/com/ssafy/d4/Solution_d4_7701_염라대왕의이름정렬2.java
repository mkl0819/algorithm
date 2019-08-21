package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution_d4_7701_염라대왕의이름정렬2 {
	static int T, N;
	static TreeMap<Integer, TreeSet<String>> nameSet;
	static boolean check[];
	
	static String s;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7701.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
				
			nameSet = new TreeMap<>();
			check = new boolean[51];
			
			for(int i=0; i<N; i++) {
				s = in.readLine();
				if(!nameSet.containsKey(s.length())) {
					nameSet.put(s.length(), new TreeSet<>());
				}
				nameSet.get(s.length()).add(s);
			}
			
			System.out.println("#"+test_case);
			
			for(int l : nameSet.keySet()) {
				for(String s : nameSet.get(l)) {
					System.out.println(s);
				}
			}
		}
	}
}
