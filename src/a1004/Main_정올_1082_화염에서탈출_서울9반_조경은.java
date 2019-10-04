package a1004;

import java.io.*;
import java.util.*;

public class Main_정올_1082_화염에서탈출_서울9반_조경은 {
	public static int[] di = {-1, 1, 0, 0};
	public static int[] dj = {0,0,-1, 1};
	public static int R,C,res,rr,cc;
	public static char[][] arr;
	public static boolean[][] v,v2;
	public static ArrayList<Integer> list;
	
	public static void dfs(int i, int j) {
		if(i==rr && j==cc) {
			list.add(res);
			return;
		}
		v[i][j] = true;
		res++;
		v2 = new boolean[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(arr[r][c] == '*' && v2[r][c] == false) {
					v2[r][c]=true;
					for(int k=0; k<di.length; k++) {
						int ni = r + di[k];
						int nj = c + dj[k];
						if(ni>=0 && ni<R && nj>=0 && nj<C && arr[ni][nj]=='.') {
							arr[ni][nj] = '*';
							v2[ni][nj]=true;
						}
					}
				}
					
			}
		}
		
		
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<R && nj>=0 && nj<C && !v[ni][nj] && (arr[ni][nj] == '.' || arr[ni][nj]=='D')) {
				arr[i][j] = '.';
				arr[ni][nj]='S';
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
				if(arr[i][j]=='D') {
					rr=i;
					cc=j;
				}
				
			}
		}
		res = 0;
		list = new ArrayList<>();
		dfs(r,c);
		Collections.sort(list);
		if(list.size()==0) {
			System.out.println("impossible");
		}
		else {
			
			System.out.println(list.get(0));
		}
		

	}

}
