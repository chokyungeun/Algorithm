package a1011;

import java.io.*;

public class Main_백준_1157_단어공부_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();
		char[] c = s.toCharArray();
		int[] alpha = new int[26];

		for (int i = 0; i < c.length; i++)
			alpha[c[i] - 65]++;

		int max = alpha[0];
		int index = 0;
		int num = 0;
		for (int i = 1; i < alpha.length; i++) {
			if (max < alpha[i]) {
				max = alpha[i];
				index = i;
				num = 0;
			} else if (max == alpha[i])
				num++;
		}
		if (num > 0)
			System.out.println("?");
		else
			System.out.println((char) (index + 65));
	}
}
