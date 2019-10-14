import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class naver1 {
	static final int STEP = 0, TIME = 1;
	static final int PRE = 0, CUR = 1;

	public static void main(String[] args) throws Exception {
		int cook_times[] = { 5, 30, 15, 30, 35, 20, 4 };
		int order[][] = { { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 1, 6 }, { 4, 6 }, { 5, 6 }, { 6, 7 } };
		int k = 6;
		System.out.println(Arrays.toString(solution(cook_times, order, k)));
	}

	public static int[] solution(int[] cook_times, int[][] order, int k) {
		int[] answer = {};

		int order_list[][] = new int[cook_times.length][2];

//		Arrays.sort(order, );

		for (int i = 0, size = cook_times.length; i < size; i++) {
			order_list[i][STEP] = 0;
			order_list[i][TIME] = cook_times[i];
		}
		for (int i = 0; i < order_list.length; i++) {
			System.out.println(Arrays.toString(order_list[i]));
		}

		for (int i = 0, size = order.length; i < size; i++) {
			int preIndex = order[i][PRE] - 1;
			int curIndex = order[i][CUR] - 1;
			if (order_list[curIndex][STEP] == 0) {
				order_list[curIndex][STEP] += order_list[preIndex][STEP] + 1;
			} else {
				order_list[curIndex][STEP] += order_list[preIndex][STEP];
			}
			if (order_list[preIndex][STEP] == 0) {
				order_list[curIndex][TIME] = Math.max(order_list[curIndex][TIME],
						cook_times[preIndex] + cook_times[curIndex]);
			} else {
				order_list[curIndex][TIME] = Math.max(order_list[curIndex][TIME],
						order_list[preIndex][TIME] + cook_times[curIndex]);
			}
			System.out.println(curIndex);
			System.out.println(Arrays.toString(order_list[curIndex]));
		}

		for (int i = 0; i < order_list.length; i++) {
			System.out.println(Arrays.toString(order_list[i]));
		}

		return order_list[k-1];
	}

	class comp implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {

			return 0;
		}

	}
}
