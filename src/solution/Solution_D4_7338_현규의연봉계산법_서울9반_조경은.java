package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_7338_현규의연봉계산법_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7338.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			long y = Long.parseLong(s[0]);
			int m = Integer.parseInt(s[1]);
			
			long y2 = (y-2016);
			long ry = y-(y2/12);
			int rm = (int) (m-(y%12));
			if(rm <= 0) {
				rm += 13;
			}
			System.out.println("#" + t + " " + ry + " " + rm);
			
		}

	}

}
