package a1016;

import java.util.*;
import java.io.*;

public class Main_백준_14889_스타트와링크_서울9반_조경은 {
	public static int N, ares, bres, min, res;
	public static int[][] arr;
	public static int[] a,b;
	public static boolean[] v;
	
	public static void team(int start, int count) {
		if(count == (N/2)) {
			ares = 0;
			bres = 0;
			cal();
			return;
		}
		for(int i=start; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				a[count] = i;
				team(i, count+1);
				v[i]=false;
			}
			
		}
	}
	
	public static void cal() {
		int idx=0;
		for(int i=0; i<N; i++) {
			int num=0;
			for(int j=0; j<a.length; j++) {
				if(i==a[j]) {
					num++;
					break;
				}
			}
			if(num==0) {
				b[idx++] = i;
			}
		}
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				ares += arr[a[i]][a[j]];
			}
		}
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b.length; j++) {
				bres += arr[b[i]][b[j]];
			}
		}
		
		res = Math.min(res, Math.abs(ares-bres));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N];
		a = new int[N/2];
		b = new int[N/2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		res=Integer.MAX_VALUE;
		team(0,0);
		System.out.println(res);
		
	}

}
