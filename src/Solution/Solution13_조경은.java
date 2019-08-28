package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution13_조경은 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc < T+1; tc++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			int[][] num = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					String s = sc.next();
					arr[i][j] = s.charAt(0);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int a = 0;
					if(arr[i][j] == 'B') {
						int[] di = {-1,0,1,1,1,0,-1,-1};
						int[] dj = {-1,-1,-1,0,1,1,1,0};
						for(int d=0; d<8; d++) {
							int ni = i+di[d];
							int nj = j+dj[d];
							if(0<=ni && ni<N && 0<=nj && nj<N) {
								if(arr[ni][nj] == 'G') {
									num[i][j] = 2;
									break;
								}
								
							}
							if(d==7) {
								for(int k=0; k<N; k++) {
									if(arr[i][k] == 'B')
										++num[i][j];
									if(arr[k][j] == 'B')
										++num[i][j];
								}
								
							}
						}
					}
				}
			}
			int max = num[0][0];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(max < num[i][j])
						max = num[i][j];
				}
			}
		
			
			System.out.println("#" + tc + " " + (max-1));
		}

	}

}
