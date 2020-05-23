package midasIT1116;
import java.io.*;
import java.util.*;

public class Main {
	public static int[][] arr;
	
	public static void rotate(int[][] matrix) {
		
	}
	
	public static void main(String[] args) throws Exception {
		int[][] matrix = {{1,2},{3,4}};
		int r = 1;
		arr = new int[2][2];
		for(int i=0; i<2; i++) {
			arr[i] = Arrays.copyOf(matrix[i], matrix[i].length);
		}
		for(int i=0; i<r; i++) {
			rotate(arr);
		}
		
		System.out.println(Arrays.deepToString(arr));
	}

}
