package algoad;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑Dfs_조경은 {
	public static int[] di = {-1, 1, 0, 0};
	public static int[] dj = {0,0,-1, 1};
	public static int N;
	public static boolean[][] v;
	
	public static void dfs(int i, int j) {
		v[i][j] = true;
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<N && nj>=0 && nj<N && v[ni][nj] == false) {
				dfs(ni, nj);
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
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
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
							dfs(row, col);
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
