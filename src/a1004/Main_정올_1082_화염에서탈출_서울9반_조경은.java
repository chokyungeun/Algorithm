package a1004;

import java.io.*;
import java.util.*;

public class Main_정올_1082_화염에서탈출_서울9반_조경은 {
	public static int[] di = {-1, 1, 0, 0};
	public static int[] dj = {0,0,-1, 1};
	public static int R,C,res, res2;
	public static char[][] arr;
	public static boolean[][] v;
	
	public static void dfs(int i, int j) {
		if(arr[i][j]=='D') {
			res2 = res;
			return;
		}
		v[i][j] = true;
		res++;
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<R && nj>=0 && nj<C && arr[ni][nj]=='.') {
				arr[ni][nj] = '*';
			}
		}
		
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<R && nj>=0 && nj<C && !v[ni][nj] && arr[ni][nj] != '*' && arr[ni][nj]!='X') {
				arr[i][j] = '.';
				dfs(ni, nj);
			}
		}
		
		v[i][j] = false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		arr = new char[R][C];
		v = new boolean[R][C];
		for(int i=0; i<R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int r=0;
		int c=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]== 'S') {
					r=i;
					c=j;
				}
				
			}
		}
		res = 0;
		res2 = 0;
		dfs(r,c);
		if(res2 == 0) {
			System.out.println("impossible");
		}
		else {
			
			System.out.println(res2);
		}
		

	}

}
