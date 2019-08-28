package stack1;

import java.io.FileInputStream;
import java.util.Scanner;

public class PowerTest {
	
	public static int pow(int n, int m) {
		if(m == 0)
			return 1;
		if(m % 2 == 0) {
			int y=pow(n,m/2);
			return y*y;
		}
		else {
			int y=pow(n,(m-1)/2);
			return y*y*n;
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1217.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0; tc<10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
		
			System.out.println("#" + T + " " + pow(N, M));
			System.out.println("#" + T + " " + (int)Math.pow(N, M));
			
		}
	}

}
