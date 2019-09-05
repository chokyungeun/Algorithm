package a0905;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_3459_승자예측하기_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3459.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			boolean bob = true;
			long N = Long.parseLong(br.readLine())-1;
			int base = 2;
			while(N>0) {
				N-=Math.pow(4, (base++/2));
				bob=!bob;
			}
			System.out.println("#" + t + " " + (bob? "Bob":"Alice"));
		}
	}
}
