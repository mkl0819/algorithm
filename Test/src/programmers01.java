import java.util.Arrays;

public class programmers01 {
	static int T;

	public static void main(String[] args) throws Exception {
//		int[] goods = { 5, 3, 7 };
//		int[] boxes = { 3, 7, 6 };
//		int[] goods = { 1, 2 };
//		int[] boxes = { 2, 3, 1 };
		int[] goods = { 3, 8, 6 };
		int[] boxes = { 5, 6, 4 };
		System.out.println(solution(goods, boxes));
	}

	public static int solution(int[] goods, int[] boxes) {
		int answer = 0;

		Arrays.sort(goods);
		Arrays.sort(boxes);

		for (int i = 0, j = 0, g_len = goods.length, b_len = boxes.length; i < g_len && j < b_len; j++) {
			if (goods[i] <= boxes[j]) {
				i++;
				answer++;
			}
		}

		return answer;
	}
}
