package a1220;
import java.io.*;
import java.util.*;

public class Solution2 {
	public static int N,M;
	public static boolean[][] small, big;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			small = new boolean[N][N];
			big = new boolean[N][N];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int s = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken()); 
				small[b][s] = true;
				big[s][b] = true;
			}
		}
	}
	
	
}
