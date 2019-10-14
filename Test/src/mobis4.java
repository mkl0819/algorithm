public class mobis4 {
	public static void main(String[] args) throws Exception {
//		solution(new String[] { "ABCBA", "DABAG", "EBABH", "FAJAI", "AKLMA" });
		solution(new String[] { "ABCBA", "DABAG", "ENABH", "FAJAI", "AKLMO" });
	}

	public static int solution(String[] board) {
		int row = board.length;
		int col = board[0].length();

		char[][] map = new char[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		int[][] dir = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		int answer = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int[] temp = new int[4];

				for (int k = 0; k < dir.length; k++) {
					int dr = i + dir[k][0];
					int dc = j + dir[k][1];

					while (dr >= 0 && dc >= 0 && dr < row && dc < col && map[i][j] == map[dr][dc]) {
						temp[k]++;
						dr += dir[k][0];
						dc += dir[k][1];
					}
				}
				int min = temp[0];
				boolean possible = true;

				for (int a = 0; a < 4; a++) {
					if (temp[a] == 0) {
						possible = false;
						break;
					}
					if (temp[a] < min)
						min = temp[a];
				}

				if (possible) {
					int count = min * 2 + 1;
					answer = answer < count ? count : answer;
				}
			}
		}

		return answer;
	}

}
