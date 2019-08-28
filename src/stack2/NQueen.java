package stack2;

import java.util.Scanner;

public class NQueen {
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
	
	public static void nqueen(int i, String ij) {
		if(i==N) {
			result++;
			System.out.println(ij);
			return;
		}
		for(int j=0; j<N; j++) {
			col[i]=j;
			if(promising(i)) nqueen(i+1, ij+"("+i+","+col[i]+")");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		nqueen(0,"");
		System.out.println(result);
	}
}
