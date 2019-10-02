package a1002;

import java.util.*;
import java.io.*;

public class Main_백준_1992_쿼드트리_서울9반_조경은 {
	public static int[][] arr;
	public static String check(int i, int j) {
		int num = arr[i][j];
		String s="";
		if(arr[i][j+1] == num && arr[i+1][j]==num && arr[i+1][j+1]==num) {
			s = Integer.toString(num);
			return s;
		}
		return "(" + Integer.toString(arr[i][j]) + Integer.toString(arr[i][j+1]) + Integer.toString(arr[i+1][j]) + Integer.toString(arr[i+1][j+1]) + ")";
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			char[] st = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				arr[i][j] = st[j]-'0';
			}
		}
		String[] res = new String[(N/2)*(N/2)];
		int index=0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				res[index] = check(2*i, 2*j);
				index++;
			}
		}
		
		
		System.out.println(res);
	}

}
