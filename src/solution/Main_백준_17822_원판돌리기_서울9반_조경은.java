package solution;

import java.io.*;
import java.util.*;

public class Main_백준_17822_원판돌리기_서울9반_조경은 {
	public static int N, M, T;
	public static int[][] c;
	public static ArrayList<int[]> list;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static boolean[][] v;
	
	public static void bfs(int i, int j) {
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<N) {
				if(c[i][j]!=0 && c[i][j]==c[ni][(M+nj)%M]) {
					v[i][j]=true;
					v[ni][(M+nj)%M]=true;
				}
			}
		}
	}

	public static void rot(int num, int dir, int k) {
		for(int i=0; i<N; i++) {
			if((i+1)%num==0) {
				int[] temp = new int[M];
				if(dir==0) {
					for(int j=k; j<M+k; j++) {
						temp[j%M] = c[i][j-k];
					}
				}
				else {
					for(int j=0; j<M; j++) {
						temp[j] = c[i][(j+k)%M];
					}
				}
				for(int j=0; j<M; j++) {
					c[i][j] = temp[j];
				}
			}
		}
		v = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				bfs(i,j);
			}
		}
		boolean flag = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(v[i][j]) {
					c[i][j]=0;
					flag = true;
				}
			}
		}
		double sum=0.0;
		int x=0;
		if(!flag) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(c[i][j]!=0) {
						sum+=c[i][j];
						x++;
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(c[i][j]!=0 && c[i][j]>sum/x) {
						c[i][j]--;
					}
					else if(c[i][j]!=0 && c[i][j]<sum/x) {
						c[i][j]++;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		c = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				c[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) });
		}

		for (int i = 0; i < T; i++) {
			rot(list.get(i)[0], list.get(i)[1], list.get(i)[2]);
		}
		int res = 0;
		for (int x = 0; x < N; x++) {
			for (int j = 0; j < M; j++) {
				res += c[x][j];
			}
		}

		System.out.println(res);

	}

}
