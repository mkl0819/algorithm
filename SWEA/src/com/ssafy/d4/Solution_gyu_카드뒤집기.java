package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 플라이 하이라는 보드게임
 * N x N 칸의 게임판
 * 각 칸에는 숫자 카드가 한 장 씩 뒤집어져서 놓여있음
 * 플레이어는 처음에 한 위치를 선택하여 게임을 시작
 * 시작한 위치의 카드를 숫자가 보이도록 뒤집은
 * 상, 하, 좌, 우 중 아직 뒤집혀지지 않은 한 곳의 카드를 뒤집음
 * 이전 카드의 숫자보다 크면 다시 상, 하, 좌, 우 중 뒤집혀지지 않은 곳의 카드를 뒤집음
 * 이전 카드의 숫자보다 작거나 같으면 인정하지 않고 해당 턴 종료
 * 플레이어가 한 턴에 뒤집을 수 있는 카드의 최대 장수
 * 
 *  게임판의 크기 : N ( 1 : 500 )
 *  각 카드에 쓰인 숫자 : M ( 1: 1000000 ) 중복 가능
 *  
 *  입력
 *  3
 *  3
 *  3 1 2 
 *  5 8 10
 *  9 7 4
 *  4
 *  14 9 12 10
 *  1 11 5 4
 *  7 15 2 13
 *  6 3 16 8
 *  5
 *  5 4 3 2 1
 *  9 8 7 6 10
 *  18 17 16 20 19
 *  25 23 21 22 24
 *  11 13 12 14 15
 *  
 *  출력
 *  #1 5
 *  #2 4
 *  #3 8
 *
 */
public class Solution_gyu_카드뒤집기 {
	static int T, N, MAX;
	static int map[][];
	static int count[][];
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_gyu_카드뒤집기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N+2][N+2];
			count = new int[N+2][N+2];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			print(map);
			
			MAX = -1;
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j]!=0 && count[i][j]==0) {
						gameStart(i, j);
						MAX = Math.max(MAX, count[i][j]);
					}
				}
			}
//			print(count);
			System.out.println("#"+test_case+" "+MAX);
		}
	}

	private static void gameStart(int r, int c) {
		int dr, dc;

		for (int i = 0; i < 4; i++) {
			dr = r + dir[i][0];
			dc = c + dir[i][1];
			if (map[dr][dc] != 0 && map[dr][dc] > map[r][c]) {
				count[dr][dc] = 1;
				gameStart(dr, dc);
				count[r][c] = Math.max(count[r][c], count[dr][dc] + 1);
			}
		}
	}

	private static void print(int[][] matrix) {
		for(int i=0, size1 = matrix.length; i<size1; i++) {
			for(int j=0, size2 = matrix[0].length; j<size2; j++) {
				System.out.printf("%3d ", matrix[i][j]);
			}System.out.println();
		}System.out.println();
	}
}
