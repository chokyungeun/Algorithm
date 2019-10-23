package a1023;

import java.io.*;

public class Main_정올_1658_최대공약수와최소공배수_서울9반_조경은 {

	public static int GCD(int a, int b) {
		int g=1;
		for(int i=2;i<=a; i++) {
			if(a%i==0 && b%i==0)
				g = i;
		}
		return g;
	}
	public static int LCM(int a, int b) {
		return (a*b)/GCD(a,b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		
		System.out.println(GCD(a,b));
		System.out.println(LCM(a,b));

	}

}
