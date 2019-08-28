package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1217_거듭제곱_서울9반_조경은 {
	static int res = 0;
	public static int a(int N, int M) {
		if(M == 0)
			return 1;
		if(M == 1)
			return N;
		N = res * N;
		return a(N, M-1);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1217.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0; tc<10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			res = N;
			
			int result = a(N, M);
			
			//System.out.println("#" + T + " " + result);
			System.out.println("#" + T + " " + (int)Math.pow(N, M));
			
		}
	}

}
