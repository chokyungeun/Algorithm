package solution;

import java.io.*;
import java.util.*;
public class Main_백준_17070_파이프옮기기1_서울9반_조경은 {
	public static int[][] arr;
	public static int N, res, ni, nj;
	public static int[] di = {0,1,1};
	public static int[] dj = {1,1,0};
	public static void dfs(int i, int j, int dir) {
		if(i==N-1 && j==N-1) {
			res++;
			return;
		}
		
		if(dir==0) {
			ni = i+di[0];
			nj = j+dj[0];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]==0) dfs(ni,nj,0);
			ni = i+di[1];
			nj = j+dj[1];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]==0 && arr[ni-1][nj]==0 && arr[ni][nj-1]==0) dfs(ni,nj,1);
		}
		else if(dir==1) {
			ni = i+di[0];
			nj = j+dj[0];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]==0) dfs(ni,nj,0);
			ni = i+di[1];
			nj = j+dj[1];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]==0 && arr[ni-1][nj]==0 && arr[ni][nj-1]==0) dfs(ni,nj,1);
			ni = i+di[2];
			nj = j+dj[2];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]==0) dfs(ni,nj,2);
			
		}
		else if(dir==2) {
			ni = i+di[2];
			nj = j+dj[2];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]==0) dfs(ni,nj,2);
			ni = i+di[1];
			nj = j+dj[1];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]==0 && arr[ni-1][nj]==0 && arr[ni][nj-1]==0) dfs(ni,nj,1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		dfs(0,1,0);
		
		System.out.println(res);
	}

}
