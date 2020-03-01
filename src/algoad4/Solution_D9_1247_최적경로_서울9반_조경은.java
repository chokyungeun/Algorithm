package algoad4;

import java.io.*;
import java.util.*;

public class Solution_D9_1247_최적경로_서울9반_조경은 {
	public static int N, min;
	public static int[] home, comp, d;
	public static int[][] cli;
	public static boolean[] v;
	
	//순서 정하는 함수
	public static void permComb(int start, int count) {
		if(count == N) {
			min = Math.min(min, distance());
			return;
		}
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				d[count] = i;
				permComb(i, count+1);
				v[i] = false;
			}
		}
	}
	
	//거리 계산하는 함수
	public static int distance() {
		int sum = 0;
		sum += (Math.abs(home[0]-cli[d[0]][0])) + (Math.abs(home[1]-cli[d[0]][1]));
		
		for(int i=0; i<N-1; i++) {
			sum += (Math.abs(cli[d[i]][0] - cli[d[i+1]][0])) + (Math.abs(cli[d[i]][1] - cli[d[i+1]][1]));
		}
		
		sum += (Math.abs(comp[0]-cli[d[N-1]][0])) + (Math.abs(comp[1]-cli[d[N-1]][1]));
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			home = new int[2];
			comp = new int[2];
			cli = new int[N][2];
			st = new StringTokenizer(br.readLine());
			comp[0] = Integer.parseInt(st.nextToken());
			comp[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				cli[i][0] = Integer.parseInt(st.nextToken());
				cli[i][1] = Integer.parseInt(st.nextToken());
			}
			
			v = new boolean[N];
			d = new int[N];
			min = Integer.MAX_VALUE;
			permComb(0,0);
			System.out.println("#" + t + " " + min);
		}

	}

}
