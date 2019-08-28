package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_1989_초심자의회문검사_서울9반_조경은 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1989.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<T+1; tc++) {
			int result = 0;
			String s = sc.next();
			StringBuilder sb = new StringBuilder(s);
			sb = sb.reverse();
			
			if(s.equals(sb.toString()))
				result = 1;
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
