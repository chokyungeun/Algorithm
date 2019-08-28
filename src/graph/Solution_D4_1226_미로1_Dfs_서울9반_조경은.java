package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_1226_미로1_Dfs_서울9반_조경은 {
	public static int[][] arr;
	public static boolean[][] v;
	public static int res;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	
	public static void dfs(int i, int j) {
		v[i][j] = true;
		if(arr[i][j] == 3) {
			res = 1;
			return;
		}
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			
			if(ni>=0 && ni<16 && nj>=0 && nj<16 && arr[ni][nj] != 1 && v[ni][nj] == false) {
				dfs(ni, nj);
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<10; t++) {
			int T = Integer.parseInt(br.readLine());
			res = 0;
			arr = new int[16][16];
			v = new boolean[16][16];
			int x=0;
			int y=0;
			for(int i=0; i<16; i++) {
				String[] s = br.readLine().split("");
				for(int j=0; j<16; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
					if(arr[i][j] == 2) {
						x = i;
						y = j;
						
					}
				}
			}
			dfs(x, y);
			System.out.println("#" + T + " " + res);
		}
		
	}

}
