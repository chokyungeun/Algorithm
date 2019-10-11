package a1010;

import java.io.*;
import java.util.*;

public class Main_백준_17472_다리만들기2_서울9반_조경은_kruskal {
	public static int[][] arr, graph;
	public static int cnt, INF = 987654321, N, M;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) * -1;
			}
		}
		cnt = 0; // 섬의개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == -1)
					bfs(i, j, ++cnt); // 섬에 번호 붙임
			}
		}
		graph = new int[cnt][cnt];
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < M; j++) {
				if (i == j)
					continue;
				graph[i][j] = INF;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
							if (arr[ni][nj] == 0) {
								dfs(i, j, ni, nj, d, 1);
							}
						}
					}
				}
			}
		}
		System.out.println(kruskal());
	}

	private static void dfs(int i, int j, int ci, int cj, int d, int cnt) {
		int ni = ci + di[d];
		int nj = cj + dj[d];
		if (0 <= ni && ni < N && 0 <= nj && nj < M) {
			if (arr[ni][nj] == 0) {
				dfs(i, j, ni, nj, d, cnt + 1);
			} else {
				int s = arr[i][j] - 1;
				int e = arr[ni][nj] - 1;
				if (cnt >= 2) {
					if (graph[s][e] > cnt) {
						graph[s][e] = cnt;
						graph[e][s] = cnt;
					}
				}
			}
		}
	}

	public static int findSet(int x) {
		if(p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}
	
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a<b) 
			p[b] = a;
		else
			p[a] = b;
	}
	
	public static int kruskal() {
		List<int[]> v = new ArrayList<>();
		for(int i=0; i<cnt; i++) {
			for(int j=0; j<cnt; j++) {
				if(i!=j && graph[i][j]!=INF) 
					v.add(new int[] {i,j,graph[i][j]});
			}
		}
		Collections.sort(v, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for(int[] e:v)
			System.out.println(Arrays.toString(e));
		
		p = new int[cnt];
		for(int i=0; i<cnt; i++)
			p[i] = i;
		
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			if(findSet(v.get(i)[0]) != findSet(v.get(i)[1])) {
				System.out.println("->" + Arrays.toString(v.get(i)));
				sum = sum+v.get(i)[2];
				union(v.get(i)[0], v.get(i)[1]);
			}
			
		}
		int p0=findSet(0);
		for(int i=1; i<cnt; i++) {
			int p1=findSet(i);
			if(p0!=p1) return -1;
		}
		return sum;
	}

	private static void bfs(int i, int j, int k) {
		Queue<int[]> q = new LinkedList<int[]>();
		arr[i][j] = cnt;
		q.offer(new int[] { i, j, cnt });
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
					if (arr[ni][nj] == -1) {
						arr[ni][nj] = cnt;
						q.offer(new int[] { ni, nj });
					}
				}
			}
		}

	}

}
