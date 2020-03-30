package hyundaiNGV;


import java.util.*;
import java.io.*;

public class Main2 {
	public static int N,M,res,root;
	public static int[] p;
	public static ArrayList<int[]> tree;
	public static int[][] graph;
	
	public static int getParent(int x) {
		if(p[x] == x)
			return x;
		else {
			graph[getParent(p[x])][x] = 2;
			graph[x][getParent(p[x])] = 1;
			return p[x] = getParent(p[x]);
		}
	}
			
	
	public static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a<b) 
			p[b] = a;
		else
			p[a] = b;
	}
	
	public static int answer(int n1, int n2) {
		int ans = 0;
		
		for(int i=1; i<=N; i++) {
			if(graph[n1][i]==2 && graph[n2][i]!=2) {
				ans++;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new ArrayList<>();
		p = new int[N+1];
		graph = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			p[i+1] = Integer.parseInt(st.nextToken());
			graph[i+1][p[i+1]] = 1;
			graph[p[i+1]][i+1] = 2;
			unionParent(p[i+1], i+1);
		}
		
		res=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			res+=answer(n1,n2);
		}
		
		System.out.println(res);
	}

}
