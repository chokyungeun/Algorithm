package solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_1970_쉬운거스름돈_서울9반_조경은 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_D2_1970.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<T+1; t++) {
			int N = sc.nextInt();
			int n50000 = 0;
			int n10000 = 0;
			int n5000 = 0;
			int n1000 = 0;
			int n500 = 0;
			int n100 = 0;
			int n50 = 0;
			int n10 = 0;
			
			n50000 = N / 50000;
			N = N % 50000;
			n10000 = N / 10000;
			N = N % 10000;
			n5000 = N / 5000;
			N = N % 5000;
			n1000 = N / 1000;
			N = N % 1000;
			n500 = N / 500;
			N = N % 500;
			n100 = N / 100;
			N = N % 100;
			n50 = N / 50;
			N = N % 50;
			n10 = N / 10;
			
			System.out.println("#" + t);
			System.out.println(n50000 + " " + n10000 + " " + n5000 + " " + n1000 + " " + n500 + " " + n100 + " " + n50 + " " + n10);
		}

	}

}
