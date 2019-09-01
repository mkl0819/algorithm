package com.ssafy.library;

public class printMing {
	public static void print(int[][] matrix, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print(int r, int c) {
		System.out.printf("point : ( %3d, %3d ) \n", r, c);
	}

	public static void print(int[] array) {
		for (int i = 0, size = array.length; i < size; i++) {
			System.out.printf("%3d", array[i]);
		}
		System.out.println();
	}

	public static void print(int[][] matrix) {
		for (int i = 0, size = matrix.length; i < size; i++) {
			for (int j = 0, size2 = matrix[0].length; j < size2; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print(boolean[][] visited) {
		for (int i = 0, size = visited.length; i < size; i++) {
			for (int j = 0, size2 = visited[0].length; j < size2; j++) {
				System.out.printf("%3d", visited[i][j] ? 1 : 0);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print(String msg, int[][][] matrix, int n) {
		System.out.println(msg);
		for (int i = 0, size = matrix.length; i < size; i++) {
			for (int j = 0, size2 = matrix[0].length; j < size2; j++) {
				System.out.printf("%3d", matrix[i][j][n]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print(String name, Object data) {
		System.out.println(name + " : " + data);
	}

	public static void print(char[][][] cube) {
		for(int i=0, sizei=cube.length; i<sizei; i++) {
			for(int j=0, sizej=cube[0].length; j<sizej; j++	) {
				for(int k=0, sizek=cube[0][0].length; k<sizek; k++) {
					System.out.printf("%c ", cube[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void print(Integer[] array) {
		for (int i = 0, size = array.length; i < size; i++) {
			System.out.printf("%3d", array[i]);
		}
		System.out.println();		
	}

	public static void print(int[] array, int count) {
		for(int i=0; i<=count; i++) {
			System.out.printf("%3d", array[i]);
		}
		System.out.println();
	}

}
