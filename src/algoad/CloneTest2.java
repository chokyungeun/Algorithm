package algoad;

import java.util.Arrays;

public class CloneTest2 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		
		//int[][] b = a; //544700ns
		//int[][] b = a.clone(); //688000ns
		//int[][] b = Arrays.copyOf(a, a.length); //642500ns
		int[][] b = new int[a.length][a.length]; 
		for(int i=0; i<a.length; i++) {
			b[i] = a[i].clone();
			//b[i] = Arrays.copyOf(a[i], a[i].length);
			//System.arraycopy(a[i], 0, b[i], 0, a[i].length);
		}
		
		
		for(int[] r:a) System.out.println(Arrays.toString(r));
		System.out.println();
		for(int[] r:b) System.out.println(Arrays.toString(r));
		System.out.println();
		System.out.println();
		a[0][0] = 11;
		for(int[] r:a) System.out.println(Arrays.toString(r));
		System.out.println();
		for(int[] r:b) System.out.println(Arrays.toString(r));
		System.out.println();
		System.out.println();
		b[2][2] = 99;
		for(int[] r:a) System.out.println(Arrays.toString(r));
		System.out.println();
		for(int[] r:b) System.out.println(Arrays.toString(r));
		System.out.println();
		System.out.println(System.nanoTime()-start+"ns");
	}

}
