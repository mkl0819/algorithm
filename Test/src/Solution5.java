import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5 {
	static int n, m, x, y;
	static long pascal[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		
		if ((x == 0 && y == 0) || (n < x || m < y)) {
			System.out.println("fail");
			return;
		}
		System.out.println(x + y);
		System.out.println(getCase());
	}

	private static long getCase() {
		pascal = new long[y+1][x+1];

		for(int r=0; r<=y; r++) {
			pascal[r][0] = 1;
		}
		for(int c=0; c<=x; c++) {
			pascal[0][c] = 1;
		}
		for(int r=1; r<=y; r++) {
			for(int c=1; c<=x; c++) {
				pascal[r][c] = pascal[r-1][c] + pascal[r][c-1];
			}
		}

		return pascal[y][x];
	}
}
