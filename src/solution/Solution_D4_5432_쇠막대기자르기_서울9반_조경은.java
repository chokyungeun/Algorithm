package solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_5432_쇠막대기자르기_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5432.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<T+1; tc++) {
			String s = sc.next();
			char[] arr = new char[s.length()];
			arr = s.toCharArray();
			int res = 0;
			int n = 0;
			for(int i=0; i<arr.length-1; i++) {
				if(arr[i] == '(') {
					if(arr[i+1]!=')')
						n++;
					else {
						res += n;
						i++;
					}
				}
				else {
					res++;
					n--;
				}
			}
			res += n;
			System.out.println("#" + tc + " " + res);
		}
	}
}

