import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class naver2 {
	static final int STEP = 0, TIME = 1;
	static final int PRE = 0, CUR = 1;
	static int order_graph[][];

	public static void main(String[] args) throws Exception {
		int cook_times[] = { 5,3, 2};
		int order[][] = { {1, 2}, {2, 3}, {1, 3} };
//		int cook_times[] = { 5, 30, 15, 30, 35, 20, 4 , 50, 40};
//		int order[][] = { { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 1, 6 }, { 4, 6 }, { 5, 6 }, { 6, 7 }, {8, 9} };
		int k = 3;
		System.out.println(Arrays.toString(solution(cook_times, order, k)));
	}

	public static int[] solution(int[] cook_times, int[][] order, int k) {
		int[] answer = {};

		order_graph = new int[cook_times.length + 1][cook_times.length + 1];
		System.out.println(order_graph.length);
		for (int i = 1, size = cook_times.length; i <= size; i++) {
			order_graph[0][i] = cook_times[i - 1];
		}

		for (int i = 0, size = order.length; i < size; i++) {
			order_graph[order[i][0]][order[i][1]] = 1;
		}

		print(order_graph);

		System.out.println("count : " + Arrays.toString(dfs(k)));

		print(order_graph);

		return answer;
	}

	private static void print(int[][] map) {
		for (int i = 0, size = map.length; i < size; i++) {
			for (int j = 0, size2 = map[0].length; j < size2; j++) {
				System.out.printf("%3d ", map[i][j]);
			}
			System.out.println();
		}
	}

	private static int[] dfs(int k) {
		int sum = 0, max =0;
		for (int i = 1, size = order_graph.length; i < size; i++) {
			if (order_graph[i][k] == 1) {
				int line[] = dfs(i);
				if (line[0] != 0) {
					order_graph[i][k] = line[0];
				}
				max = Math.max(max, line[1]);
			}
			sum += order_graph[i][k];
		}
		max = order_graph[0][k] + max;
		System.out.println(order_graph[0][k]);
		System.out.println(k+ " 번째 :  "+sum+" / "+max);
		return new int[] { sum, max };
	}

}
