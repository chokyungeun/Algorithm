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
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(arr2));
			
			return;
		}
		num=0;
		for(int i=0; i<arr.length; i++) {
			if(arr2[arr2.length-i-1] != arr[i]) {
				num++;
			}
		}
		if(num==0) {
			System.out.println("arr : "+Arrays.toString(arr));
			System.out.println("arr2 : "+Arrays.toString(arr2));
			return;
		}
		
		res++;
		//res 사용해서 셔플
		int[] narr = new int[arr.length];
		int[] front = new int[arr.length/2];
		int[] back = new int[arr.length/2];
		for(int i=0; i<arr.length/2; i++) {
			front[i] = arr[i];
			back[i] = arr[i+arr.length/2];
		}
		System.out.println("front : "+Arrays.toString(front));
		System.out.println("back : "+Arrays.toString(back));
		int b=0;
		int f=0;
		int n=0;
		if(arr.length/2-res >=0) {
			for(int i=0; i<arr.length/2-res-1; i++) {
				narr[n++] = front[f++];
			}
			for(int i=0; i<res; i++) {
				narr[n++] = back[b++];
				narr[n++] = front[f++];
			}
			for(int i=0; i<arr.length/2-res-1; i++) {
				narr[n++] = back[b++];
			}
		}
		else {
			for(int i=0; i<res-arr.length/2+1; i++) {
				narr[n++] = back[b++];
			}
			for(int i=0; i<res-arr.length/2+1; i++) {
				narr[n++] = front[f++];
				narr[n++] = back[b++];
			}
			for(int i=0; i<res-arr.length/2+1; i++) {
				narr[n++] = front[f++];
			}
		}
		System.out.println("narr : "+Arrays.toString(narr));

		shuffle(narr);
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_ad_0001.txt"));
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
