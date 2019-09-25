package a0925;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D4_4672_수진이의팰린드롬_서울9반_조경은2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4672.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			char[] arr = br.readLine().toCharArray();
			
			Arrays.sort(arr);
			
			int res = 0;
			
			int idx = 1;
			for(int i=0; i<arr.length-1; i++) {
				res += idx;
				if(arr[i] == arr[i+1]) {
					if(i+1 == arr.length-1)
						res += idx+1;
					idx++;
				}
				else {
					if(i+1 == arr.length-1)
						res++;
					idx=1;
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
}
