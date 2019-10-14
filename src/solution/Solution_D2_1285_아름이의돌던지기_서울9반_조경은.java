package solution;

import java.io.*;
import java.util.*;

public class Solution_D2_1285_아름이의돌던지기_서울9반_조경은 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int min = Math.abs(arr[0]);
			int res = 1;
			
			for(int i=1; i<N; i++) {
				if(Math.abs(arr[i])<min) {
					min = Math.abs(arr[i]);
					res = 1;
				}
				else if(Math.abs(arr[i])==min) {
					res++;
				}
			}
			System.out.println("#" + t + " " + min + " " + res);
		}

	}

}
