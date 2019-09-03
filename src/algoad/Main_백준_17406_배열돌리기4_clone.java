package algoad;

import java.util.*;
import java.io.*;

public class Main_백준_17406_배열돌리기4_clone {
	
	public static int N, M, K, min;
	public static boolean[] visit;
	public static int[] a;
	public static int[][] map;
	public static int[][] pts;
	public static int[][] tap;
	public static class Point{
		int r, c, s;
		Point(int r, int c, int s){
			this.r = r;
			this.c =c;
			this.s =s;
		}
		
	}
	
	public static void rotate(int[] pts) {
		for(int s=pts[2]; s>0; s--) {
			int len=s*2+1;
			int r=pts[0]-s;
			int c=pts[1]-s;
			
			int temp = tap[r][c];
			for(int i=1; i<len;i++) {
				tap[r][c] = tap[r+1][c];
				r++;
			}
			for(int i=1; i<len;i++) {
				tap[r][c] = tap[r][c+1];
				c++;
			}
			for(int i=1; i<len;i++) {
				tap[r][c] = tap[r-1][c];
				r--;
			}
			for(int i=1; i<len;i++) {
				tap[r][c] = tap[r][c-1];
				c--;
			}
			tap[r][c+1] = temp;
		}
		
	}
	
	public static void perm(int step, int K) {
		if(step == K) {
			for(int i=0; i<map.length; i++)
				tap[i] = map[i].clone();
			for(int i=0; i<a.length; i++)
				rotate(pts[a[i]]);
			for(int i=1; i<map.length; i++) {
				int sum=0;
				for(int j=1; j<map[i].length; j++)
					sum+=tap[i][j];
				if(min>sum)
					min = sum;
			}
			return;
		}
		//perm
		for(int i=step; i<K; i++) {
			int T = a[step];
			a[step] = a[i];
			a[i] = T;
			perm(step+1, K);
			T = a[step];
			a[step] = a[i];
			a[i] = T;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N+1][M+1];
		tap = new int[N+1][M+1];
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		pts=new int[K][3];
		for(int i=0; i<K; i++) {
			pts[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		}
		a = new int[K];
		for(int i=0; i<K; i++) {
			a[i] = i;
		}
		min = Integer.MAX_VALUE;
		perm(0, K);
		System.out.println(min);
		
		sc.close();
		
	}
}
