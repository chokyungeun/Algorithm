package dp;

import java.util.*;
import java.io.*;

public class Solution_D6_1263_사람네트워크2_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d6_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int INF = 987654321;
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] d = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && d[i][j]==0)
						d[i][j] = INF;
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					if(i==k) continue;
					for(int j=0; j<N; j++) {
						if(i==j || k==j)
							continue;
						
						d[i][j]=Math.min(d[i][k]+d[k][j], d[i][j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
	        for (int i = 0; i < N; i++) {
	            int num = 0;
	            for (int j = 0; j < N; j++) 
	            	num += d[i][j];
	            min = Math.min(min, num);
	        }
	        System.out.println("#" + t + " " + min);
		}
		
	}

}
