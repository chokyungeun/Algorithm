package a0926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D4_4301_콩많이심기_서울9반_조경은 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4301.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			int res = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					
				}
			}
			
			
			System.out.println("#" + t + " " + res);
		}
	}
}
