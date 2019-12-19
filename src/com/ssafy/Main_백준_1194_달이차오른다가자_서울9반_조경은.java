package com.ssafy;
import java.io.*;
import java.util.*;

public class Main_백준_1194_달이차오른다가자_서울9반_조경은 {
	public static int N,M,res;
	public static char[][] map;
	public static boolean[][][] v;
	public static Queue<int[]> q;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			//System.out.println(curr[0] + " " + curr[1]);
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<M &&  map[ni][nj]!='#') {
					if(map[ni][nj]=='1') {
						res = curr[3]+1;
						return;
					}
					else if(map[ni][nj]>='a' && map[ni][nj]<='f') {
						int[] temp = new int[curr.length+1];
						curr[2] |= (1<<(map[ni][nj]-'a'));
						
						temp[0] = ni;
						temp[1] = nj;
						temp[3]++;
						
						v[temp[2]][ni][nj] = true;
						q.offer(temp);
					}
					else if(map[ni][nj]>='A' && map[ni][nj]<='F') {
						if((curr[2]&(1<<(map[ni][nj]-'A')))==0) continue;
						
					}
					else {
						v[curr[2]][ni][nj]=true;
						int[] temp = curr;
						temp[0] = ni;
						temp[1] = nj;
						temp[3]++;
						q.offer(temp);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[1<<6][N][M];
		q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]=='0') {
					q.offer(new int[] {i,j,0,0});
					v[0][i][j] = true;
				}
			}
		}
		
		bfs();
		if(res==0) System.out.println(-1);
		else System.out.println(res);
		
	}

}
