package a0904;

import java.util.*;
import java.io.*;

public class Main_백준_3109_빵집_서울9반_조경은 {
	public static int[] di = {-1, 0, 1};
	public static int[] dj = {1, 1, 1};
	public static int R, C, res;
	public static char[][] arr;
	public static boolean[][] v;
	
	public static boolean dfs(int i, int j) {
		if(j == C-1) {
			res++;
			return true;
		}
		v[i][j] = true;
		for(int k=0; k<di.length; k++) { 
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<R && nj<C && arr[ni][nj] != 'x' && !v[ni][nj]) {
				if(dfs(ni, nj)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		arr = new char[R][C];
		v = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String st = br.readLine();
			arr[i] = st.toCharArray();
		}
		res = 0;
		
		
		for(int i=0; i<R; i++) {
			dfs(i, 0);
		}
		System.out.println(res);
	}

}
