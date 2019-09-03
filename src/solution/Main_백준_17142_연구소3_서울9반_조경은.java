package solution;

import java.io.*;
import java.util.*;

public class Main_백준_17142_연구소3_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17142.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				String[] st = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st[j]);
				}
				
			}
			
		}
	}

}
