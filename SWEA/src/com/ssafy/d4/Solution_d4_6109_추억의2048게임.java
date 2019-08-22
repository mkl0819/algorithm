package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_d4_6109_추억의2048게임 {
	static int T, N, dir, number;
	static ArrayList<LinkedList<Integer>> mapList;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_6109.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			switch (st.nextToken()) {
			case "up":
				dir = 1;
				break;
			case "right":
				dir = 2;
				break;
			case "down":
				dir = 3;
				break;
			case "left":
				dir = 4;
				break;
			}

			mapList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				mapList.add(new LinkedList<>());
			}
			
			// ����
			if (dir % 2 == 0) {
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(in.readLine());
					for (int j = 0; j < N; j++) {
						number = Integer.parseInt(st.nextToken());
						if (number != 0) {
							mapList.get(i).add(number);
						}
					}
				}
			} else {
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(in.readLine());
					for (int j = 0; j < N; j++) {
						number = Integer.parseInt(st.nextToken());
						if (number != 0) {
							mapList.get(j).add(number);
						}
					}
				}
			}

			if(dir==2 || dir==3) {
				for(LinkedList<Integer> list:mapList) {
					Collections.reverse(list);
				}
			}
			
			print(mapList);

			for (LinkedList<Integer> list : mapList) {
				for (int i = 0, size = list.size() - 1; i < size; i++) {
					if (list.get(i) == list.get(i + 1)) {
						list.set(i + 1, list.get(i) * 2);
						list.remove(i);
						size--;
					}
				}
			}
			sb.append("#").append(test_case).append(" \n");
			if (dir % 2 == 0) {
				for (LinkedList<Integer> list : mapList) {
					for (int j = 0; j < N; j++) {
						if (list.size() != 0) {
							sb.append(list.pop()).append(" ");
						}else {
							sb.append("0 ");
						}
					}
					sb.append("\n");
				}
			} else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (mapList.get(j).size() != 0) {
							sb.append(mapList.get(j).pop()).append(" ");
						}else {
							sb.append("0 ");
						}
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

	private static void print(ArrayList<LinkedList<Integer>> qList2) {
		for (LinkedList<Integer> q : qList2) {
			System.out.println(q);
		}
		System.out.println();
	}

	private static void print(int[][] map) {
		for (int i = 0, size = map.length; i < size; i++) {
			for (int j = 0, size2 = map[0].length; j < size2; j++) {
				System.out.printf("%3d", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
