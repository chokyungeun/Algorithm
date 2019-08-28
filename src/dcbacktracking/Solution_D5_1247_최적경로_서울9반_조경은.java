package dcbacktracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_D5_1247_최적경로_서울9반_조경은 {
	public static int min;
	public static boolean[] v;
	public static int[] company;
	public static int[] home;
	public static int[][] d;
	public static int N;
	public static int[] x;
	public static int[] y;
	public static int sum;
	public static void dfs(int count, int i, int j, int distance) {
		if(min<=distance) return;
		if(count==N) {
			distance=distance+Math.abs(i-home[0])+Math.abs(j-home[1]);
			min=Math.min(min, distance);
			return;
		}
		for(int k=0; k<N; k++) {
			if(!v[k]) {
				v[k]=true;
				dfs(count+1, d[k][0], d[k][1], distance+Math.abs(i-d[k][0])+Math.abs(j-d[k][1]));
				v[k] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d5_1247.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<T+1; t++){
			N = sc.nextInt();
			company = new int[] {sc.nextInt(), sc.nextInt()};
			home = new int[] {sc.nextInt(), sc.nextInt()};
			d = new int[N][2];
			x = new int[N];
			y = new int[N];
			for(int i=0; i<N; i++) {
				d[i] = new int[] {sc.nextInt(), sc.nextInt()};
			}
			min = Integer.MAX_VALUE;
			v=new boolean[N];
			dfs(0,company[0],company[1],0);
			System.out.println("#" + t + " " + min);
			
		}
		

	}

}
