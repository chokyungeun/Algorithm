package solution;

import java.io.*;
import java.util.*;
public class Main_백준_17070_파이프옮기기1_서울9반_조경은 {
	public static int[][] arr;
	public static int N, res;
	public static boolean[][] v;
	public static int[] di = {1,0,1};
	public static int[] dj = {0,1,1};
	public static int dir;
	public static void dfs(int i, int j) {
		if(i==N-1 && j==N-1) {
			res++;
			return;
		}
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni<N && nj<N && arr[ni][nj]==0) {
				if(k==2) {
					if(ni<0 || ni>=N || nj<0 || nj>=N || arr[ni-1][nj]==1 || arr[ni][nj-1]==1)
						continue;
				}
				dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		v[0][0] = true;
		res = 0;
		dir = 0;  
		dfs(0,1);
		
		System.out.println(res);
	}

}
