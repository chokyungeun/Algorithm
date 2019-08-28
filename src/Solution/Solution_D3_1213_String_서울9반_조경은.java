package Solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_1213_String_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_1213.txt"));
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<11; t++) {
			int res = 0;
			String s = sc.nextLine();
			int T = Integer.parseInt(s);
			String se = sc.nextLine();
			s=sc.nextLine();
			char[] arr = s.toCharArray();
			for(int i=0; i<arr.length-se.length()+1; i++) {
				String x = "";
				for(int j=i; j<i+se.length(); j++) {
					x+=arr[j];
				}
				if(x.equals(se)) {
					res++;
				}
			}
			System.out.println("#" + T + " " + res);
		}
	}

}
