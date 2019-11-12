package solution;
import java.io.*;
import java.util.*;

public class Main_백준_15684_사다리조작_서울9반_조경은 {
	public static int N,M,H,res;
	public static ArrayList<int[]> list;
	public static boolean[][] v, temp;
	public static int[] di = {1,0,0};
	public static int[] dj = {0,-1,1};
	
	public static void dfs(int i, int j) {
		temp[i][j] = true;
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<H && nj>=0 && nj<N && !temp[ni][nj]) {
				dfs(ni,nj);
			}
		}
	}
	public static boolean check() {
		for(int i=0; i<N; i++) {
			temp = new boolean[H][N];
			dfs(0,i);
		}
		
		return false;
	}
	
	public static void ladder() {
		int index=0;
		while(true) {
			if(check()) {
				break;
			}
			
			
		}
		
	}
	
	public static void permComb(int start, int count) {
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		v = new boolean[H][N];
		list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			v[start][end]=true;
			v[start][end+1]=true;
		}
		
		ladder();
		
		System.out.println(res);
	}

}
