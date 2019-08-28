package dcbacktracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_정올_1335_색종이만들기_서울9반_조경은 {
	static int cnt0 = 0;
	static int cnt1 = 0;
	static public int N;
	static public int[][] a;

	public static void paper(int i, int j, int n) {
		int sum=0;
		for(int ni=i; ni<i+n; ni++) {
			for(int nj=j; nj<j+n; nj++) {
				sum+=a[ni][nj];
			}
		}
		if(sum==0)
			cnt0++;
		else if(sum==n*n)
			cnt1++;
		else {
			paper(i,j,n/2);
			paper(i,j+n/2,n/2);
			paper(i+n/2,j,n/2);
			paper(i+n/2,j+n/2,n/2);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1335.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		paper(0,0,N);

		System.out.println(cnt0);
		System.out.println(cnt1);

	}

}
