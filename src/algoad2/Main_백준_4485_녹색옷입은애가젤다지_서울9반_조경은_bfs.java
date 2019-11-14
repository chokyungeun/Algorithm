package algoad2;
import java.io.*;
import java.util.*;

public class Main_백준_4485_녹색옷입은애가젤다지_서울9반_조경은_bfs {
	public static int N,res;
	public static int[][] map,memo;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static boolean[][] v;
	
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		memo[i][j] = map[i][j];
		q.offer(new int[] {i,j,memo[i][j]});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<N && memo[ni][nj]>curr[2]+map[ni][nj]) {
					memo[ni][nj]=curr[2]+map[ni][nj];
					q.offer(new int[] {ni,nj,memo[ni][nj]});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int index=1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			map = new int[N][N];
			memo = new int[N][N];
			v = new boolean[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				Arrays.fill(memo[i], Integer.MAX_VALUE);
			}
			bfs(0,0);
			
			System.out.println("Problem " + index + ": " + memo[N-1][N-1]);
			index++;
		}
		
	}

}
