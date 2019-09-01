import java.util.LinkedList;
import java.util.Queue;

public class test3 extends Thread {
	static int map[][], cnt = 1;
	static Queue<Integer> q;
	static int[] UP = { -1, 0 }, DOWN = { 1, 0 }, LEFT = { 0, -1 }, RIGHT = { 0, 1 };
	static int[][] dir = {UP, LEFT, RIGHT, DOWN};
//	static int[][] dir = {UP, LEFT, DOWN, RIGHT};
//	static int[][] dir = {UP, LEFT, DOWN, RIGHT};
//	static int[][] dir = {UP, LEFT, DOWN, RIGHT};
	public static void main(String[] args) {
		map = new int[5][5];
		bfs();
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%3d", map[i][j]);
			}System.out.println();
		}
	}
	

	private static void bfs() {
		q = new LinkedList<Integer>();
		q.offer(2);
		q.offer(2);
		map[2][2] = cnt++;
		int r, c, dr, dc;
		while(!q.isEmpty()) {
			for(int i=0, size = q.size()/2; i<size; i++) {
				r = q.poll();
				c = q.poll();
				for(int d=0; d<4; d++) {
					dr = r+dir[d][0];
					dc = c+dir[d][1];
					if(check(dr, dc) && map[dr][dc]==0) {
						map[dr][dc] = cnt++;
						q.offer(dr);
						q.offer(dc);
					}
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		if(r==-1||r==5||c==-1||c==5)return false;
		return true;
	}

}
