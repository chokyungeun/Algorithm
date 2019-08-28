import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution {
	public static void main(String args[]) throws Exception {
		
		/*System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			System.out.println("#" + tc);

		}
		sc.close();*/
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(s.length());
	}
}