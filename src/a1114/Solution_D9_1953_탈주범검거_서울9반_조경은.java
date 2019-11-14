package a1114;
import java.io.*;
import java.util.*;

public class Solution_D9_1953_탈주범검거_서울9반_조경은 {
	public static int N,M,R,C,L;
	public static int[][] map;
	public static int[][] di= {{},{-1,1,0,0},{-1,1},{0,0},{-1,0},{1,0},{1,0},{-1,0}};
	public static int[][] dj= {{},{0,0,-1,1},{0,0},{-1,1},{0,1},{0,1},{0,-1},{0,-1}};
	public static boolean[][] v;
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		v[i][j]=true;
		q.offer(new int[] {i,j,1});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di[map[curr[0]][curr[1]]].length; k++){
				int ni = curr[0]+di[map[curr[0]][curr[1]]][k];
				int nj = curr[1]+dj[map[curr[0]][curr[1]]][k];
				if(ni>=0 && ni<N && nj>=0 && nj<M && !v[ni][nj] && map[ni][nj]!=0) {
					
					v[ni][nj]=true;
					if(curr[2]<L) {
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v= new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(R,C);
			int res=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(v[i][j]) res++;
					System.out.print(v[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("#" + t + " " + res);
		}
		
	}
}