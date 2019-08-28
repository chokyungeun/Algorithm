package imtest_0827;

import java.io.*;
import java.util.*;

public class Solution_AD_0001_서울9반_조경은 {
	public static int res;
	
	public static void shuffle(int[] arr) {
		int[] arr2 = new int[arr.length];
		arr2 = Arrays.copyOf(arr, arr.length);
		Arrays.sort(arr2);
		int num=0;
		for(int i=0; i<arr.length; i++) {
			if(arr2[i] != arr[i]) {
				num++;
			}
		}
		if(num==0) {
			return;
		}
		num=0;
		for(int i=0; i<arr.length; i++) {
			if(arr2[arr2.length-i-1] != arr[i]) {
				num++;
			}
		}
		if(num==0) {
			return;
		}
		
		res++;
		//res 사용해서 셔플
		int[] narr = new int[arr.length];
		
		
		
		
		shuffle(narr);
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_ad_0001_test.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			res=0;
			shuffle(arr);
			
			System.out.println("#" + t + " " + res);
			
			
		}
		
	}
}
