public class mobis04 {
	public static void main(String[] args) throws Exception {
		System.out.println(solution(2));
		System.out.println(solution(4));
		System.out.println(solution(1));
	}

	static int[][][] keyboard;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static int solution(int T) {
		if (T % 2 == 1) {
			return -1;
		}

		keyboard = new int[3][10][T+1];

		keyboard[1][6][0] = 1;
		
		int dr, dc;
		
		for(int time=1; time<=T; time++) {
			for(int r=0; r<3; r++) {
				for(int c=0; c<10; c++) {
					for(int d=0; d<4; d++) {
						dr = r+dir[d][0];
						dc = c+dir[d][1];
						if(check(dr, dc)) {
							keyboard[r][c][time] += keyboard[dr][dc][time-1];
							if(1000000007<keyboard[r][c][time]) {
								keyboard[r][c][time]%=1000000007;
							}
						}
					}
				}
			}
		}
		
		return keyboard[1][6][T];
	}

	private static boolean check(int r, int c) {
		if (r == -1 || c == -1 || r == 3 || c == 10)
			return false;
		if (r == 1 && 9 <= c)
			return false;
		if (r == 2 && 7 <= c)
			return false;
		return true;
	}
}
