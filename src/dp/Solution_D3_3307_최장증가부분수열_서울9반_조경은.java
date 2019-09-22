package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열_서울9반_조경은 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] l = new int[N];
			for(int i=0; i<N; i++) {
				l[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[j]<arr[i] && l[i]<1+l[j]) {
						l[i] = 1 + l[j];
					}
				}
			}
			System.out.println("#" + t + " " + Arrays.stream(l).max().getAsInt());
		}

	}
}