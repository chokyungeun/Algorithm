package a0925;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_D4_4672_수진이의팰린드롬_서울9반_조경은 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4672.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			int[] num = new int[26];
			String s = br.readLine();
			
			for(int i=0; i<s.length(); i++) {
				num[s.charAt(i)-'a']++;
			}
			int sum = s.length();
			for(int i=0; i<26; i++) {
				if(num[i]>0) {
					for(int j=0; j<num[i]; j++) {
						sum+=j;
					}
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
