package solution;
import java.io.*;
import java.util.*;

public class Solution_D9_2115_벌꿀채취_서울9반_조경은 {
	public static int N,M,C;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
		}
		
	}
}