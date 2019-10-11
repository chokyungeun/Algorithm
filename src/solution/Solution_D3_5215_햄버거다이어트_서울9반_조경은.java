package solution;

import java.util.*;
import java.io.*;

public class Solution_D3_5215_햄버거다이어트_서울9반_조경은 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}
			
		}
	}
}
