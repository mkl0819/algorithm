import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution2 {
	static ArrayList<Integer> list;
	static int index, count, size;
	static boolean permuFlag;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());

		list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		size = list.size();

		Collections.sort(list);

		index = Integer.parseInt(in.readLine().trim());

		sb = new StringBuilder();
		permu(0, 0);
	}

	private static void permu(int listIndex, int indexFlag) {
		if (!permuFlag && listIndex == size) {
			count++;
			if (count == index) {
				System.out.println(sb.toString());
				permuFlag = true;
			}
			return;
		}
		for (int i = 0; i < size; i++) {
			if ((indexFlag & (1 << i)) == 0) {
				sb.replace(listIndex, listIndex + 1, list.get(i) + "");
				permu(listIndex + 1, indexFlag | 1 << i);
			}
		}
	}
}