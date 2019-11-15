package algoad2;

import java.io.*;
import java.util.*;

public class Main_정올_1113_119구급대_서울9반_조경은_dijkstra {
	public static int N,M,m,n,res;
	public static int[][] map;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static boolean[][] v;
	
	public static void dfs(int i, int j, int dir, int r) {
		if(r>res) {
			return;
		}
		if(i==m && j==n) {
			res = Math.min(res, r);
			return;
		}
		
		
		v[i][j]=true;
		for(int k=0; k<di.length; k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			if(ni>=0 && ni<N && nj>=0 && nj<M && !v[ni][nj] && map[ni][nj]==1) {
				if(k!=dir)
					dfs(ni,nj,k,r+1);
				else
					dfs(ni,nj,k,r);
			}
		}
		v[i][j] = false;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res=Integer.MAX_VALUE;
		dfs(0,0,1,0);
		dfs(0,0,3,0);
		
		System.out.println(res);
	}

}
