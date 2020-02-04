package algoad3;

import java.io.*;
import java.util.*;

public class Main_백준_1938_통나무옮기기_서울9반_조경은_dfs {
	public static int N,res;
	public static char[][] map;
	public static ArrayList<int[]> tree, here;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	
	public static boolean move(int dir) {
		for(int i=0; i<tree.size(); i++) {
			if(tree.get(i)[0]+di[dir]<0 || tree.get(i)[0]+di[dir]>=N || tree.get(i)[1] + dj[dir] <0 || tree.get(i)[1] + dj[dir] >=N || map[tree.get(i)[0]+di[dir]][tree.get(i)[1] + dj[dir]] == 1) {
				return false;
			}
		}
		for(int i=0; i<tree.size(); i++) {
			tree.get(i)[0] += di[dir];
			tree.get(i)[1] += dj[dir];
		}
		res++;
		return true;
	}
	
	public static boolean rotate() {
		if(tree.get(0)[0] == tree.get(1)[0]) { //가로
			for(int i=tree.get(1)[0]-1; i<tree.get(1)[0]+2; i++) {
				for(int j=tree.get(1)[1]-1; j<tree.get(1)[1]+2; j++) {
					if(i<0 || i>=N || j<0 || j>=N || map[i][j]==1) {
						return false;
					}
				}
			}
			tree.get(0)[0] = tree.get(1)[0]-1;
			tree.get(0)[1] = tree.get(1)[1];
			tree.get(2)[0] = tree.get(1)[0]+1;
			tree.get(2)[1] = tree.get(1)[1];
			res++;
			return true;
		}
		else {
			for(int i=tree.get(1)[0]-1; i<tree.get(1)[0]+2; i++) {
				for(int j=tree.get(1)[1]-1; j<tree.get(1)[1]+2; j++) {
					if(i<0 || i>=N || j<0 || j>=N || map[i][j]==1) {
						return false;
					}
				}
			}
			tree.get(0)[0] = tree.get(1)[0];
			tree.get(0)[1] = tree.get(1)[1]-1;
			tree.get(2)[0] = tree.get(1)[0];
			tree.get(2)[1] = tree.get(1)[0]+1;
			res++;
			return true;
		}
	}
	
	public static void dfs(int[][] v, int i, int j) {
		if(tree.get(0)[0] == here.get(0)[0] && tree.get(0)[1] == here.get(0)[1] && tree.get(1)[0] == here.get(1)[0] && tree.get(1)[1] == here.get(1)[1] && tree.get(2)[0] == here.get(2)[0] && tree.get(2)[1] == here.get(2)[1]) {
			return;
		}
		if(v[i][j] == 0) {
			if(tree.get(0)[0] == tree.get(1)[0]) 
				v[tree.get(1)[0]][tree.get(1)[1]] = -1;
			else
				v[tree.get(1)[0]][tree.get(1)[1]] = 1;
		}
		else if(v[i][j] == -1) {
			if(tree.get(0)[0] == tree.get(1)[0]) return;
			else v[i][j] = 3;
		}
		else if(v[i][j] == 1){
			if(tree.get(0)[0] == tree.get(1)[0]) {
				v[i][j] = 3;
			}
			else return;
		}
		if(move(0)) {
			dfs(v,tree.get(1)[0], tree.get(1)[1]);
		}
		
		if(move(1)) dfs(v,tree.get(1)[0], tree.get(1)[1]);
		if(move(2)) dfs(v,tree.get(1)[0], tree.get(1)[1]);
		if(move(3)) dfs(v,tree.get(1)[0], tree.get(1)[1]);
		if(rotate()) dfs(v,tree.get(1)[0], tree.get(1)[1]);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		tree = new ArrayList<>();
		here = new ArrayList<>();
		int[][] v = new int[N][N];
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
		
			
		dfs(v, tree.get(1)[0], tree.get(1)[1]);
		System.out.println(res);
	}

}
