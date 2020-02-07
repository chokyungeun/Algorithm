package solution;

import java.io.*;
import java.util.*;

public class Solution_D4_9282_초콜릿과건포도_서울9반_조경은 {
	public static int n,m;
	public static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
		}
	}

}
