package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Cell implements Comparable<Cell> {
	int r; // row
	int c; // col
	int HP; // 활성 시간
	int cnt; //
	boolean isActive; // 활성화 됐는지

	public Cell() {
	}

	public Cell(int r, int c, int hP, int cnt, boolean isActive) {
		super();
		this.r = r;
		this.c = c;
		this.HP = hP;
		this.cnt = cnt;
		this.isActive = isActive;
	}

	@Override
	public int compareTo(Cell o) {
		return o.HP - this.HP;
	}
}

public class Solution_mo_5653_hyun {

	static int Answer;
	static int N, M, K;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상, 하, 좌, 우
	static int[][] map = new int[1001][1001];
	static boolean[][] visited = new boolean[1001][1001];
	static LinkedList<Cell> cellQueue = new LinkedList<>();
	static LinkedList<Cell> willDieQueue = new LinkedList<>();

	public static void resetMV() {
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				map[i][j] = 0;
				visited[i][j] = false;
			}
		}

		cellQueue.clear();
		willDieQueue.clear();
	}

	public static void bfs() {
		int size;
		Cell curCell;
		int nextR, nextC, r, c, hp, cnt;

		for (int i = 0; i <= K; i++) { // K시간만큼 배양
			size = willDieQueue.size(); // 활성화 된 애들중 먼저 시작

//			for(int t = 0; t < size; t++) {
//				System.out.println("r : " + willDieQueue.get(t).r + " , c : " + willDieQueue.get(t).c + " , cnt: " + willDieQueue.get(t).cnt);
//			}

//			System.out.println("cnt idx : " + i);
//			System.out.println("willdiequeue size : " + size);

			for (int j = 0; j < size; j++) {
				curCell = willDieQueue.poll();
				r = curCell.r;
				c = curCell.c;
				hp = curCell.HP;
				cnt = curCell.cnt;
//				System.out.println(hp+"가"+cnt);
				if (cnt == hp) { // 활성화 ㄱㄱ
					for (int k = 0; k < dir.length; k++) {
						nextR = r + dir[k][0];
						nextC = c + dir[k][1];

						// visited 검사
						if (!visited[nextR][nextC]) {
							// 배양 가능
							visited[nextR][nextC] = true;
							cellQueue.offer(new Cell(nextR, nextC, hp, hp, false));
						}
					}
				}
				if (cnt - 1 != 0) { // hp보다는 작고, 0은 아님
					// 0이 되면 쥬금 ㅜㅜ
					willDieQueue.offer(new Cell(r, c, hp, cnt - 1, true));
//					System.out.println(hp+"가"+(cnt-1));
				}
			}

			size = cellQueue.size();
			for (int j = 0; j < size; j++) {
				curCell = cellQueue.poll();
				r = curCell.r;
				c = curCell.c;
				hp = curCell.HP;
				cnt = curCell.cnt;

				// 시간 흐름 확인
				if (curCell.cnt == 0) {
					willDieQueue.offer(new Cell(r, c, hp, hp, true));
				} else { // 아직 안 쥬금
					cellQueue.offer(new Cell(r, c, hp, cnt - 1, false));
				}
			}
//			System.out.println(willDieQueue);
//			System.out.println(cellQueue.size()+" / "+willDieQueue.size());
		}
		// 이 때 cellQueue와 willDieQueue에 남아있는 애들의 합이 Answer임
		Answer = cellQueue.size() + willDieQueue.size();
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_5653.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;

		for (int testcase = 1; testcase <= TC; testcase++) {
			st = new StringTokenizer(br.readLine().trim());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			for (int i = 475; i < 475 + N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 475; j < 475 + M; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
//					System.out.println(tmp);
					if (tmp > 0) {
						visited[i][j] = true;
						cellQueue.add(new Cell(i, j, tmp, tmp, false));
					}
				}
			}

//			print();
			// Init
			Answer = 0;

			// Sol
			bfs();

			resetMV();
			System.out.println("#" + testcase + " " + Answer);
		}
	}

	private static void print() {
		for (int i = 450; i < 500; i++) {
			for (int j = 450; j < 500; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
