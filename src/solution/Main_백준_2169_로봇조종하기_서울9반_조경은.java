package solution;
import java.io.*;
import java.util.*;

public class Main_백준_2169_로봇조종하기_서울9반_조경은 {
	public static int N,M,res;
	public static int[][] map, memo;
	public static int[] di = {0,0,1};
	public static int[] dj = {-1,1,0};
	public static boolean[][][] v;
	
	public static void bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return -(o1[2]-o2[2]);
			}
		});
		pq.offer(new int[] {0,0,map[0][0]});
		memo[0][0]=map[0][0];
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			if(curr[0]==N-1 && curr[1]==M-1) {
				res = Math.max(res, curr[2]);
				continue;
			}
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<M && memo[ni][nj]<curr[2]+map[ni][nj]) {
					memo[ni][nj] = curr[2]+map[ni][nj];
					pq.offer(new int[] {ni,nj,memo[ni][nj]});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new boolean[N*M][N][M];
		map = new int[N][M];
		memo = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = Integer.MIN_VALUE;
		bfs();
		System.out.println(res);
		
	}

}
