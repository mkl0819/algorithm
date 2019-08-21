package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_d4_7465_창용마을무리의개수 {
	static int T, N, M;
	static int people[];
	static Set<Integer> group;
	
	static StringTokenizer st;

	public static void union(int parent, int child) {
		int parentGroup = find(parent);
		int childGroup = find(child);
		
		if( childGroup < parentGroup ) {
			int tmp;
			tmp = childGroup;
			childGroup = parentGroup;
			parentGroup = tmp;
		}
		changeGroup(childGroup, people[parentGroup]);
	}
	
	private static void changeGroup(int childGroup, int parentGroup) {
		for(int i=1; i<=N; i++) {
			if(people[i]==childGroup) {
				people[i] = parentGroup;
			}
		}
	}

	public static int find(int num) {
		if(people[num]==num) {
			return num;
		}
		return find(people[num]);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7465.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			group = new HashSet<>();
			
			people = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				people[i] = i;
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for(Integer parent:people) {
				group.add(parent);
			}
			System.out.println("#"+test_case+" "+(group.size()-1));
//			out.write("#"+test_case+" "+(group.size()-1));
		}
	}
}
