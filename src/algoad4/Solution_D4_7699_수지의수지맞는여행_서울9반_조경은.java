package algoad4;

import java.io.*;
import java.util.*;

public class Solution_D4_7699_수지의수지맞는여행_서울9반_조경은 {
	public static int R,C,res;
	public static char[][] map;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static boolean[] alpha;
	public static boolean[][] v;
	
	
	public static void tour(int i, int j, int index) {
		res = Math.max(res, index);
		v[i][j] = true;
		alpha[map[i][j]] = true;
		
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<R && nj>=0 && nj<C && !v[ni][nj] && !alpha[map[ni][nj]]) {
				tour(ni,nj, index+1);
			}
		}
		v[i][j] = false;
		alpha[map[i][j]] = false;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7699.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			res=0;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			
			for(int i=0; i<R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			v = new boolean[R][C];
			alpha = new boolean[96];
			tour(0,0,1);
			
			System.out.println("#" + t + " " + res);
		}

	}

}
