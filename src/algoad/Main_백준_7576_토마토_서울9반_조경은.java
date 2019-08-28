package algoad;
import java.io.*;
import java.util.*;

public class Main_백준_7576_토마토_서울9반_조경은 {
	public static int[] di = {-1, 1, 0, 0};
	public static int[] dj = {0,0,-1, 1};
	public static int N;
	public static int M;
	public static boolean[][] v;
	public static int[][] arr;
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
        v[i][j] = true;
        q.offer(new int[] {i,j});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int d = 0; d < di.length; d++) {
                int ni = curr[0]+di[d];
                int nj = curr[1]+dj[d];
                if(0<=ni && ni<N && 0<=nj && nj<N && v[ni][nj] == false && arr[ni][nj] == 0) {
                    v[ni][nj] = true;
                     
                    q.offer(new int[] {ni,nj});
                }
            }
        }
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		arr = new int[N][M];
		v = new boolean[N][M];
		int[] res = new int[100];
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		int num=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) {
					res[num]++;
					bfs(i,j);
				}
			}
		}

	}

}
