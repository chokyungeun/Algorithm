package a1030;

import java.io.*;
import java.util.*;

public class Solution_D9_2105_디저트카페_서울9반_조경은 {
	public static int N,idx, ni, nj;
	public static int[][] map;
	public static ArrayList<Integer> list;
	public static int[] di = {-1,1,1,-1};
	public static int[] dj = {1,1,-1,-1};
	
	
	public static void dessert(int i, int j, int d1, int d2) {
		list = new ArrayList<>();
		int index=1;
		list.add(map[i][j]);
		for(int k=0; k<d1; k++) {
			ni = i+di[0];
			nj = j+dj[0];
			if(ni<0 || ni>=N || nj<0 || nj>=N || list.contains(map[ni][nj])) {
				return;
			}
			else {
				list.add(map[ni][nj]);
				index++;
				i = ni;
				j = nj;
			}
		}
		for(int k=0; k<d2; k++) {
			ni = i+di[1];
			nj = j+dj[1];
			if(ni<0 || ni>=N || nj<0 || nj>=N || list.contains(map[ni][nj])) {
				return;
			}
			else {
				list.add(map[ni][nj]);
				index++;
				i = ni;
				j = nj;
			}
		}
		
		for(int k=0; k<d1; k++) {
			ni = i+di[2];
			nj = j+dj[2];
			if(ni<0 || ni>=N || nj<0 || nj>=N|| list.contains(map[ni][nj])) {
				return;
			}
			else {
				list.add(map[ni][nj]);
				index++;
				i = ni;
				j = nj;
			}
		}
		
		for(int k=0; k<d2-1; k++) {
			ni = i+di[3];
			nj = j+dj[3];
			if(ni<0 || ni>=N || nj<0 || nj>=N || list.contains(map[ni][nj])) {
				return;
			}
			else {
				list.add(map[ni][nj]);
				index++;
				i = ni;
				j = nj;
			}
		}
		idx = Math.max(index, idx);
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			idx=-1;
			for(int d1=1; d1<N-1; d1++) {
				for(int d2=1; d2<N-1; d2++) {
					for(int i=d1; i<N; i++) {
						for(int j=0; j<N-d2; j++) {
							dessert(i,j,d1,d2);
						}
					}
				}
			}
			System.out.println("#" + t + " " + idx);
		}

	}

}
