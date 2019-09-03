package solution;

import java.io.*;
import java.util.*;

public class Main_백준_13460_구슬탈출2_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_13460.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			char[][] arr = new char[N][M];
			for(int i=0; i<N; i++) {
				String st = br.readLine();
				arr[i] = st.toCharArray();
			}
			
		}
	}

}
