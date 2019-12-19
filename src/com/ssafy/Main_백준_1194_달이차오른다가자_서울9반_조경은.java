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
	
	public static int bfs() {
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(map[curr[0]][curr[1]]=='1') return curr[3];
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				int nk = curr[2];
				if(ni>=0 && ni<N && nj>=0 && nj<M &&  map[ni][nj]!='#') {
					if(map[ni][nj]>='a' && map[ni][nj]<='f') {
						nk |= (1<<(map[ni][nj]-'a'));
					}
					else if(map[ni][nj]>='A' && map[ni][nj]<='F') {
						if((nk&(1<<(map[ni][nj]-'A')))==0) continue;
					}
					if(!v[nk][ni][nj]) {
						v[nk][ni][nj] = true;
						q.offer(new int[] {ni,nj,nk,curr[3]+1});
					}
				}
			}
		}
		return -1;
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
		
		System.out.println(bfs());
		
		
	}

}
