package algoad4;

import java.io.*;
import java.util.*;

public class Solution_D4_1808_지희의고장난계산기_서울9반_조경은 {
	public static boolean[] number;
	public static int X, res;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			res = -1;
			number = new boolean[10];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<10; i++) {
				if(Integer.parseInt(st.nextToken())==1) {
					number[i] = true;
				}
			}
			X = Integer.parseInt(br.readLine());
			
			System.out.println("#" + t + " " + res);
		}

	}

}
