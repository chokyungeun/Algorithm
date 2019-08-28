package algoad;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D3_2805_농작물수확하기_Bfs_조경은2 {
	public static int N;
	public static int[][] arr;
	public static int c;
	public static boolean[][] v;
	public static int sum;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void bfs(int i, int j) {
		v[i][j] = true;
		sum += arr[i][j];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] index = q.poll();
			for(int k=0; k<di.length; k++) {
				int ni = index[0]+di[k];
				int nj = index[1]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<N && v[ni][nj] == false && Math.abs(c-ni)+Math.abs(c-nj)<=c) {
					v[ni][nj] = true;
					sum += arr[ni][nj];
					q.offer(new int[] {ni,nj});
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			sum = 0;
			v = new boolean[N][N];
			arr = new int[N][N];
			c = N/2;
			for(int i=0; i<N; i++) {
				char[] c = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					arr[i][j] = c[j]-'0';
				}
			}
			bfs(c,c);
			System.out.println("#" + t + " " + sum);
		}

	}

}
