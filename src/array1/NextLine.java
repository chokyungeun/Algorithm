package array1;

import java.util.Arrays;
import java.util.Scanner;

public class NextLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		String[] sa = line.split(" ");
		System.out.println(Arrays.toString(sa));
		
		String s = sc.next();
		char[] ca = s.toCharArray();
		System.out.println(Arrays.toString(ca));
		
		/*int t=Integer.parseInt(sc.nextLine());
		String s1 = sc.nextLine();
		//sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(t + "[" + s1 + "][" + s2 + "]");
		*/
	}
}
