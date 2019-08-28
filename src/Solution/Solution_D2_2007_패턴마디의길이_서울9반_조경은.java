package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_2007_패턴마디의길이_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_2007.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<T+1; tc++) {
			String s = sc.next();
			int len = 0;
			for(int i=1; i<30; i++) {
				if((s.substring(0, i)).equals(s.substring(i, i*2))) {
					len = i;
					break;
				}
			}
			System.out.println("#" + tc + " " + len);
		}
	}

}
