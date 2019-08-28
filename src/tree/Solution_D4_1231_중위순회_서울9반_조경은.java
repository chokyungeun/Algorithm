package tree;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_1231_중위순회_서울9반_조경은 {
	public static int N;
	public static char[] a;
	
	public static void inorder(int i) {
		if(1<=i && i<=N && a[i]!='\u0000') { //a[i] != '\u0000'
			inorder(2*i);
			System.out.print(a[i]);
			inorder(2*i+1);
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1231.txt"));
		Scanner sc = new Scanner(System.in);
		for(int T=1; T<11; T++) {
			String sn = sc.nextLine();
			N = Integer.parseInt(sn);
			a = new char[N+1];
			int[] left = new int[N+1];
			int[] right = new int[N+1];
			for(int i=1; i<=N; i++) {
				 String s = sc.nextLine();
				 String[] st = s.split(" ");
				 a[Integer.parseInt(st[0])] = st[1].charAt(0);
				 
			}
			System.out.print("#" + T + " ");
			inorder(1);
			System.out.println();
		}
		
	}

}
