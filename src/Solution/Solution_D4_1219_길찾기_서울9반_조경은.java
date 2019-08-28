package Solution;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1219_길찾기_서울9반_조경은 {
	public static int N;
	public static int[][] graph;
	public static boolean[] visit;
	
	private static void dfs(int node) {
		visit[node] = true;
		
		for(int next = 0; next < 100; next++) { 
			if(visit[next] == false && graph[node][next] == 1) {
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<10+1; tc++) {
			int T = sc.nextInt();
			N = sc.nextInt();
			int result = 0;
			graph = new int[100][100];
			for(int i=0; i<N; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				
				graph[v1][v2] = 1;
			}
			visit = new boolean[100];
			dfs(0);
			
			if(visit[99] == true) {
				result = 1;
			}
			System.out.println("#" + T + " " + result);
		}
		
	}
	
}
