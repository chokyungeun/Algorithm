package array1;

import java.util.Arrays;

public class Array1Test {

	public static void main(String[] args) {
		//1. 선언
		int[] a;
		//2. 생성
		a = new int[3];
		//1+2
		int[] b = new int[3];
		//3. 초기화
		b[0] = 10;
		b[1] = 11;
		b[2] = 12;
		//b[3] = 13;  //java.lang.ArrayIndexOutOfBoundsException: 3
		//b[-1] = 14; //java.lang.ArrayIndexOutOfBoundsException: -1
		//1+2+3
		int[] c = {10, 11, 12};
		int[] d = new int[]{10, 11, 12};
		//1, 2+3
		int[] e;
		//e = {10, 11, 12} //err
		e = new int[]{10, 11, 12};
		//4. 출력
		for(int i=0; i<e.length; i++)
			System.out.print(e[i] + " ");
		System.out.println();
		for(int v:e) 
			System.out.println(v);
		System.out.println(Arrays.toString(e));
		
		//5.복제
		int[] f = new int[e.length];
		//System.arraycopy(e,  0,  f,  0,  e.length); //pass by value
		f = Arrays.copyOf(e, e.length); //위의 것과 같은 표현
		e[0] = 0;
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));
		f = e.clone(); //pass by reference. 사용하지x
		e[0] = 0;
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));
	}
}
