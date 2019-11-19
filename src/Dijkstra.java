import java.io.*;
import java.util.*;

public class Dijkstra {
	public static int N, start, end, INF=987654321;
	public static int[][] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			graph = new int[N+1][N+1];
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(br.readLine());
			for(int i=0; i<num; i++) {
				st = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				graph[a][b] = graph[b][a] = c;
			}
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(graph[i][j]==0) {
						graph[i][j] = INF;
					}
				}
			}
			
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					}
				}
			}
			System.out.println(graph[start][end]);
		}

	}

}
