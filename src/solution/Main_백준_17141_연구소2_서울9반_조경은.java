package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17141_연구소2_서울9반_조경은 {
	public static int N, M, answer;
	public static int[][] arr, temp;
	public static ArrayList<int[]> virus;
	public static ArrayList<int[]> list;
	public static boolean[][] v;
	public static boolean[] visit;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		temp = new int[N][N];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					virus.add(new int[] {i,j});
					arr[i][j] = 0;
				}
			}
		}
		v = new boolean[N][N];
		visit = new boolean[virus.size()];
		answer = -1;
		
		
		System.out.println(answer);
	}

	public static void permComb(int start, int count) {
		if(count == M) {
			for(int i=0; i<N; i++) {
				temp[i] = arr[i].clone();
			}
			for(int i=0; i<list.size(); i++) {
				bfs(list.get(i)[0], list.get(i)[1]);
			}
			for(int )
			return;
		}
		for(int i=0; i<virus.size(); i++) { 
			if(!visit[i]) { 
				visit[i]=true;
				arr[virus.get(i)[0]][virus.get(i)[1]] = 2;
				list.add(new int[] {virus.get(i)[0],virus.get(i)[1]});
				permComb(i,count+1);
				list.remove(list.size()-1);
				arr[virus.get(i)[0]][virus.get(i)[1]] = 0;
				visit[i] = false; 
			} 
		}
	}

	private static int bfs(int i, int j) {
		int res=0;
		int index=0;
		ArrayList<Integer> time = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		index++;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			index++;
			if(index == 0) {
				res++;
			}
			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && temp[ni][nj] == 0) {
					temp[ni][nj] = 2;
					q.offer(new int[] { ni, nj });
					index++;
				}
			}
			
			
		}
		for(int k=0; k<)
		return res;
	}
}
