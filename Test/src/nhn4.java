import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class nhn4 {
	static int n, k, map[][], route, MAX_COUNT, MIN_FUEL;
	static boolean dupli;
	static LinkedList<String[]> answer, minus_answer;
	static boolean visited[];
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		System.out.println('A'-'q');
		map 
		= new int[n][n];
		visited = new boolean[n];
		minus_answer = new LinkedList<>();
		answer = new LinkedList<>();
		route = Integer.parseInt(in.readLine().trim());

		for (int i = 0; i < route; i++) {
			st = new StringTokenizer(in.readLine());
			map[st.nextToken().charAt(0) - 'A'][st.nextToken().charAt(0) - 'A'] = Integer.parseInt(st.nextToken());
		}

		print();
		visited[0] = true;
		dfs(0, 0, k, new StringBuilder().append('0'));

		if (answer.isEmpty()) {
			Collections.sort(answer, new mycomp());
			if (minus_answer.isEmpty()) {
				System.out.println("-1");
			} else {
				System.out.println("minus_answer=====");
				
				for (String[] ss : minus_answer) {
					
					System.out.println(printString(ss[0]));
					System.out.println(ss[1]);
				}
			}
		} else {
			System.out.println("answer=====");
			for (String[] ss : answer) {
				System.out.println(printString(ss[0]));
				System.out.println(ss[1]);
			}
		}
	}

	private static String printString(String str) {
		sb = new StringBuilder();
		for(char c: str.toCharArray()) {
			sb.append((char)(c+'A'-'0')).append(" ");
		}
		return sb.toString();
	}

	private static void dfs(int start, int count, int fule, StringBuilder history) {
		System.out.printf("%d  : %dL   ( %s , %d)\n", start, fule, history.toString(), count);
		if (start == n - 1) {
			answer.add(new String[] { history.toString(), fule + "" });
			System.out.println("finish");
//			System.out.println(history.toString());
			return;
		}
		for (int i = 0; i < n; i++) {
			if (map[start][i] != 0 && !visited[i]) {
				int dfule = fule - map[start][i] + 10;
				if (dfule <= 0) {
					System.out.println("minus");
					minus_answer.add(new String[] { history.toString(), fule + "" });
				} else {
					visited[i] = true;
					dfs(i, count + 1, dfule, history.append(i));
					history.deleteCharAt(history.lastIndexOf(i + ""));
					visited[i] = false;
				}

			}
		}
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%2d ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

class mycomp implements Comparator<String[]> {

	@Override
	public int compare(String[] o1, String[] o2) {
		String history1 = o1[0], history2 = o2[0];
		if (history1.length() == history2.length()) {
			return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
		} else
			return history1.length() - history2.length();
	}

}
