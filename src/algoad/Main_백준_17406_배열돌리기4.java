package algoad;

import java.util.*;
import java.io.*;

public class Main_백준_17406_배열돌리기4 {
	public static int N, M, K, min;
	public static Point[] points;
	public static int dr[] = {0,1,0,-1};
	public static int dc[] = {1,0,-1,0};
	public static boolean[] visit;
	public static class Point{
		int r, c, s;
		Point(int r, int c, int s){
			this.r = r;
			this.c =c;
			this.s =s;
		}
		
	}
	
	public static void rotate(Point pt, int[][] map) {
		int S = pt.s;
		int r = pt.r;
		int c = pt.c;
		for(int s=1; s<=S; s++) {
			int tr = r-s;
			int tc= c-s;
			
			int tmp = map[tr][tc];
			int dir = 0;
			do {
				int nr = tr + dr[dir];
				int nc = tc + dc[dir];
				
				int prev = tmp;
				tmp = map[nr][nc];
				map[nr][nc] = prev;
				
				tr = nr;
				tc = nc;
				
				if(tr == r-s && tc==c+s) dir=1;
				if(tr == r+s && tc==c+s) dir=2;
				if(tr == r+s && tc==c-s) dir=3;
			}
			while(tr!=r-s || tc!=c-s);
		}
		
	}
	
	public static void dfs(int depth, int oper, int[][] map) {
		int[][] tap = new int[N][M];
		for(int i=0; i<N; i++)
			System.arraycopy(map[i], 0, tap[i], 0, M);
		
		if(oper!=-1)
			rotate(points[oper],tap);
		if(depth == K) {
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<M; j++){
					sum += tap[i][j];
				}
				min = Math.min(min,  sum);
			}
			return;
		}
		//perm
		for(int i=0; i<K; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(depth+1, i, tap);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		int[][] map = new int[N][M];
		points = new Point[K];
		visit = new boolean[K];
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<K; i++) {
			points[i] = new Point(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt());
		}
		
		min = Integer.MAX_VALUE;
		
		dfs(0, -1, map);
		System.out.println(min);
		
		sc.close();
		
	}
}
