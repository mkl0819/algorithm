
public class printMing {
	public void print(int[][] matrix) {
		for(int i=0, size = matrix.length; i<size; i++) {
			for(int j=0, size2 = matrix[0].length; j<size2; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	public void print(String msg, int[][][]matrix, int n) {
		System.out.println(msg);
		for(int i=0, size = matrix.length; i<size; i++) {
			for(int j=0, size2 = matrix[0].length; j<size2; j++) {
				System.out.printf("%3d", matrix[i][j][n]);
			}System.out.println();
		}System.out.println();
	}
}
