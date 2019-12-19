package solution;
import java.io.*;
import java.util.*;

public class Main_백준_15684_사다리조작_서울9반_조경은 {
	public static int N,M,H,res;
	public static boolean[] v;
	public static int[][] l, t;

	public static boolean ladder() {
		for(int j=0; j<N; j++) {
			for(int k=0; k<H; k++) {
				t[k] = l[k].clone();
			}
			int ni = 0;
			int nj = j;
			while(true) {
				if(ni==H) {
					if(nj==j) break;
					else return false;
				}
				if(t[ni][nj]==-1) {
					t[ni][nj]=0;
					t[ni][nj+1]=0;
					nj++;
				}
				
				else if(t[ni][nj]==1) {
					t[ni][nj]=0;
					t[ni][nj-1]=0;
					nj--;
				}
				else ni++;
			}
		}
		return true;
	}
	
	public static boolean permComb(int start, int count, int num) {
		if(count==num) {
			if(ladder()) {
				return true;
			}
			else {
				return false;
			}
		}
		for(int i=start+1; i<N*H; i++) {
			if(!v[i] && l[i/N][i%N]==0 && i%N!=N-1 &&l[i/N][i%N+1]!=-1) {
				v[i] = true;
				l[i/N][i%N]=-1;
				l[i/N][i%N+1]=1;
				if(permComb(i, count+1, num)) {
					return true;
				}
				l[i/N][i%N]=0;
				l[i/N][i%N+1]=0;
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
		l = new int[H][N];
		t = new int[H][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			l[start][end]=-1;
			l[start][end+1]=1;
		}
		boolean flag = false;
		if(ladder()) {
			System.out.println(0);
		}
		else {
			for(int i=1; i<=3; i++) {
				v = new boolean[H*N];
				if(permComb(0,0,i)) {
					res = i;
					flag = true;
					break;
				}
			}
			if(flag) System.out.println(res);
			else System.out.println(-1);
		}
		
	}

}
