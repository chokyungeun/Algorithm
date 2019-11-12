import java.io.*;
import java.util.*;

public class Test {
	public static int[] S= {1,2};
	public static int[] A= {1,2},B;
	public static int W,H;
	
	public static void main(String[] args) throws Exception {
		B = new int[2];
		int idx=-1;
		String st="1";
		System.out.println(Arrays.asList(A).contains(st));
		for(int i=0; i<4; i++) {
			if(!Arrays.asList(S).contains(i)) {
				System.out.println("YES");
			}
		}
		System.out.println(Arrays.toString(B));
	}

}
