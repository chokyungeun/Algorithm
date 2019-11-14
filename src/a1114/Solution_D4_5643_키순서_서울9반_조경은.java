package a1114;
import java.io.*;
import java.util.*;

public class Solution_D4_5643_키순서_서울9반_조경은 {
	public static int N,M,ans,cnt;
	public static int[][] graph;
	public static int[] big,small;
	public static ArrayList<int[]> list;
	public static boolean[] v;
	
	public static void dfs(int i, int dir) {
		v[i] = true;
		for(int j=1; j<=N; j++) {
			if(!v[j] && graph[i][j]==dir) {
				cnt++;
				dfs(j,dir);
			}
		}
	}
	
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			graph=new int[N+1][N+1];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b]=1;
				graph[b][a]=2;
			}
			ans=0;
			for(int i=1; i<N+1; i++) {
				cnt=0;
				v = new boolean[N+1];
				dfs(i,1);
				dfs(i,2);
				if(cnt==N-1) ans++;
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
}