import java.util.Arrays;

public class test3 extends Thread{
	static int num[];
	public static void main(String[] args)  {
		num = new int[3];
		combi(0, 0);
		
	}
	private static void combi(int count, int start) {
		if(count==3) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=start; i<3; i++) {
			num[count] = i;
			System.out.println(count+" 번째 "+i+" 넣어서 " + Arrays.toString(num));
			combi(count+1, i);
		}
	}

}
