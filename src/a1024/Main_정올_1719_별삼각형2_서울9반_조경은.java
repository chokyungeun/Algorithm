package a1024;

import java.io.*;

public class Main_정올_1719_별삼각형2_서울9반_조경은 {
	public static void star1(int n) {
		for (int i = 1; i <= (n + 1) / 2; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = n / 2; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void star2(int n) {
		for (int i = 1; i <= (n + 1) / 2; i++) {
			for (int j = 1; j <= (n + 1) / 2 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = n / 2; i >= 1; i--) {
			for (int j = 1; j <= (n + 1) / 2 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void star3(int n) {
		for (int i = 1; i <= (n + 1) / 2; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= n - (2 * (i - 1)); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = n / 2; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= n - (2 * (i - 1)); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void star4(int n) {
		for (int i = 1; i <= (n + 1) / 2; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (n + 1) / 2 - i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = n / 2; i >= 1; i--) {
			for (int j = 1; j <= n / 2; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (n + 1) / 2 - i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		if (n % 2 == 0)
			System.out.println("INPUT ERROR!");
		else if (m == 1)
			star1(n);
		else if (m == 2)
			star2(n);
		else if (m == 3)
			star3(n);
		else if (m == 4)
			star4(n);
		else
			System.out.println("INPUT ERROR!");

	}

}
