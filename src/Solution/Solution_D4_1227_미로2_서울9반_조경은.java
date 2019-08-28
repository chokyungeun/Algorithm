package Solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1227_미로2_서울9반_조경은 {
	public static int[] di = {0,0,-1,1};
	public static int[] dj = {-1,1,0,0};
	public static int[][] visit;
	public static int N = 100;
	public static int[][] maze;
	public static int res;
	
	private static void dfsr(int i, int j) {
		visit[i][j] = 1;
		if(maze[i][j] == 3) {
			res = 1;
			return;
		}
		
		for(int d = 0; d < di.length; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && maze[ni][nj] != 1 && visit[ni][nj] == 0) {
				dfsr(ni, nj);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1227.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<11; tc++) {
			res = 0;
			int ni = 0;
			int nj = 0;
			String line1 = br.readLine();
			String[] sa = line1.split(" ");
			int T = Integer.parseInt(sa[0]);
			
			maze = new int[100][100];
			visit = new int[100][100];
			for(int i=0; i<100; i++) {
				char[] line = br.readLine().toCharArray();
				for(int j=0; j<line.length; j++) {
					maze[i][j] = line[j] -'0';
				}
			}
			Loop:for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					if(maze[i][j] == 2) {
						ni = i;
						nj = j;
						break Loop;
					}
				}
			}
			dfsr(ni, nj);
			
			System.out.println("#" + T + " " + res);
		}
	}

}
