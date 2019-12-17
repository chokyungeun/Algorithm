package solution;
import java.io.*;
import java.util.*;

public class Main_백준_15684_사다리조작_서울9반_조경은 {
	public static int N,M,H,res;
	public static boolean[] v;
	public static int[][] l, ltemp;
	public static int[] d;
	
	public static boolean check() {
		for(int i=0; i<N; i++) {
			int ni = 0;
			int nj = i;
			while(true) {
				if(ni==H) {
					if(nj==i) {
						break;
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
		
		return true;
	}
	
	public static boolean permComb(int start, int count, int num) {
		if(count==num) {
			if(check()) {
				res = num;
				return true;
			}
			return false;
		}
		for(int i=start; i<N*H; i++) {
			if(!v[i] && ltemp[i/N][i%N]!=1 && ltemp[i/N][i%N]!=-1 && i%N!=N-1 && ltemp[i/N][i%N+1]!=1) {
				v[i] = true; 
				d[count] = i;
				ltemp[i/N][i%N]=1;
				ltemp[i/N][i%N+1]=-1;
				if(permComb(i,count+1,num)) return true;
				ltemp[i/N][i%N]=0;
				ltemp[i/N][i%N+1]=0;
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
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			l[start][end]=1;
			l[start][end+1]=-1;
		}
		boolean flag = false;
		for(int i=0; i<=3; i++) {
			d = new int[i];
			ltemp = new int[H][N];
			for(int j=0; j<H; j++) {
				ltemp[j] = l[j].clone();
			}
			if(permComb(0,0,i)) {
				flag = true;
				break;
			}
			
		}
		if(flag) System.out.println(res);
		else System.out.println(-1);
	}

}
