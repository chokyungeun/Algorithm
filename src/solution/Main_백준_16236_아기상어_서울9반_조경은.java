package solution;

import java.util.*;
import java.io.*;

public class Main_백준_16236_아기상어_서울9반_조경은 {
	public static int[] di = {-1,0,1,0};
	public static int[] dj = {0,-1,0,1};
	public static int[][] arr;
	public static int N, res, size, f;
	public static ArrayList<int[]> l;
	
	public static void bfs(int i, int j, int depth) {
		Queue<int[]> q = new LinkedList<>();
		if(depth == N+1) {
			res = depth;
			return;
		}
		int index = 0;
		for(int row=0; row<N; row++) {
			for(int col=0; col<N; col++) {
				if(arr[row][col] != 0) {
					index++;
				}
			}
		}
		if(index == 1) {
			res = depth;
			return;
		}
		depth++;
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for(int k=0; k<di.length; k++) {
				int ni = curr[0] + di[k]*depth;
				int nj = curr[0] + dj[k]*depth;
				if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj] < size) {
					f+=arr[ni][nj];
					if(f>=size) {
						size += f/size;
						f = f%size;
					}
					arr[ni][nj] = 9;
					arr[i][j] = 0;
					q.offer(new int[] {ni, nj});
				}
			}
			
		}
		
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
		f = 0;
		bfs(row, col, 0);
		
		System.out.println(res);


	}

}
