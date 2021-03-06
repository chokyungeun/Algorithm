package solution;

import java.io.*;
import java.util.*;

public class Solution_D4_7733_치즈도둑_서울9반_조경은 {
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static int[][] arr;
	public static boolean[][] v;
	public static int N;
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		v[i][j] = true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj= curr[1]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<N && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max=1;
			for(int date=1; date<=100; date++) {
				int res = 0;
				v = new boolean[N][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(arr[i][j] <= date) {
							v[i][j] = true;
						}
					}
				}
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(!v[i][j]) {
							res++;
							bfs(i,j);
							if(max < res) {
								max = res;
							}
						}
					}
				}
				
			}
			
			System.out.println("#" + t + " " + max);
		}
	}

}


