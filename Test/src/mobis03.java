public class mobis03 {
	static String[] BOARD;
	static int MAX;
	public static void main(String[] args) throws Exception {
//		System.out.println("->"+solution(new String[] { "ABCBA", "DABAG", "EBABH", "FAJAI", "AKLMA" }));
		System.out.println("->"+solution(new String[] {"ABCBA","DABAG","ENABH","FAJAI","AKLMO"}));

//		solution(new String[] {"ABCBA","DABAG","EBABH","FAJAI","AKLMA"});
	}
	
	static int map[][][];
	public static int solution(String[] board) {
		BOARD = board;
		MAX = BOARD.length;
		
		while(0<MAX) {
			for(int i=0, size=BOARD.length-MAX; i<=size; i++) {
				for(int j=0; j<=size; j++) {
//					System.out.println(BOARD[i].charAt(j));
//					System.out.println(i+" / "+j+" / "+MAX+" : "+BOARD[i].charAt(j));
					if(check(i, j, BOARD[i].charAt(j))) {
						System.out.println("===");
						return MAX;
					};
				}
			}
			MAX-=2;
		}
		
		return 0;
	}
	private static boolean check(int r, int c, char key) {
		int len = MAX;
		int midr = (r+MAX)/2;
		int midc = (r+MAX)/2;
		
		for(int i=len; i>0; i-=2) {
//			System.out.println((r+i-1)+" / "+(c)+" : "+BOARD[r+i-1].charAt(c));
//			System.out.println((r)+" / "+(c+i-1)+" : "+BOARD[r].charAt(c+i-1));
//			System.out.println((r+i-1)+" / "+(c+i-1)+" : "+BOARD[r+i-1].charAt(c+i-1));
			
			if(BOARD[r+i-1].charAt(c)!=key) return false;
			if(BOARD[r].charAt(c+i-1)!=key) return false;
			if(BOARD[r+i-1].charAt(c+i-1)!=key) return false;
			r++; c++;
		}
//		System.out.println(BOARD[midr].charAt(midc));
		if(BOARD[midr].charAt(midc)!=key)return false;
		return true;
	}
	
}
