package algoad;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_7733_치즈도둑Bfs_조경은 {
	public static int[] di = {-1, 1, 0, 0};
	public static int[] dj = {0,0,-1, 1};
	public static int N;
	public static boolean[][] v;
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
        v[i][j] = true;
        q.offer(new int[] {i,j});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int d = 0; d < di.length; d++) {
                int ni = curr[0]+di[d];
                int nj = curr[1]+dj[d];
                if(0<=ni && ni<N && 0<=nj && nj<N && v[ni][nj] == false) {
                    v[ni][nj] = true;
                    q.offer(new int[] {ni,nj});
                }
            }
        }
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			v = new boolean[N][N];
			int[] res = new int[100];
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			for(int i=1; i<=100; i++) {
				for(int row=0; row<N; row++) {
					for(int col=0; col<N; col++) {
						if(arr[row][col] <= i) {
							v[row][col] = true;
						}
					}
				}
				for(int row=0; row<N; row++) {
					for(int col=0; col<N; col++) {
						if(v[row][col] == false) {
							res[i-1]++;
							bfs(row, col);
						}
					}
				}
				v = new boolean[N][N];
			}
			int max = 1;
			for(int i=0; i<100; i++) {
				if(max<res[i])
					max = res[i];
			}
			
			System.out.println("#" + t + " " + max);
		}

	}

}
