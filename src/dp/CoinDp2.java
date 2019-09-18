package dp;

import java.util.Arrays;

public class CoinDp2 {
	public static int[] coin = {1,4,6};
	public static int[][] m;
	
 	public static void main(String[] args) {
		int N = 8;
		m = new int[coin.length][N+1];
		
		for(int i=0; i<coin.length; i++) {
			for(int j=1; j<=N; j++) {
				if(i<1) {
					m[i][j]=m[i][j-coin[i]]+1;
				}
				else if(j<coin[i]) {
					m[i][j] = m[i-1][j];
				}
				else {
					m[i][j] = Math.min(m[i][j-coin[i]]+1, m[i-1][j]);
				}
			}
		}
		
		System.out.println(m[coin.length-1][N]);
		for(int[] a:m)
			System.out.println(Arrays.toString(a));
	}

}
