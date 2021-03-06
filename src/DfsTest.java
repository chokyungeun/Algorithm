import java.util.*;
import java.io.*;

public class DfsTest {
	public static int[][] map;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int starti, startj, endi, endj, res;
	public static boolean[][] visit;
	
	public static void dfs(int i, int j) {
		visit[i][j] = true;
		
		if(map[i][j] == 3) {
			res = 1;
			return;
		}
		
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<16 && nj>=0 && nj<16 && map[ni][nj] !=1 && visit[ni][nj] == false) {
				dfs(ni,nj);
			}
		}
		visit[i][j] = false;
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[16][16];
			
			for(int i=0; i<16; i++) {
				char[] c = br.readLine().toCharArray();
				for(int j=0; j<16; j++) {
					map[i][j] = c[j]-'0';
					if(map[i][j] == 2) {
						starti = i;
						startj = j;
					}
					if(map[i][j] == 3) {
						endi = i;
						endj = j;
					}
				}
			}
			visit = new boolean[16][16];
			res=0;
			dfs(starti, startj);
			System.out.println("#" + T + " " + res);
		}
		
	}

}
