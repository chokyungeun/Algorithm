package SWmaestro;

import java.io.*;
import java.util.*;

public class Solution3 {
	public static int N, K, res;
	public static int[] arr;
	public static int[][] subset;
	
	public static void calc() {
		int sum=0;
		
		for(int i=0; i<K; i++) {
			sum+= (subset[i][subset.length-1]-subset[i][0]);
		}
		res = Math.max(res, sum);
	}
	
	public static void divide() {
		
		
		calc();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		res=0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		subset = new int[K][];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		divide();
		System.out.println(res);
	}

}
