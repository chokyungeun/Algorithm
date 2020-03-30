package algoad4;

import java.io.*;
import java.util.*;

public class Solution_D4_9282_초콜릿과건포도_서울9반_조경은 {
	public static int n,m;
	public static int[][] choco;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_9282.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			choco = new int[n][m];
			
		}

	}

}
