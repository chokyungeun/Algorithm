package algoad;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기_Dfs_조경은2 {
	public static int N;
	public static int[][] arr;
	public static boolean[][] v;
	public static int c;
	public static int res;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void dfs(int i, int j) {
		
		v[i][j] = true;
		res += arr[i][j];
		
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<N && nj>=0 && nj<N && v[ni][nj] == false && Math.abs(c-ni)+Math.abs(c-nj) <= c) {
				dfs(ni, nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			v = new boolean[N][N];
			for(int i=0; i<N; i++) {
				char[] c = new char[N];
				c = br.readLine().toCharArray();
				for(int j=0; j<N;j++) {
					arr[i][j]= c[j]-'0';
				}
			}
			res = 0;
			c = N/2;
			dfs(c, c);
			System.out.println("#" + t + " " + res);
		}

	}

}
