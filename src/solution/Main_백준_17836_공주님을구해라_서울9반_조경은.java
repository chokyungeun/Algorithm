package solution;
import java.io.*;
import java.util.*;

public class Main_백준_17836_공주님을구해라_서울9반_조경은 {
	public static int N,M,T,res;
	public static int[][] arr, memo;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static boolean[][] v;

	public static void dfs(int i, int j, int temp) {
		//System.out.println(i + " " + j + " " + temp);
		if(memo[i][j]>=temp) {
			memo[i][j]=temp;
		}
		else {
			return;
		}
		if(temp>=T || temp>res) {
			return;
		}
		if(arr[i][j]==2) {
			res = Math.min(res, temp+Math.abs(i-(N-1))+Math.abs(j-(M-1)));
			return;
		}
		if(i==N-1 && j==M-1) {
			res = Math.min(res, temp);
			return;
		}
		v[i][j]=true;
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<N && nj>=0 && nj<M && !v[ni][nj] && arr[ni][nj]!=1) {
				dfs(ni,nj,temp+1);
			}
		}
		
		v[i][j]=false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		memo = new int[N][M];
		v = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			Arrays.fill(memo[i], 999);
		}
		res=Integer.MAX_VALUE;
		dfs(0,0,0);
		if(res>=T) {
			System.out.println("Fail");
		}
		else
			System.out.println(res);
	}

}
