package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_mo_5644_hyuni {
	
	static int Answer;
	static int M, A;
	static int[] moveA;
	static int[] moveB;
	static int[][] dir = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 0~4. 멈춤, 상, 우, 하, 좌
	static final int N = 10;
	static int[][] AP;
	static int aR, aC, bR, bC;
	static ArrayList<Integer> ACStore = new ArrayList<>();
	static ArrayList<Integer> BCStore = new ArrayList<>();
	
	public static int maxCharge() {
		int maxVal = 0;
		int aSize = ACStore.size();
		int bSize = BCStore.size();
		int aCharge, bCharge;
		
		if(aSize == 0 && bSize == 0) {
			return 0;
		}
		
		if(aSize == 0 && bSize > 0) {
			for(int i = 0; i < bSize; i++) {
				bCharge = AP[BCStore.get(i)][3];
				
				maxVal = Math.max(maxVal, bCharge);
			}
			return maxVal;
		}
		
		if(bSize == 0 && aSize > 0) {
			for(int i = 0; i < aSize; i++) {
				aCharge = AP[ACStore.get(i)][3];
				
				maxVal = Math.max(maxVal, aCharge);
			}
			return maxVal;
		}
		
		for(int i = 0; i < aSize; i++) {
			for(int j = 0; j < bSize; j++) {
				aCharge = AP[ACStore.get(i)][3];
				bCharge = AP[BCStore.get(j)][3];
				
				if(ACStore.get(i) == BCStore.get(j)) {	// 한 번만 충전
					maxVal = Math.max(maxVal, aCharge);
					System.out.println(aCharge);
				}else {
					maxVal = Math.max(maxVal, aCharge+bCharge);
					System.out.println(aCharge+bCharge);
				}
				
			}
		}
		return maxVal;
	}
	
	public static void makeCharge(int man) {		// A가 밟은 땅의 최고 두 개값인 리스트 인덱스 뽑아준다
		int r, c, bounds;
		
		switch (man) {
		case 1:
			for(int i = 0; i < A; i++) {
				r = AP[i][0];
				c = AP[i][1];
				bounds = AP[i][2];
				
				if(bounds >= Math.abs(r-aR) + Math.abs(c-aC)) {		// 충전 가능
					ACStore.add(i);
				}
			}
			break;
		case 2:
			for(int i = 0; i < A; i++) {
				r = AP[i][0];
				c = AP[i][1];
				bounds = AP[i][2];
				
				if(bounds >= Math.abs(r-bR) + Math.abs(c-bC)) {		// 충전 가능
					BCStore.add(i);
				}
			}
			break;
		default:
			break;
		}
	}
	
	public static void move(int man, int cmd) {
		switch (man) {
		case 1:
			aR += dir[moveA[cmd]][0];
			aC += dir[moveA[cmd]][1];
			break;
		case 2:
			bR += dir[moveB[cmd]][0];
			bC += dir[moveB[cmd]][1];
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int testcase = 1; testcase <= TC; testcase++) {
			st = new StringTokenizer(br.readLine().trim());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			moveA = new int[M+1];
			moveB = new int[M+1];
			AP = new int[A][4];		// 0번, 1번, 2번. 정보는 r, c, 범위, 

			st = new StringTokenizer(br.readLine().trim());
			for(int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine().trim());
			for(int i = 1; i <= M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine().trim());
				AP[i][1] = Integer.parseInt(st.nextToken());
				AP[i][0] = Integer.parseInt(st.nextToken());
				AP[i][2] = Integer.parseInt(st.nextToken());
				AP[i][3] = Integer.parseInt(st.nextToken());
			}
			
			// Init
			Answer = 0;
			aR = aC = 1;
			bR = bC = 10;
			int tmp;
			
			// Sol
			// 0초일 때에도 처리 해줘야됨
			for(int i = 0; i <= M; i++) {	// 시행
				move(1, i);
				move(2, i);
				// ACStore와 BCStore 확인
				makeCharge(1);
				makeCharge(2);
				
				// 최적해 충전
				tmp = maxCharge();
				Answer += tmp;
				ACStore.clear();
				BCStore.clear();
			}
			
			sb.append("#" + testcase + " " + Answer + "\n");
		}
		System.out.println(sb);
	}
}