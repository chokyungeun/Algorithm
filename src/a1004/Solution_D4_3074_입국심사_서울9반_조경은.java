package a1004;

import java.io.*;

public class Solution_D4_3074_입국심사_서울9반_조경은 {
	public static int[] arr;
	public static int N,M,max;
	public static long time;
	
	public static void binary_finding(long stime, long etime) {
		if(stime>etime)
			return;
		long middle = (stime + etime)/2;
		long check = 0;
		for(int i=0; i<N; i++) {
			check+=middle/arr[i];
		}
		if(check<M) {
			stime = middle+1;
		}
		else {
			time = middle;
			etime = middle-1;
		}
		if(stime<=etime)
			binary_finding(stime, etime);
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				if(arr[i]>max)
					max = arr[i];
			}
			
			long stime = 0;
			long etime = (long)max*M;
			binary_finding(stime, etime);
			
			
			System.out.println("#" + t + " " + time);
		}
	}
}
