package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1077_배낭채우기1_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] w = new int[N + 1];
		int[] v = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		int[][] k = new int[N+1][W+1];
		
		for(int i=1; i<=N; i++) {
            for(int j=1; j<=W; j++) {
                if(w[i] > j) {
                    k[i][j] = k[i-1][j]; 
                } else {
                    k[i][j] = Math.max(k[i][j-w[i]]+v[i],k[i-1][j]);
                }
            }
        }
          
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=W; j++) {
				System.out.print(k[i][j] + " ");
			}
			System.out.println();
		}
        System.out.println(k[N][W]);
		
	}
}
