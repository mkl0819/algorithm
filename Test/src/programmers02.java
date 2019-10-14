
public class programmers02 {
	static int dir[][] = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

	public static void main(String[] args) throws Exception {
		String[] bishops = { "D5" };
		System.out.println(solution(bishops));
		String[] bishops2 = { "D5", "E8", "G2" };
		System.out.println(solution(bishops2));
	}

	public static int solution(String[] bishops) {
		int answer = 64;
		int r = 0, c = 0, dr = 0, dc = 0;

		boolean visited[][] = new boolean[9][9];

		for (String bishop : bishops) {
			r = bishop.charAt(1) - '0';
			c = bishop.charAt(0) - 'A' + 1;
			if (!visited[r][c]) {
				visited[r][c] = true;
				answer--;
			}
			for (int d = 0; d < 4; d++) {
				dr = r + dir[d][0];
				dc = c + dir[d][1];
				while (check(dr, dc)) {
					if (!visited[dr][dc]) {
						visited[dr][dc] = true;
						answer--;
					}
					dr += dir[d][0];
					dc += dir[d][1];
				}
			}
		}

		return answer;
	}

	private static boolean check(int dr, int dc) {
		if (dr == 0 || dc == 0 || dr == 9 || dc == 9)
			return false;
		else
			return true;
	}
}
