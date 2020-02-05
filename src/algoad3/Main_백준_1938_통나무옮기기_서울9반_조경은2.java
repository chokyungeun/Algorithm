package algoad3;

import java.io.*;
import java.util.*;

public class Main_백준_1938_통나무옮기기_서울9반_조경은2 {
	public static int N,res;
	public static char[][] map;
	public static int[][][] v;
	public static ArrayList<int[]> tree, here, list;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	
	public static boolean move(int dir) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0]+di[dir]<0 || list.get(i)[0]+di[dir]>=N || list.get(i)[1] + dj[dir] <0 || list.get(i)[1] + dj[dir] >=N || map[list.get(i)[0]+di[dir]][list.get(i)[1] + dj[dir]] == 1) {
				return false;
			}
		}
		for(int i=0; i<list.size(); i++) {
			list.get(i)[0] += di[dir];
			list.get(i)[1] += dj[dir];
		}
		res++;
		return true;
	}
	
	public static boolean rotate() {
		if(list.get(0)[0] == list.get(1)[0]) { //가로
			for(int i=list.get(1)[0]-1; i<list.get(1)[0]+2; i++) {
				for(int j=list.get(1)[1]-1; j<list.get(1)[1]+2; j++) {
					if(i<0 || i>=N || j<0 || j>=N || map[i][j]==1) {
						return false;
					}
				}
			}
			list.get(0)[0] = list.get(1)[0]-1;
			list.get(0)[1] = list.get(1)[1];
			list.get(2)[0] = list.get(1)[0]+1;
			list.get(2)[1] = list.get(1)[1];
			res++;
			return true;
		}
		else {
			for(int i=list.get(1)[0]-1; i<list.get(1)[0]+2; i++) {
				for(int j=list.get(1)[1]-1; j<list.get(1)[1]+2; j++) {
					if(i<0 || i>=N || j<0 || j>=N || map[i][j]==1) {
						return false;
					}
				}
			}
			list.get(0)[0] = list.get(1)[0];
			list.get(0)[1] = list.get(1)[1]-1;
			list.get(2)[0] = list.get(1)[0];
			list.get(2)[1] = list.get(1)[0]+1;
			res++;
			return true;
		}
	}
	
	public static void bfs() {
		Queue<ArrayList<int[]>> q = new LinkedList<>();
		tree.add(new int[] {0});
		q.offer(tree);
		
		while(!q.isEmpty()) {
			list = new ArrayList<>();
			ArrayList<int[]> temp = new ArrayList<>();
			temp = q.poll();
			int index=0;
			for(int i=0; i<3; i++) {
				if(temp.get(i)[0]==here.get(i)[0] && temp.get(i)[1] == here.get(i)[1]) {
					index++;
				}
			}
			if(index==3) {
				res = list.get(4)[0];
				return;
			}
			for(int i=0;i<4; i++) {
				list = temp;
				if(move(i)) {
					list.get(4)[0]++;
					q.offer(list);
				}
			}
			list = temp;
			if(rotate()) {
				list.get(3)[0] *= -1;
				list.get(4)[0]++;
				q.offer(list);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		
		
		
		map = new char[N][N];
		tree = new ArrayList<>();
		here = new ArrayList<>();
		v = new int[N*N][][];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'B') {
					tree.add(new int[] {i,j});
				}
				else if(map[i][j] == 'E') {
					here.add(new int[] {i,j});
				}
			}
		}
		if(tree.get(1)[0] == tree.get(0)[0]) tree.add(new int[] {-1});
		else tree.add(new int[] {1});
		bfs();
			
		System.out.println(res);
	}

}
