package Solution;

import java.util.Scanner;

public class Solution_D3_2806_NQueen_서울9반_조경은 {
	public static int N;
	public static int result;
	public static int[] col;
	
	public static boolean promising(int i) {
		for(int j=0; j<i; j++) {
			if(col[j]==col[i] || Math.abs(col[i]-col[j])==(i-j)) //같은 열에 있거나 대각선 상에 있는 지 체크
				return false;
		}
		return true;
	}
	public static void nqueen(int i) {
		if(i==N) {
			result++;
			return;
		}
		for(int j=0; j<N; j++) {
			col[i]=j;
			if(promising(i)) nqueen(i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<T+1; tc++) {
			N = sc.nextInt();
			result = 0;
			col = new int[N];
			nqueen(0);
			System.out.println("#" + tc + " " + result);
		}
	}

}
