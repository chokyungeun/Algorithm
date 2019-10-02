package a1002;

import java.io.*;
import java.util.*;

public class Main_정올_1024_내리막길_백준_1520_서울9반_조경은 {

	public static int[] di= {-1, 1, 0, 0};
	public static int[] dj= {0, 0, -1, 1};
	public static int[][] arr, memo;
	public static boolean[][] v;
	public static int R, C;
	
	public static int dfs(int i, int j) {
		if(i==R-1 && j==C-1)
			return 1;
		if(memo[i][j]!=0)
			return memo[i][j];
		if(!v[i][j]) {
			v[i][j] = true;
			for(int k=0; k<di.length; k++) {
				int ni = i+di[k];
				int nj = j+dj[k];
				
				if(ni>=0 && ni<R && nj>=0 && nj<C && !v[ni][nj] && arr[ni][nj] < arr[i][j]) {
					memo[i][j]+=dfs(ni,nj);
				}
			}
			v[i][j] = false;
		}
		
		return memo[i][j];
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		StringTokenizer st;
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		arr = new int[R][C];
		memo = new int[R][C];
		v = new boolean[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = dfs(0,0);
		
		
		System.out.println(result);
	}

}
