package a1004;

import java.io.*;
import java.util.*;

public class Main_정올_1840_치즈_서울9반_조경은_bfs {
	public static int arr[][], N, M;
	public static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		int cnt = 0;
		int num = 0;
		int cur_check = 0;
		while (true) {
			cur_check = check(arr);
			if (cur_check == 0)
				break;
			else
				num = cur_check;
			v = new boolean[N][M];
			bfs(0, 0);
			
			
			
			cnt++;
		}
		System.out.println(cnt + "\n" + num);
	}
	private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        v[i][j] = true;
        
        int[] di = { 0, -1, 0, 1 };
		int[] dj = { -1, 0, 1, 0 };
        q.offer(new int[] {i,j});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int d = 0; d < di.length; d++) {
                int ni = curr[0]+di[d];
                int nj = curr[1]+dj[d];
                if(0<=ni && ni<N && 0<=nj && nj<M && !v[ni][nj]) {
                    v[ni][nj] = true;
                    if (arr[ni][nj] == 1) {
            			arr[ni][nj] = 0;
            		}else {
            			q.offer(new int[] {ni,nj});
            		}
                }
            }
        }
    }
	

	private static int check(int[][] v2) {
		int c = 0;
		for (int m = 0; m < N; m++) {
			for (int n = 0; n < M; n++) {
				c += v2[m][n];
			}
		}
		return c;
	}

}
