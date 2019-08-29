package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] X = new int[N];
			int[] Y = new int[N];
			for(int i=0; i<N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			System.out.println(Arrays.toString(X));
			System.out.println(Arrays.toString(Y));
			System.out.println(E);
		}
	}

}
