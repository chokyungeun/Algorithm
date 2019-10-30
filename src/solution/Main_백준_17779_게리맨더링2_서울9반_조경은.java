package solution;

import java.io.*;
import java.util.*;

public class Main_백준_17779_게리맨더링2_서울9반_조경은 {
	public static int N,min;
	public static int[][] map,dis;
	public static boolean[][] v;
	public static int[] di = {-1,1,1,-1};
	public static int[] dj = {1,1,-1,-1};
	public static int[] ppl;
	
	public static boolean divide(int i, int j, int d1, int d2) {
		dis = new int[N][N];
		dis[i][j] = 5;
		for(int k=0; k<d1; k++) {
			int ni = i+di[0];
			int nj = j+dj[0];
			if(ni<0 || ni>=N || nj<0 || nj>=N) {
				return false;
			}
			else {
				dis[ni][nj]=5;
				i = ni;
				j = nj;
			}
		}
		for(int k=0; k<d2; k++) {
			int ni = i+di[1];
			int nj = j+dj[1];
			if(ni<0 || ni>=N || nj<0 || nj>=N) {
				return false;
			}
			else {
				dis[ni][nj]=5;
				i = ni;
				j = nj;
			}
		}
		for(int k=0; k<d1; k++) {
			int ni = i+di[2];
			int nj = j+dj[2];
			if(ni<0 || ni>=N || nj<0 || nj>=N) {
				return false;
			}
			else {
				dis[ni][nj]=5;
				i = ni;
				j = nj;
			}
		}
		for(int k=0; k<d2; k++) {
			int ni = i+di[3];
			int nj = j+dj[3];
			if(ni<0 || ni>=N || nj<0 || nj>=N) {
				return false;
			}
			else {
				dis[ni][nj]=5;
				i = ni;
				j = nj;
			}
		}
		
		
		return true;
	}
	
	public static void number() {
		int x1=0;
		int y1=0;
		int x2=0;
		int y2=0;
		int x3=0;
		int y3=0;
		int x4=0;
		int y4=0;
		Loop:for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(dis[i][j]==5) {
					x1=i;
					y1=j;
					break Loop;
				}
			}
		}
		Loop:for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(dis[j][i]==5) {
					x2=j;
					y2=i;
					break Loop;
				}
			}
		}
		Loop:for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>=0; j--) {
				if(dis[j][i]==5) {
					x4=j;
					y4=i;
					break Loop;
				}
			}
		}
		Loop:for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>=0; j--) {
				if(dis[i][j]==5) {
					x3=i;
					y3=j;
					break Loop;
				}
			}
		}
		for(int i=0; i<x2; i++) {
			for(int j=0; j<=y1; j++) {
				if(dis[i][j]==0)
					dis[i][j]=1;
				else if(dis[i][j]==5)
					break;
			}
		}
		for(int i=0; i<=x4; i++) {
			for(int j=N-1; j>y1; j--) {
				if(dis[i][j]==0)
					dis[i][j]=2;
				else if(dis[i][j]==5)
					break;
			}
		}
		for(int i=x2; i<N; i++) {
			for(int j=0; j<y3; j++) {
				if(dis[i][j]==0)
					dis[i][j]=3;
				else if(dis[i][j]==5)
					break;
			}
		}
		for(int i=N-1; i>x4; i--) {
			for(int j=N-1; j>=y3; j--) {
				if(dis[i][j]==0)
					dis[i][j]=4;
				else if(dis[i][j]==5)
					break;
			}
		}
		calc();
	}
	
	public static void calc() {
		
		ppl = new int[6]; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ppl[dis[i][j]]+=map[i][j];
			}
		}
		ppl[5]+=ppl[0];
		Arrays.sort(ppl);
		int temp = ppl[5]-ppl[1];
		min = Math.min(min, temp);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dis = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min=Integer.MAX_VALUE;
		
		for(int d1=1; d1<N-1; d1++) {
			for(int d2=1; d2<N-1; d2++) {
				for(int i=d1; i<N; i++) {
					for(int j=0; j<N-d2; j++) {
						boolean tf = divide(i,j,d1,d2);
						if(tf) {
							number();
						}
					}
				}
			}
		}
		System.out.println(min);
		
	}

}
