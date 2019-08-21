package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
/*
 * 항구
 */
public class Solution_d3_4371_fin{
	static int T, N, count;
	static Stack<Integer> stack;
	
	static HashSet<Integer> set;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_4371.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			stack = new Stack<Integer>();
			in.readLine();
			for (int i = 1; i < N; i++) {
				if(isCount(Integer.parseInt(in.readLine().trim())-1)) {
				}
			}
			System.out.println("#" + test_case + " " + stack.size());
		}
	}

	private static boolean isCount(int data) {
		for (Integer n : stack) {
			if(data%n==0) {
				return false;
			}
		}
		stack.add(data);
		return true;
	}


}
