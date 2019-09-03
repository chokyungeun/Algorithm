package algoad;

import java.util.Arrays;

public class CloneTest1 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		int[] a = {1,2,3,4,5,6,7,8,9};
		
		//int[] b = a; //544700ns
		//int[] b = a.clone(); //688000ns
		//int[] b = Arrays.copyOf(a, a.length); //642500ns
		int[] b = new int[a.length]; //배열이 이미 만들어져있다면 이것을 사용하는 것이 빠름
		System.arraycopy(a, 0, b, 0, a.length); //593900ns
		
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println();
		a[0] = 11;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println();
		b[8] = 99;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(System.nanoTime()-start+"ns");
	}

}
