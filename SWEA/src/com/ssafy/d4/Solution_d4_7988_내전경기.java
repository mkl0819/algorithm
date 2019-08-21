package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Solution_d4_7988_내전경기 {
	static int T, size, index1, index2, synergy[][];
	static Map<String, Integer> members;
	static String name1, name2, isPossible;
	static boolean check[];
	static Queue<Integer> q;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7988.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			members = new HashMap<String, Integer>();
			synergy = new int[200][200];
			isPossible = "No";
			for (int i = 0, j = 0, input = Integer.parseInt(in.readLine().trim()); i < input; i++) {
				st = new StringTokenizer(in.readLine());
				name1 = st.nextToken();
				if (!members.containsKey(name1)) {
					index1 = j;
					members.put(name1, j++);
				} else {
					index1 = members.get(name1);
				}
				name2 = st.nextToken();
				if (!members.containsKey(name2)) {
					index2 = j;
					members.put(name2, j++);
				} else {
					index2 = members.get(name2);
				}
				synergy[index1][index2] = 1;
				synergy[index2][index1] = 1;
			}
			printMing.print(synergy, members.size());
			size = members.size();
			check = new boolean[size];
			q = new LinkedList<>();
			
			q.offer(0);
			check[0] = true;
			getTeam();
		}
	}

	private static void getTeam() {
		int index;
		while(q.size()!=0) {
			for(int i=0, qsize = q.size(); i<qsize; i++) {
				index = q.poll();
				for(int j=0; j<size; j++) {
					if(!check[j] && synergy[index][j]==0 && index!=j) {
						q.offer(j);
					}
				}
			}

		}
		
		
		
	}
}
