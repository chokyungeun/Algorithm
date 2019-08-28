package tree;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_1233_사칙연산유효성검사_서울9반_조경은 {
	public static int N;
	public static String[] a;
	public static int op;
	public static int num;
	
	public static void inorder(int i) {
		if(1<=i && i<=N && a[i]!="") { 
			inorder(2*i);
			
			if(a[i].equals("+") || a[i].equals("-") || a[i].equals("/") || a[i].equals("*")) {
				op++;
			}
			else {
				num++;
			}
			inorder(2*i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1233.txt"));
		Scanner sc = new Scanner(System.in);
		for(int T=1; T<11; T++) {
			int res = 0;
			op = 0;
			num = 0;
			String sn = sc.nextLine();
			N = Integer.parseInt(sn);
			a = new String[N+1];
			
			for(int i=1; i<=N; i++) {
				 String s = sc.nextLine();
				 String[] st = s.split(" ");
				 a[Integer.parseInt(st[0])] = st[1];
			}
			inorder(1);
			if(num - op == 1)
				res = 1;
			System.out.println("#" + T + " " + res);
			
			
			
		}
	}

}

