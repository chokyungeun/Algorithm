package a1114;
import java.io.*;
import java.util.*;

public class Main_정올_2613_토마토고_서울9반_조경은 {
	public static int M,N,res;
	public static int[][] arr;
	public static boolean[][] v;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static Queue<int[]> q;
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<M && !v[ni][nj] && arr[ni][nj]==0) {
					v[ni][nj]=true;
					arr[ni][nj]=curr[2]+1;
					q.offer(new int[] {ni,nj,curr[2]+1});
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M];
		q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					q.offer(new int[] {i,j,0});
					v[i][j]=true;
				}
			}
		}
		boolean b = false;
		Loop:for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) {
					b=true;
					break Loop;
				}
			}
		}
		if(!b) {
			System.out.println(0);
		}
		else {
			bfs();
			int res=0;
			for(int i=0; i<N; i++) {
				res = Math.max(res, Arrays.stream(arr[i]).max().getAsInt());
			}
			Loop:for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]==0) {
						res = -1;
						break Loop;
					}
				}
			}
			System.out.println(res);
		}
		
	}
}
