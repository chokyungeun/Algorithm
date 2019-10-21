package solution;

import java.io.*;
import java.util.*;

public class Main_백준_3190_뱀_서울9반_조경은 {
	public static int N,K,time;
	public static ArrayList<String[]> d;
	public static ArrayList<int[]> list;
	public static int[][] map;
	public static int[] di = {-1,0,1,0}; //상우하좌
	public static int[] dj = {0,1,0,-1};
	
	public static void move(int i, int j, int dir) {
		time++;
		
		if(d.size()!=0 && time == Integer.parseInt(d.get(0)[0])) {
			if(d.get(0)[1].equals("D")) {
				dir = (dir+1)%4;
			}
			else {
				if(dir==0) {
					dir = 3;
				}
				else {
					dir--;
				}
			}
			d.remove(0);
		}
		
		int ni = i+di[dir];
		int nj = j+dj[dir];
		if(ni>=0 && ni<N && nj>=0 && nj<N && map[ni][nj]!=1) {
			if(map[ni][nj]==-1) {
				map[ni][nj]=1;
				list.add(new int[] {ni,nj});
			}
			else {
				map[list.get(0)[0]][list.get(0)[1]]=0;
				list.remove(0);
				map[ni][nj]=1;
				list.add(new int[] {ni,nj});
			}
			move(ni,nj,dir);
			
		}
		else {
			return;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		K = Integer.parseInt(br.readLine());
		d = new ArrayList<>();
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=-1;
		}
		int L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			d.add(new String[] {st.nextToken(), st.nextToken()});
		}
		
		list = new ArrayList<>();
		map[0][0] = 1;
		list.add(new int[] {0,0});
		time=-1;
		move(0,0,1);
		System.out.println(time+1);
		
	}

}
