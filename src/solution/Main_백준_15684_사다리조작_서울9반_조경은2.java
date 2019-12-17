package solution;
import java.io.*;
import java.util.*;

public class Main_백준_15684_사다리조작_서울9반_조경은2 {
	public static int N,M,H,res,num;
	public static ArrayList<int[]> list;
	public static boolean[] v;
	public static int[] di = {1,0,0};
	public static int[] dj = {0,-1,1};
	public static boolean flag;
	public static int[][] l,ltemp;
	public static int[] d;
	
	public static boolean dfs(int i, int j, int first) {
		int ni = i;
		int nj = j;
		while(true) {
			if(ni==H-1) {
				if(nj==first) {
					return true;
				}
				else {
					return false;
				}
			}
			if(ltemp[ni][nj]==1) {
				nj++;
			}
			else if(ltemp[ni][nj]==-1) {
				nj--;
			}
			else {
				ni++;
			}
		}
		
	}
	public static boolean check() {
		for(int i=0; i<N; i++) {
			if(!dfs(0,i,i)) {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean permComb(int start, int count, int num) {
		if(count == num) {
			ltemp = new int[H][N];
			for(int i=0; i<H; i++) {
				for(int j=0; j<N; j++) {
					ltemp[i][j] = l[i][j];
				}
			}
			for(int i=0; i<num; i++) {
				ltemp[d[i]/N][d[i]%N] = 1;
				ltemp[d[i]/N][d[i]%N+1] = -1;
			}
			if(check()) {
				res = num;
				return true;
			}
			return false;
		}
		for(int i=0; i<N*H; i++) { 
			if(!v[i] && i%N!=N-1 && l[i/N][i%N]!=-1&& l[i/N][i%N]!=1) { 
				v[i] = true; 
				d[count] = i;
				if(permComb(i,count+1,num)) return true;
				v[i] = false; 
			} 
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		v = new boolean[H*N];
		l = new int[H][N];
		list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			l[start][end]=1;
			l[start][end+1]=-1;
			v[start*N + end]=true;
		}
		boolean flag = false;
		for(int i=1; i<=3; i++) {
			d = new int[i];
			if(permComb(0,0,i)) {
				flag = true;
				break;
			}
			
		}
		if(flag) System.out.println(res);
		else System.out.println(-1);
	}

}
