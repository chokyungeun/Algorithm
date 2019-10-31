package a1031;

import java.io.*;
import java.util.*;

public class Main_정올_1545_해밀턴순환회로2_서울9반_조경은 {
	public static int INF=987654321;
	public static int N;
	public static int[][] arr;
	public static int[][] d;
	public static int[][] m;
	
	public static int solve(int pos, int visited, int start) {
		if(m[pos][visited]!=0) return m[pos][visited];
		if(visited==(1<<N)-1) return m[pos][visited]=d[pos][start];
		int ret=INF;
		for(int next=0; next<N; next++) {
			if((visited&(1<<next))==0 && d[pos][next]!=0){
				int tmp=d[pos][next]+solve(next,visited|(1<<next),start);
				ret=Math.min(ret,tmp);
			}
		}
		m[pos][visited]=ret;
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		d = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i!=j & arr[i][j]==0) arr[i][j]=INF;
			}
		}
		
		int ans=INF;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				d[j]=arr[j].clone();
			}
		}
		m=new int[N][1<<N];
		int tmp=solve(0,1<<0,0);
		ans=Math.min(ans,tmp);
		
		System.out.println(ans);
		
	}

}
