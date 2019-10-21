package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15686_치킨배달_서울9반_조경은 {
	public static int N, M,result;
	public static boolean[] v;
	public static ArrayList<int[]> home,chicken;
	public static int[][] a;
	
	public static void permComb(int start, int count) {
		if(count == M) {
			distance(a);
			return;
		}
		for(int i=start; i<chicken.size(); i++) { 
			if(!v[i]) { 
				v[i] = true; 
				a[count] = chicken.get(i);
				permComb(i,count+1);
				v[i] = false; 
			} 
		}
	}
	
	public static void distance(int[][] a) {
		
		int res=0;
		for(int i=0; i<home.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<a.length; j++) {
				int temp = Math.abs(home.get(i)[0]-a[j][0]) + Math.abs(home.get(i)[1]-a[j][1]);
				min = Math.min(min, temp);
			}
			res += min;
		}
		result = Math.min(result, res);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					home.add(new int[] {i,j});
				}
				else if(num==2) {
					chicken.add(new int[] {i,j});
				}
			
			}
		}
		v = new boolean[chicken.size()];
		a = new int[M][2];
		result = Integer.MAX_VALUE;
		permComb(0,0);
		System.out.println(result);
		
	}

}
