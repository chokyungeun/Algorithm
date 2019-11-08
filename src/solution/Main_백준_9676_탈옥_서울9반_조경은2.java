package solution;

import java.io.*;
import java.util.*;

public class Main_백준_9676_탈옥_서울9반_조경은2 {
	public static char[][] arr,a;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static ArrayList<int[]> list;
	public static int res,w,h,res2;
	public static boolean[][][] v;
	
	
	public static void dfs(int i, int j, int p, int temp) {
		if(temp>res) {
			return;
		}
		if(i==0 || i==h-1 || j==0 || j==w-1) {
			if(res > temp) {
				res = temp;
			}
			return;
		}
		
		v[p][i][j]=true;
		
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<h && nj>=0 && nj<w && !v[p][ni][nj] && arr[ni][nj]!='*') {
				if(v[(p+1)%2][ni][nj]) return;
				if(arr[ni][nj]=='#') {
					dfs(ni,nj,p,temp+1);
				}
				else {
					dfs(ni,nj,p,temp);
				}
			}
		}
		v[p][i][j] = false;
	}
	
	
	
	
	public static void bfs(int i1, int j1, int i2, int j2) {
		Queue<int[]> q = new LinkedList<>();
		v[0][i1][j1]=true;
		v[1][i2][j2] = true;
		q.offer(new int[] {i1,j1,1});
		q.offer(new int[] {i2,j2,2});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<h && nj>=0 && nj<w && !v[curr[2]][ni][nj]) {
					v[curr[2]][ni][nj]=true;
					if(v[(curr[2]+1)%2][ni][nj]) {
						continue;
					}
					if(arr[ni][nj]=='#') {
						res++;
					}
					q.offer(new int[] {ni,nj,curr[2]});
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			arr = new char[h][w];
			
			for(int i=0; i<h; i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					arr[i][j] = s.charAt(j);
					if(arr[i][j]=='$') {
						list.add(new int[] {i,j});
					}
				}
			}
			
			res=Integer.MAX_VALUE;
			v = new boolean[2][h][w];
		
			//dfs()
			
			//System.out.println(res2);
			
		}	
	}

}
