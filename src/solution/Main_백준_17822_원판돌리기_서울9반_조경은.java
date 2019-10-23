package solution;

import java.io.*;
import java.util.*;

public class Main_백준_17822_원판돌리기_서울9반_조경은 {
	public static int N,M,T;
	public static int[][] c;
	public static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		c = new int[N][M];
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				c[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		
		

	}

}
