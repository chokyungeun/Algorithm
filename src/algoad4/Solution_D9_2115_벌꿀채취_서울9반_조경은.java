package algoad4;

import java.io.*;
import java.util.*;

public class Solution_D9_2115_벌꿀채취_서울9반_조경은 {
	public static int max, N, M, C, max2;
	public static int[][] honey;
	public static int[] d,d2;
	public static boolean[] v,v2;
	
	public static void go(int start, int count, int num, ArrayList<int[]> list) {
		if(count==num) {
			int sum = 0;
			int temp=0;
			for(int i=0; i<num; i++) {
				int[] curr = list.get(d2[i]);
				sum += honey[curr[0]][curr[1]];
				temp += honey[curr[0]][curr[1]]*honey[curr[0]][curr[1]];
			}
			if(sum<=C) {
				max2 = Math.max(max2, temp);
			}
			return;
		}
		for(int i=start; i<list.size(); i++) {
			if(!v2[i]) {
				v2[i] = true;
				d2[count] = i;
				go(i,count+1, num, list);
				v2[i] = false;
			}
		}
	}
	
	public static void permComb2(ArrayList<int[]> list){
		for(int i=1; i<=M; i++){
			d2 = new int[i];
			v2 = new boolean[list.size()];
			go(0,0,i, list);
		}
	}
	
	//수익의 합을 계산해주는 함수
	public static int Profit() {
		int sum=0;
		int i1 = d[0]/N;
		int j1 = d[0]%N;
		int i2 = d[1]/N;
		int j2 = d[1]%N;
		
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			list.add(new int[] {i1, j1+i});
		}
		max2 = 0;
		permComb2(list);
		sum += max2;
		
		list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			list.add(new int[] {i2, j2+i});
		}
		max2 = 0;
		permComb2(list);
		sum += max2;
		return sum;
	}
	
	public static void permComb(int start, int count) {
		if(count==2) {
			max = Math.max(max, Profit());
			
			return;
		}
		for(int i=start; i<N*N; i++) {
			if(!v[i] && i%N<=N-M) {
				v[i] = true;
				d[count] = i;
				for(int j=1; j<M; j++) {
					v[i+j] = true;
				}
				permComb(i, count+1);
				v[i] = false;
				for(int j=1; j<M; j++) {
					v[i+j] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			honey = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			v = new boolean[N*N];
			d = new int[2];
			max = 0;
			permComb(0,0);
			
			System.out.println("#" + t + " " + max);
			
		}
		
	}

}
