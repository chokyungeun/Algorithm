package solution;

import java.util.*;
import java.io.*;

public class Main_백준_16236_아기상어_서울9반_조경은 {
	public static int[] di = {-1,0,1,0};
	public static int[] dj = {0,-1,0,1};
	public static int[][] arr;
	public static int N, res, size, f;
	public static ArrayList<int[]> l;
	
	
	public static void sort(int i, int j) {
		for(int k=0; k<di.length; k++) {
			l.add(new int[] {i + di[k], j + di[k]});
		}
		Collections.sort(l, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return arr[o1[0]][o1[1]] - arr[o2[0]][o2[1]];
			}
		});
	}
	
	public static void bfs(int i, int j, int depth) {
		int num = 0;
		int row = 0;
		int col = 0;
		for(int k=0; k<N; k++) {
			for(int l=0; l<N; l++) {
				if(arr[k][l] > size) {
					num++;
					row = k;
					col = l;
				}
			}
		}
		if(num == 0) {
			return;
		}
		res++;
		f+=arr[i][j];
		arr[i][j] = 0;
		if(f >= size) {
			f -= size;
			size++;
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di.length; k++) {
				sort(curr[0], curr[1]);
				int ni = l.get(k)[0];
				int nj = l.get(k)[1];
				if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj] != 0 && arr[ni][nj] != 0 && arr[ni][nj] < size) {
					f+=arr[i][j];
					arr[i][j] = 0;
					if(f >= size) {
						f -= size;
						size++;
					}
					q.offer(new int[] {ni, nj});
				}
			}
			
		}
		depth++;
		if(depth == N)
			return;
		bfs(i, j, depth);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int row = 0;
		int col = 0;
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
				if(arr[i][j] == 9) {
					row = i;
					col = j;
				}
			}
		}
		res = 0;
		size = 2;
		arr[row][col] = 0;
		f = 0;
		bfs(row, col, 0);
		
		System.out.println(res);


	}

}
