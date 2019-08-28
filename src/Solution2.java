import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution2 {
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] sa = line.split(" ");
		int T = Integer.parseInt(sa[0]);
		
		for(int tc = 1; tc <= 10; tc++) {
			
			System.out.println("#" + tc);

		}
		br.close();
	}
}