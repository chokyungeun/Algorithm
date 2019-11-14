package a1114;
import java.io.*;
import java.util.*;

public class Main_정올_2606_토마토초_서울9반_조경은 {
	public static int M,N,H,res;
	public static int[][][] arr;
	public static boolean[][][] v;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static int[] dk= {-1,1};
	public static Queue<int[]> q;
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di.length; k++) {
				int nk = curr[0];
				int ni = curr[1]+di[k];
				int nj = curr[2]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<M && !v[nk][ni][nj] && arr[nk][ni][nj]==0) {
					v[nk][ni][nj]=true;
					arr[nk][ni][nj]=curr[3]+1;
					q.offer(new int[] {nk,ni,nj,curr[3]+1});
				}
			}
			for(int k=0; k<2; k++) {
				int nk = curr[0]+dk[k];
				int ni = curr[1];
				int nj = curr[2];
				if(nk>=0 && nk<H && !v[nk][ni][nj] && arr[nk][ni][nj]==0) {
					v[nk][ni][nj]=true;
					arr[nk][ni][nj]=curr[3]+1;
					q.offer(new int[] {nk,ni,nj,curr[3]+1});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		arr = new int[H][N][M];
		v = new boolean[H][N][M];
		q = new LinkedList<>();
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[k][i][j] = sc.nextInt();
					if(arr[k][i][j]==1) {
						q.offer(new int[] {k,i,j,0});
						v[k][i][j]=true;
					}
				}
			}
		}
		boolean b = false;
		Loop:for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[k][i][j]==0) {
						b=true;
						break Loop;
					}
				}
			}
		}
		if(!b) {
			System.out.println(0);
		}
		else {
			bfs();
			int res=0;
			for(int k=0; k<H; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						res = Math.max(res, arr[k][i][j]);
					}
				}
			}
			Loop:for(int k=0; k<H; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(arr[k][i][j]==0) {
							res = -1;
							break Loop;
						}
					}
				}
			}
			System.out.println(res);
		}
		
	}
}
