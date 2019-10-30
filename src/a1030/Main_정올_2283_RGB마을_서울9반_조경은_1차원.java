package a1030;

import java.io.*;
import java.util.*;

public class Main_정올_2283_RGB마을_서울9반_조경은_1차원 {
	public static int N, a1, a2, a3, b1, b2, b3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0]);
			int g = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);
			
			a1 = Math.min(b2+r, b3+r);
			a2 = Math.min(b1+g, b3+g);
			a3 = Math.min(b1+b, b2+b);
			b1=a1;
			b2=a2;
			b3=a3;
		}
		System.out.println(Math.min(a1, Math.min(a2, a3)));
	}

}
