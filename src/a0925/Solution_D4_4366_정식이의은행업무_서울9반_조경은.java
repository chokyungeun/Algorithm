package a0925;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D4_4366_정식이의은행업무_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4366.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String two = br.readLine();
			String thr = br.readLine();
			ArrayList<Long> i2 = new ArrayList<>();
			ArrayList<Long> i3 = new ArrayList<>();
			char[] c2 = two.toCharArray();
			char[] c3 = thr.toCharArray();

			i2.add(Long.valueOf(two, 2));
			i3.add(Long.valueOf(thr, 3));

			for (int i = 0; i < c2.length; i++) {
				char[] c = new char[c2.length];
				c = c2.clone();
				if (c2[i] == '1')
					c[i] = '0';
				else
					c[i] = '1';
				i2.add(Long.valueOf(String.valueOf(c), 2));
			}
			for (int i = 0; i < c3.length; i++) {
				char[] c = new char[c3.length];
				c = c3.clone();
				if (c3[i] == '1') {
					c[i] = '0';
					i3.add(Long.valueOf(String.valueOf(c), 3));
					c[i] = '2';
					i3.add(Long.valueOf(String.valueOf(c), 3));
				}
				else if (c3[i] == '0') {
					c[i] = '1';
					i3.add(Long.valueOf(String.valueOf(c), 3));
					c[i] = '2';
					i3.add(Long.valueOf(String.valueOf(c), 3));
				}
				else if (c3[i] == '2') {
					c[i] = '1';
					i3.add(Long.valueOf(String.valueOf(c), 3));
					c[i] = '0';
					i3.add(Long.valueOf(String.valueOf(c), 3));
				}
			}

			long res = 0;
			Loop: for (int i = 0; i < i2.size(); i++) {
				for (int j = 0; j < i3.size(); j++) {
					if (i2.get(i).equals(i3.get(j))) {
						res = i2.get(i);
						break Loop;
					}
				}
			}

			System.out.println("#" + t + " " + res);
		}

	}

}
