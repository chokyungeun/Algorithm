package a1004;

import java.io.*;
import java.util.*;

public class Main_정올_1082_화염에서탈출_서울9반_조경은 {
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static int R, C, res, rr, cc;
	public static int[][] farr, arr;
	public static boolean[][] move_v, fire_v;
	public static ArrayList<Integer> list;
	public static Queue<int[]> fire, jw;

	public static void firespread(int i, int j) {
		fire_v[i][j] = true;
		
		while(!fire.isEmpty()) {
			int[] curr = fire.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<R && nj>=0 && nj<C && !fire_v[ni][nj]) {
					farr[ni][nj] = farr[i][j]+1;
					fire.offer(new int[] {ni,nj});
				}
			}
		}
	}
	
	public static void move(int i, int j) {
		move_v[i][j] = true;
		
		while(!jw.isEmpty()) {
			int[] curr = jw.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<R && nj>=0 && nj<C && !move_v[ni][nj] && farr[ni][nj]==0) {
					arr[ni][nj] = arr[i][j]+1;
					jw.offer(new int[] {ni,nj});
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		arr = new int[R][C];
		farr = new int[R][C];
		move_v = new boolean[R][C];
		fire = new LinkedList<>();
		String st;
		for (int i = 0; i < R; i++) {
			st = br.readLine();
			for(int j=0; j<C; j++) {
				char c = st.charAt(j);
				if(c == 'D') {
					rr = i;
					cc = j;
					continue;
				}
				else if(c == 'S') {
					jw.offer(new int[] {i,j});
					continue;
				}
				else if(c=='*') {
					fire.offer(new int[] {i,j});
					farr[i][j]=1;
					continue;
				}
			}
		}
		int r = 0;
		int c = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				
			}
		}
		res = 0;
		list = new ArrayList<>();
		fire_v = new boolean[R][C];
		
		
		Collections.sort(list);
		if (list.size() == 0) {
			System.out.println("impossible");
		} else {

			System.out.println(list.get(0));
		}

	}

}
