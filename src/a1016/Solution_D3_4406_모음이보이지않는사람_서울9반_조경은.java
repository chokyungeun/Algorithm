package a1016;

import java.io.*;

public class Solution_D3_4406_모음이보이지않는사람_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<T+1; tc++) {
			String s = br.readLine();
			
			s = s.replace("a", "");
			s = s.replace("e", "");
			s = s.replace("i", "");
			s = s.replace("o", "");
			s = s.replace("u", "");
			
			System.out.println("#" + tc + " " + s);
		}
	}
}
