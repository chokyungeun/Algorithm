package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15685_드래곤커브_서울9반_조경은 {
	public static int N;
	public static ArrayList<int[]> curve;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		curve = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				curve.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),});
				
			}
		}
	}

}
