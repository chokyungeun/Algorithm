package algoad4;

import java.io.*;
import java.util.*;

public class Solution_D3_2814_최장경로_서울9반_조경은 {
	public static int N,M,max;
	public static int[][] graph;
	public static boolean[][] v;
	public static int[] d;
	public static boolean[] visit;
	

	public static void permComb(int start, int count) {
		if(count == N) {
			max = Math.max(max, count);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visit[i] && graph[d[count-1]][i]==1) {
				visit[i] = true;
				d[count] = i;
				permComb(i, count+1);
				visit[i] = false;
			}
		}
		max = Math.max(max, count);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2814.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			max=1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new int[N][N];
			v = new boolean[N][N];
			
			int x; int y;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken())-1;
				y = Integer.parseInt(st.nextToken())-1;
				graph[x][y] = 1;
				graph[y][x] = 1;
			}
			
			
			for(int i=0; i<N; i++) {
				d = new int[N];
				visit = new boolean[N];
				visit[i] = true;
				d[0] = i;
				permComb(0,1);
			}
			
			System.out.println("#" + t + " " + max);
		}

	}

}
