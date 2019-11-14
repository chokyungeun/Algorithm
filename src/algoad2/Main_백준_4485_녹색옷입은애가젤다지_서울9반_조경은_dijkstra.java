package algoad2;
import java.io.*;
import java.util.*;

public class Main_백준_4485_녹색옷입은애가젤다지_서울9반_조경은_dijkstra {
	public static int N;
	public static int[][] map,memo;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static boolean[][] v;
	
	public static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		for(int i=0; i<N; i++) {
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		memo[0][0] = map[0][0];
		pq.offer(new int[] {0,0,memo[0][0]});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<N && memo[ni][nj]>curr[2]+map[ni][nj]) {
					memo[ni][nj]=curr[2]+map[ni][nj];
					if(ni==N-1 && nj==N-1) {
						return;
					}
					pq.offer(new int[] {ni,nj,memo[ni][nj]});
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
			dijk();
			System.out.println("Problem " + index + ": " + memo[N-1][N-1]);
			index++;
		}
		
		
	}

}
